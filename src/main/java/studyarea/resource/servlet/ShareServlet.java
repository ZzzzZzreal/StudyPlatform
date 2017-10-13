package studyarea.resource.servlet;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 此类实现客户端分享访问的服务端
 * Created by huangwei on 17-7-25.
 */
public class ShareServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        //获取视频id
        String r_id=request.getParameter("r_id");
        //获取当前用户的id
        //获取当前用户的id
        User user=(User) request.getSession().getAttribute("user");
        String u_id=null;
        if(null!=user) {
            u_id = user.getU_id();
        }
        //把参数传给页面
        request.setAttribute("r_id",r_id);
        request.setAttribute("u_id",u_id);
        //条转页面
        request.getRequestDispatcher("/share.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
