package loginregist.servlet;
/**
 * 创建链接 请求方式
 * 获取客户端的消息
 * 然后将客户端的消息发送到javaBean中
 * 判断是否存在
 */
//导包


import domain.UsersData;
import loginregist.dao.RegistDao;
import loginregist.service.CKEmailService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//创建类继承HttpServlet
public class CKemailServlet extends HttpServlet {
    //创建doGet方法完成对邮件是否合法验证
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //将服务端编码设置为UTF-8
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //创建UserData 对象然后Get数据
        UsersData user=new UsersData();
        //接收到来自客户端的2email的数据
        String email =request.getParameter("email");
        //创建CKEmailService 对象
        CKEmailService ckemailservice=new CKEmailService();
        //调用判断方法对email的格式进行判断
        boolean ckel=ckemailservice.cKemailServise(email);
        //如果registdao返回值为true进行
        if(ckel){
            RegistDao registdao=new RegistDao();
            try {
                //判断是数据库中是否存在邮箱
                boolean reg=registdao.cKemail(email);
                //如果返回为true
                if(reg){
                    response.getWriter().print(reg);
                }else {
                    response.getWriter().print(reg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //创建Post请求将Post请求调用get请求转换为get请求
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

