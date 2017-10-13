package utils;


import java.sql.*;



/**
 * 这里是项目的JDBC_Util工厂类，实现JDBC连接数据库的相关操作*
 */

public class JDBC_Util {

    public static Connection connection = null;
    public static Statement createStatement = null;

    public static Statement doJDBC(){

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            createStatement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return createStatement;
    }

    public static void close(Statement arrCreateStatement){


        try {
            connection.close();
            createStatement.close();
            arrCreateStatement.close();
        } catch (SQLException e) {
//            e.printStackTrace();
        }
    }

}

