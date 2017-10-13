package studyarea.resource.servlet;


import domain.Resource;
import domain.User;
import studyarea.resource.dao.impl.ResourceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 此类实现客户端查看学习资源请求访问的服务端
 * 请求参数：资源id  r_id
 * 查询资源表
 * 返回参数：资源名称 r_name,上传时间r_uptime,描述desp,时长duration,文件大小filesize,课程方向major,课程类型genre
 * Created by huangwei on 17-7-24.
 */
public class DetailsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //设置请求格式
        response.setCharacterEncoding("utf-8");
        //获取资源的id
        String r_id=request.getParameter("r_id");
        //获取当前用户的id
        User user=(User) request.getSession().getAttribute("user");
        String u_id=null;
        if(null!=user) {
            u_id = user.getU_id();
        }
        //String u_id=request.getParameter("u_id");
        //把用户id存入session中
        //request.getSession().setAttribute("u_id",u_id);
        //创建Dao对象
        ResourceDaoImpl resourceDaoImpl=new ResourceDaoImpl();
        //调用ResourceDaoImpl类中的ckDetails()方法
        //ArrayList list=resourceDaoImpl.ckDetails(r_id);
        Resource resource=resourceDaoImpl.ckDetails(r_id);
        //把u_id和r_id传给页面
        request.setAttribute("u_id",u_id);
        request.setAttribute("r_id",r_id);
        //把list保存到request的作用域中
        request.setAttribute("resource",resource);
        //跳转到detials.jsp页面
        request.getRequestDispatcher("/details.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
