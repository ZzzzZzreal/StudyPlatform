package usercenter.mytracks.servlet;

import domain.Data;
import domain.User;
import studyarea.notice.service.NoticeService;
import usercenter.mytracks.service.MyTracksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelMyDownload extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf8");
        //设置响应的数据类型
        resp.setContentType("application/json;charset = utf-8");
        //获取请求方式
        String method = req.getMethod();
        String u_id = null;
        try {
            //获取请求参数
            u_id = ((User) req.getSession().getAttribute("user")).getU_id();
        } catch (NullPointerException e) {
//            e.printStackTrace();
        }
        String r_id = req.getParameter("r_id");


        //服务器日志：打印输出接收的参数---用户id、资源id
        System.out.println("DelMyDownloadServlet 用户id："+u_id);
        System.out.println("DelMyDownloadServlet 资源id："+r_id);


        //创建MyTracksService对象
        MyTracksService myTracksService = new MyTracksService();
        //调用doDelMyDownload方法
        myTracksService.doDelMyDownload(r_id,u_id);
        //响应值
        req.setAttribute("msg","删除成功！");
        //转发
        req.getRequestDispatcher("/delMyTracks.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
