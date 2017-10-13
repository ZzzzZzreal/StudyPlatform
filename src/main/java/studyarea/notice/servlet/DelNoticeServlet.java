package studyarea.notice.servlet;

import domain.Data;
import domain.User;
import studyarea.notice.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * DelNoticeServlet，删除公告通知的接口
 */
public class DelNoticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //创建一个Data
        Data data = new Data();

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf8");
        //设置响应的数据类型
        resp.setContentType("application/json;charset = utf-8");
        //获取请求方式
        String method = req.getMethod();
        String u_id = null;
        String character = null;
        try {
            //获取请求参数
            u_id = ((User) req.getSession().getAttribute("user")).getU_id();
            character = ((User) req.getSession().getAttribute("user")).getIdentify();
        } catch (NullPointerException e) {
//            e.printStackTrace();
            data.setNote("请先登录！！");
            req.setAttribute("msg",data);
            req.getRequestDispatcher("/delNotice.jsp").forward(req,resp);
        }
        String n_id = req.getParameter("n_id");


        //服务器日志：打印输出接收的参数---用户id、用户身份、公告id
        System.out.println("DelNoticeServlet 用户id："+u_id);
        System.out.println("DelNoticeServlet 用户身份："+character);
        System.out.println("DelNoticeServlet 公告id："+n_id);


        //创建NoticeService对象
        NoticeService noticeService = new NoticeService();
        //调用doDelete方法
        data = noticeService.doDelete(data,n_id,u_id,character);
        //响应值
        req.setAttribute("notice",data);
        //服务器日志：返回给客户端的notice javabean
        System.out.println("DelNoticeServlet 返回给客户端的notice："+data);
        //转发
        req.getRequestDispatcher("/delNotice.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
