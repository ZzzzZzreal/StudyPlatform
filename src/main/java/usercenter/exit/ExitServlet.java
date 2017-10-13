package usercenter.exit;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ExitServlet,退出登录的接口，实现退出登录的功能
 *这个接口从客户端获取用户id参数，以明确是谁退出登录。
 * 服务器获取到用户id之后清除session中的信息，页面跳转到起始页
 */
public class ExitServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置请求编码格式
        req.setCharacterEncoding("utf-8");
        //获取请求参数---uid，获取用户id以明确是谁退出登录
        String u_id = null;
        try {
            u_id = ((User) req.getSession().getAttribute("user")).getU_id();
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("注销错误：用户尚未登录！");

        }
        //服务器日志：打印要退出的用户id
        System.out.println("exit的用户id:"+u_id);
        req.getSession().invalidate();
        //跳转到首页
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doPost(req,resp);
    }
}
