package studyarea.resource.dao.impl;

import java.sql.*;
import java.util.ArrayList;

public class NameID {
    public static String doGetID(String name){
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
        String sql = "select r_id from resource where r_name='"+name+"' ";

        System.out.println(sql);
        try {
            result = createStatement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String id=null;
        try {
            while(result.next()) {
               id=result.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return id;
    }
}
