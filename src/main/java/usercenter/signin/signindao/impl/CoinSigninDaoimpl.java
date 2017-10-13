package usercenter.signin.signindao.impl;

import usercenter.signin.signindao.CoinSigninDao;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by hp on 17-7-27.
 */
public class CoinSigninDaoimpl implements CoinSigninDao {
    public boolean coinSigninDao(String u_id) {

        Connection conn=null;
        Statement createStatement=null;
        ResultSet executeQuery=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到sql语句的对象
            createStatement = conn.createStatement();
            //判断几天为星期几
            java.util.Date today=new java.util.Date();
            Calendar c=Calendar.getInstance();
            c.setTime(today);
            int weekday=c.get(Calendar.DAY_OF_WEEK);
            //执行sql语句
            String sql=null;
            switch (weekday){
                case 1:sql="select sunday from signintable where u_id='"+u_id+"'";
                break;
                case 2:sql="select monday from signintable where u_id='"+u_id+"'";
                break;
                case 3:sql="select uesday from signintable where u_id='"+u_id+"'";
                break;
                case 4:sql="select wednesday from signintable where u_id='"+u_id+"'";
                break;
                case 5:sql="select thursday from signintable where u_id='"+u_id+"'";
                break;
                case 6:sql="select friday from signintable where u_id='"+u_id+"'";
                break;
                case 7:sql="select saturday from signintable where u_id='"+u_id+"'";
                break;
            }
            System.out.println("这是签到的"+sql);
            executeQuery=createStatement.executeQuery(sql);
            //处理结果
            while (executeQuery.next()){
                if (executeQuery.getString(1).equals("已签到")){
                    System.out.println(executeQuery.getString(1));
                    return true;
                }
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                createStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                executeQuery.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return false;
    }
}
