package usercenter.mycourse.servlet;

import domain.User;
import usercenter.mycourse.service.MycourseService;
import usercenter.mycourse.service.impl.MycourseServiceImpl;
import usercenter.userInfo.service.UserInfoService;
import usercenter.userInfo.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yrq on 17-7-26.
 */
public class MycourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");

        Object object= req.getSession().getAttribute("user");
        User user=(User)object;

        if(user!=null) {
            String uid= user.getU_id();
            System.out.println(uid);


            MycourseService mycourseService = new MycourseServiceImpl();

            ArrayList arrayList = mycourseService.findMycourse(uid);

            req.setAttribute("mycourse", arrayList);
            req.getRequestDispatcher("/mycourse.jsp").forward(req, resp);
        }
        else{

            req.setAttribute("msg", "请先登录");
            req.getRequestDispatcher("userCenter.jsp").forward(req,resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
