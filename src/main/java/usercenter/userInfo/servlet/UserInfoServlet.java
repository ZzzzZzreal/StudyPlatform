package usercenter.userInfo.servlet;

import com.sun.xml.internal.ws.transport.http.HttpAdapter;
import domain.User;
import usercenter.userInfo.service.UserInfoService;
import usercenter.userInfo.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public class UserInfoServlet extends HttpServlet {
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


          UserInfoService userInfoService = new UserInfoServiceImpl();
          ArrayList arrayList = userInfoService.findAllUser(uid);

          req.setAttribute("user", arrayList);
          req.getRequestDispatcher("/userInfo.jsp").forward(req, resp);
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
