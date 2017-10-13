package usercenter.userInfo.servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yrq on 17-7-25.
 */
public class AllImgServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf8");

        Object object= req.getSession().getAttribute("user");
        User user=(User)object;
        if(user!=null){
       String    photo=  user.getPhoto();

            req.setAttribute("photo", photo);
            req.getRequestDispatcher("/userCenter.jsp").forward(req, resp);
        }
        else{

            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
