package usercenter.signin.signindao.impl;

import usercenter.signin.signindao.ClickSigninDao;


import java.sql.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hp on 17-7-25.
 */
public class ClickSigninDaoimpl implements ClickSigninDao {
    public String clicksigbindao(String u_id) {
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
            Date today=new Date();
            Calendar c=Calendar.getInstance();
            c.setTime(today);
            int weekday=c.get(Calendar.DAY_OF_WEEK);
            //执行sql语句
            String sql=null;
            switch (weekday){
                case 1: sql="UPDATE signintable SET sunday='已签到' WHERE u_id='"+u_id+"'";
                break;
                case 2: sql="UPDATE signintable SET monday='已签到' WHERE u_id='"+u_id+"'";
                break;
                case 3: sql="UPDATE signintable SET uesday='已签到' WHERE u_id='"+u_id+"'";
                break;
                case 4: sql="UPDATE signintable SET wednesday='已签到' WHERE u_id='"+u_id+"'";
                break;
                case 5: sql="UPDATE signintable SET thursday='已签到' WHERE u_id='"+u_id+"'";
                    break;
                case 6: sql="UPDATE signintable SET friday='已签到' WHERE u_id='"+u_id+"'";
                    break;
                case 7: sql="UPDATE signintable SET saturday='已签到' WHERE u_id='"+u_id+"'";
                    break;
            }
            System.out.println(sql);
            //执行sql语句
            int in=createStatement.executeUpdate(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            executeQuery.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            createStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
