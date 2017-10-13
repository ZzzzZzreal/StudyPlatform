package usercenter.signin.servlet;

import domain.CoinDetails;
import domain.User;
import usercenter.signin.service.CilckSigninService;
import usercenter.signin.service.impl.ClickServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 17-7-25.
 */
public class CilckSigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求编码
        request.setCharacterEncoding("utf-8");
        //获取响应编码
        response.setCharacterEncoding("utf-8");
        //设置响应的数据类型
        response.setContentType("application/json;charset=utf-8");
        //获取客户端参数
        String s_id=null;
        try {
            User id=(User)request.getSession().getAttribute("user");
            s_id = id.getU_id();
        } catch (Exception e) {
            e.printStackTrace();
            //跳转页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;

        }

        if (s_id==null||"".equals(s_id)){
            //调转至登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //创建对象
        CilckSigninService signinservice=new ClickServiceimpl();
        //调用方法
        boolean cilcksignins=signinservice.cilcksignin(s_id);
        //签到完成后调转页面
        if (cilcksignins==true){
        CoinDetails coinDetails=new CoinDetails("signin","1","签到","1");
        request.setAttribute("coinDetails",coinDetails);
        request.getRequestDispatcher("/alterCoinServlet").forward(request,response);
        return;

        }else {

            request.getRequestDispatcher("/signin").forward(request,response);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
