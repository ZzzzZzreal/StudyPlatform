package loginregist.servlet;

import loginregist.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by ch on 17-7-25.
 * 进行修改密码的类
 *
 */
public class LookpwdTrueServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //进行对客户端编码问题处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //创建Users 对象 然后Get数据 将数据传到javaBean 里
        //将客户端传来的消息得到
        String u_id =request.getParameter("u_id");
        String passWord =request.getParameter("password");
        System.out.println("======"+u_id);
        LoginDao loginDao=new LoginDao();
        boolean boo=false;
        try {
            boo=loginDao.looktrue(u_id,passWord);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (boo){
            System.out.println("llllllllll"+passWord);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/regist.jsp").forward(request,response);

        }
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
