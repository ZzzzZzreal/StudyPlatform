package studyarea.notice.servlet;

import domain.Data;
import domain.Notice;
import domain.User;
import studyarea.notice.service.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNoticeServlet extends HttpServlet {

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
        //获取请求参数
        String u_id = null;
        String character = null;
        try {
            u_id = ((User) req.getSession().getAttribute("user")).getU_id();
            character = ((User) req.getSession().getAttribute("user")).getIdentify();
        } catch (NullPointerException e) {
//            e.printStackTrace();
            data.setNote("请先登录！！");
            req.setAttribute("msg",data);
            req.getRequestDispatcher("/addNotice.jsp").forward(req,resp);
        }
        String n_id = req.getParameter("n_id");
        String n_title = req.getParameter("n_title");
        String n_content = req.getParameter("n_content");


        //服务器日志：打印输出接收的参数---用户id、用户身份、公告id
        System.out.println("AddNoticeServlet 用户id："+u_id);
        System.out.println("AddNoticeServlet 用户身份："+character);
        System.out.println("AddNoticeServlet 公告id："+n_id);
        System.out.println("AddNoticeServlet 公告标题："+n_title);
        System.out.println("AddNoticeServlet 公告内容："+n_content);

        //创建NoticeService对象
        NoticeService noticeService = new NoticeService();
        //调用doAdd方法
        data = noticeService.doAdd(data,u_id,character,n_title,n_content);
        //响应值
        req.setAttribute("notice",data);
        //服务器日志：返回给客户端的notice javabean
        System.out.println("AddNoticeServlet 返回给客户端的notice："+data);
        //转发
        req.getRequestDispatcher("/addNotice.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
