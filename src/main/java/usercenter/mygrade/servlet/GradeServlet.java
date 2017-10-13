package usercenter.mygrade.servlet;
/**
 * 查看成绩
 */

import domain.Score;
import domain.User;
import studyarea.resource.dao.impl.NameID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class GradeServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf8");
        //设置响应的数据类型
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        User user= (User)req.getSession().getAttribute("user");
        String u_id=user.getU_id();
        /**
         * 链接数据库查询结果，输出
         */
        Connection connection = null;
        Statement createStatement = null;
        ResultSet result = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform?useUnicode=true&characterEncoding=utf8","test","!@12QWqw");
            //得到执行sql语句的对象
            createStatement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql="select s_course,score from score where u_id='"+u_id+"' ";
        System.out.println(sql);
        try {
            result = createStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<Score> grade=new ArrayList<Score>();
        try {
            if (result != null) {
                if(!result.next()){
                    grade.add(new Score("未选修课程","无成绩"));
                }
                else {
                    grade.add(new Score(result.getString(1),result.getString(2)));
                    while (result.next()) {
                        grade.add(new Score(result.getString(1),result.getString(2)));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("infor",grade);
        req.getRequestDispatcher("/userCenter.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
