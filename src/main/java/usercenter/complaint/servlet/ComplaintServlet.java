package usercenter.complaint.servlet;

import domain.Data;
import domain.User;
import usercenter.complaint.service.ComplaintService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ComplaintServlet extends HttpServlet {

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
            req.setAttribute("msa","请先登录！！");
            req.getRequestDispatcher("/userCenter.jsp").forward(req,resp);
        }
        String cp_content = req.getParameter("cp_content");


        //服务器日志：打印输出接收的参数---用户id、用户身份
        System.out.println("ComplaintServlet 用户id："+u_id);
        System.out.println("ComplaintServlet 用户身份："+character);
        System.out.println("ComplaintServlet 意见内容："+cp_content);

        //创建ComplaintService对象
        ComplaintService complaintService = new ComplaintService();
        if ("admin".equals(character)){
            //调用doRead方法
            data = complaintService.doRead(data);
            //响应值
            req.setAttribute("complaint", data.getList());
            //服务器日志：返回给客户端的notice javabean
            System.out.println("ComplaintServlet 返回给客户端的notice：" + data);
            //转发
            req.getRequestDispatcher("/readComplaint.jsp").forward(req, resp);
        }else {
            if (null==cp_content){
                req.setAttribute("msg","请输入意见内容！");
                //转发
                req.getRequestDispatcher("/addComplaint.jsp").forward(req, resp);
            }else {
                //调用doAdd方法
                data = complaintService.doAdd(data, u_id, character, cp_content);
                //响应值
                req.setAttribute("complaint", data);
                //服务器日志：返回给客户端的notice javabean
                System.out.println("ComplaintServlet 返回给客户端的notice：" + data);
                //转发
                req.getRequestDispatcher("/addComplaint.jsp").forward(req, resp);
            }
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
