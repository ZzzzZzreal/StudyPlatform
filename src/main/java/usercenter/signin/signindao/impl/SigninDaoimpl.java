package usercenter.signin.signindao.impl;

import domain.SigninDomain;
import usercenter.signin.signindao.SigninDao;

import java.sql.*;

/**
 * 这个类为signindao的实现类
 * 对数据库进行操作
 * 查询签到表signintable内的签到情况
 * Created by hp on 17-7-24.
 */
public class SigninDaoimpl implements SigninDao {
    public SigninDomain findSigninu_id(String u_id)  {
        Connection conn=null;
        Statement createStatement=null;
        ResultSet executeQuery=null;
        SigninDomain sdomain=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到sql语句的对象
            createStatement = conn.createStatement();
            //执行sql语句
            String sql="select * from signintable WHERE u_id='"+u_id+"'";
            executeQuery= createStatement.executeQuery(sql);
             executeQuery= createStatement.executeQuery(sql);
            //处理结果
            if (executeQuery.next()) {
                String sid = executeQuery.getString("u_id");
                String monday= executeQuery.getString("monday");
                String uesday= executeQuery.getString("uesday");
                String wednesday=executeQuery.getString("wednesday");
                String thursday=executeQuery.getString("thursday");
                String friday=executeQuery.getString("friday");
                String saturday=executeQuery.getString("saturday");
                String sunday=executeQuery.getString("sunday");
                sdomain=new SigninDomain(u_id,monday,uesday,wednesday,thursday,friday,saturday,sunday);
                System.out.println(sql);
            }else{
              String sql1="insert into signintable (u_id)values('"+u_id+"')";
                System.out.println(sql1);
              int in=createStatement.executeUpdate(sql1);
              sdomain=new SigninDomain();
              sdomain.setS_id(u_id);
            }
           // sdomain.setS_id(s_id);

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


        return sdomain;
    }
}
