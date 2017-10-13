package usercenter.mytracks.servlet;

import domain.Data;
import domain.User;
import usercenter.mytracks.service.MyTracksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MyDownloadServlet ,我的足迹-我的下载接口
 */
public class MyDownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Data data = new Data();

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf8");
        //设置响应的数据类型
        resp.setContentType("application/json;charset = utf-8");
        //获取请求参数
        String u_id = null;
        try {
            u_id = ((User) req.getSession().getAttribute("user")).getU_id();
        } catch (NullPointerException e) {
            req.setAttribute("msa","请先登录！！");
            req.getRequestDispatcher("/myTracks.jsp").forward(req,resp);
            return;
        }

        //创建MyTracksService对象
        MyTracksService myTracksService = new MyTracksService();
        data = myTracksService.myDownload(data,u_id);
        req.setAttribute("downLoad",data.getList());
        req.getRequestDispatcher("/myDownload.jsp").forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
