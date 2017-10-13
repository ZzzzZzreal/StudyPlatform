package usercenter.userInfo.servlet;

import domain.User;
import usercenter.userInfo.service.UserInfoService;
import usercenter.userInfo.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yrq on 17-7-24.
 */
public class UserUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");

        Object object= req.getSession().getAttribute("user");
        User user2=(User)object;
        String uid= user2.getU_id();

        String u_name=req.getParameter("uName");
        String identify=req.getParameter("identify");
        String phone =req.getParameter("phone");
        String email=req.getParameter("email");
        String pwd=req.getParameter("pwd");
        String status=req.getParameter("status");
        String gender=req.getParameter("gender");

        User user=new User();
        user.setGender(gender);
        user.setStatus(status);
        user.setPhone(phone);
        user.setIdentify(identify);
        user.setU_name(u_name);
        user.setU_id(uid);
        user.setEmail(email);
        user.setPwd(pwd);
        System.out.println(identify);

        UserInfoService userInfoService=new UserInfoServiceImpl();
        Boolean fale  = userInfoService.updateUser(user);
        if(fale){

            req.setAttribute("userinfo", "修改成功");
            req.getRequestDispatcher("/userCenter.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
