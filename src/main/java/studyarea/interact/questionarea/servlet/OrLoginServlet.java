package studyarea.interact.questionarea.servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 判断用户是否登陆
 * Created by jaques on 17-7-25.
 */
public class OrLoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setCharacterEncoding("utf-8");
        //获取请求方式
        String method=req.getMethod();
        //获取用户id
        Object object=  req.getSession().getAttribute("user");
        User user=(User)object;

       // String u_id="1";
        //如果id为空  表示用户未登陆
        if(null==user){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else{
            req.getRequestDispatcher("/questionarea.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
