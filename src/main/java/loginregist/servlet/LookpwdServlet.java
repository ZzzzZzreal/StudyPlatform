package loginregist.servlet;

import domain.User;
import loginregist.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * Created by ch on 17-7-25.
 * 这个类主要是为了进行对找回密码
 */
public class LookpwdServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //进行对客户端编码问题处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //创建Users 对象 然后Get数据 将数据传到javaBean 里
        //将客户端传来的消息得到
        String userName = request.getParameter("username");
        String phone = request.getParameter("phone");
        LoginDao loginDao=new LoginDao();

        String u_id= null;
        try {
            u_id = loginDao.serch(userName).getU_id();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        boolean log=false;

        try {
            log = loginDao.cKuserphone(userName, phone);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("-------"+log);
        if(log==true) {
            request.setAttribute("u_id",u_id);
            System.out.println("llllllllll"+u_id);
            request.getRequestDispatcher("/lookpwdtrue.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}