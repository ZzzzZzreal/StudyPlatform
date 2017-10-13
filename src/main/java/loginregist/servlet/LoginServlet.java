package loginregist.servlet;
/**
 * 创建链接 请求方式
 * 获取客户端的消息
 * 然后将数据
 * 出传到javaBean中
 * 此类为主要的链接类
 *
 */
//导包


import domain.User;
import loginregist.dao.LoginDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//.创建类继承HttpSerclet
public class LoginServlet extends HttpServlet {
    /**
     * 创建doGet doPost方法进行请求
     * 处理乱码问题
     * 获取从客户端发来的消息进行处理
     * 并对密码进行加密处理
     * 然后对客户端进行相应
     * 完成交互
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //进行对客户端编码问题处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //创建Users 对象 然后Get数据 将数据传到javaBean 里
        //将客户端传来的消息得到
        String userName =request.getParameter("username");
        String passWord =request.getParameter("password");

        //进行编码的处理,解决乱码问题

        //创建对象将数据传到dao中
        LoginDao Loging=new LoginDao();
        User user= null;
        try {
            user = Loging.serch(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("user",user);

        boolean log=false;

        try {
            log = Loging.cKuserName(userName, passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(log==true) {
            request.setAttribute("uname","欢迎 "+user.getU_name());
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }else {
            request.setAttribute("msg","登陆失败");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}




