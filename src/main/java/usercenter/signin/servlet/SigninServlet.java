package usercenter.signin.servlet;

import domain.SigninDomain;
import domain.User;
import usercenter.signin.service.SigninService;
import usercenter.signin.service.impl.SigninServiceimpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 这个类为列表的servlet
 * 设置编码格式
 * 获取数据
 * 调用方法对数据处理3
 * Created by hp on 17-7-24.
 */
public class SigninServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求编码
        request.setCharacterEncoding("utf-8");
        //获取响应编码
        response.setCharacterEncoding("utf-8");
        //设置响应的数据类型
        response.setContentType("application/json;charset=utf-8");
        //request.getSession().setAttribute("u_id","1");
        //获取客户端参数

        String u_id= null;
        try {
            User id=(User)request.getSession().getAttribute("user");
            u_id = id.getU_id();
        } catch (Exception e) {
            e.printStackTrace();
            //跳转页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;

        }
        System.out.println(u_id);
        //判断Session中u_id为null
        if (u_id==null||"".equals(u_id)){
            //调转至登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        //创建Service对象
        SigninService signinservice=new SigninServiceimpl();
        //根据用户id查询签到情况
        SigninDomain looksignin=signinservice.signinu_id(u_id);
        System.out.println(looksignin);
        //signin为变量名  looksignin  为要传送的数据
        request.setAttribute("signin",looksignin);
        //跳转页面
        request.getRequestDispatcher("/signin.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
