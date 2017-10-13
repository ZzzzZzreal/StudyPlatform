package studyarea.resource.servlet;
/**
 * 搜索课程
 */

import studyarea.resource.dao.impl.NameID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SearchServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //设置响应编码格式
        resp.setCharacterEncoding("utf8");
        //设置响应的数据类型
        resp.setContentType("text/html;charset=utf-8");

        //获取请求参数
        String course = req.getParameter("course");
        String context = req.getParameter("searching");
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
        String sql=null;
        if(context==null){
            sql="select r_name from resource where major='"+course+"' ";
        }else {
            sql = "select r_name from resource where major='" + course + "' and r_name like '%"+context+"%' ";
        }
        System.out.println(sql);
        try {
            result = createStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<String> strings=new ArrayList<String>();
        try {
            if (result != null) {
                if(!result.next()){
                    strings.add("无结果");
                }
                else {
                    strings.add("<a href=" + "/details?r_id=" + NameID.doGetID(result.getString(1))+ ">" + result.getString(1) + "</a>");;
                    while (result.next()) {
                        strings.add("<a href=" + "/details?r_id=" + NameID.doGetID(result.getString(1)) + ">" + result.getString(1) + "</a>");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("infor",strings);
        req.getRequestDispatcher("/studyArea.jsp").forward(req,resp);


    }
}
