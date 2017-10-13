package loginregist.dao;
/**
 * 这个类主要为JDBC
 * 创建与数据库的链接
 * 然后判断数据库中是否有这个数据

 */
//导包


import domain.User;
import utils.MD5Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//创建一个链接数据库的类
public class RegistDao {
    //创建方法判断邮件是否在数据中
    public boolean cKemail(String email) throws ClassNotFoundException, Exception{
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select count(*) from user where email='"+email+"'";
        //执行sql语句
        ResultSet resulSet = statement.executeQuery(sql);
        //判断数据库中是否有存在邮件
        while(resulSet.next()){
            //得到结果1 行第一列
            String count=resulSet.getString(1);
            //如果这个没有就返回true
            if(count.equals("0")){
                return true;
            }
        }
        //如果有返回false
        return false;
    }
    ////创建方法判断用户名是否在数据库中
    public boolean cKuserName(String userName) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select count(*) from user where u_name='"+userName+"'";
        //判断数据库中是否有存在用户名
        ResultSet resulSet = statement.executeQuery(sql);
        while(resulSet.next()){
            //得到结果1
            String count=resulSet.getString(1);
            if(count.equals("0")){
//				String str="insert into user_common(u_c_name) values('"+userName+"')";
//				int resulSete = statement.executeUpdate(str);
                //如果这个没有就返回true
                //System.out.println(resulSete);
                return true;
            }

        }
        return false;
    }

    ////创建方法判断用户名是否在数据库中
    public boolean cKphone(String phone) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select count(*) from user where phone='"+phone+"'";
        //判断数据库中是否有存在用户名
        ResultSet resulSet = statement.executeQuery(sql);
        while(resulSet.next()){
            //得到结果1
            String count=resulSet.getString(1);
            if(count.equals("0")){
//				String str="insert into user_common(u_c_name) values('"+phone+"')";
//				int resulSete = statement.executeUpdate(str);
                //如果这个没有就返回true
                //System.out.println(resulSete);
                return true;
            }

        }
        return false;
    }

    ////创建方法判断用户名是否在数据库中
    public boolean cKuser(User user) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        //String aa=user.getUserName();
        String jmPwd= MD5Util.encode2hex(user.getPwd());
        //写sql语句
        String str="insert into user(u_name,identify,phone,email,pwd,status,gender,photo)"
                + "values('"+user.getU_name()+"','"+user.getIdentify()+"','"+user.getPhone()+"'" +
                ",'"+user.getEmail()+"','"+jmPwd+"','"+user.getStatus()+"','"+user.getGender()+"','"+user.getPhoto()+"')";
        int resulSete = statement.executeUpdate(str);
        //如果这个没有就返回true
        //System.out.println(resulSete);
        if(resulSete==1){
            return true;
        }else{
            return false;
        }

    }

    public boolean cKstudent(String userName ,String phone) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select d_phone from student where d_name='"+userName+"'";
        //判断数据库中是否有存在用户名
        ResultSet resulSet = statement.executeQuery(sql);
        //System.out.println("+++"+userName+"     "+passWord);
        boolean boo=false;
        while(resulSet.next()){
            //得到结果1
            String phone1=resulSet.getString(1);
            if(null==phone||null==phone1){
                boo=false;
            }
            else if(phone1.equals(phone)){
                boo=true;
            }else{
                boo=false;
            }
        }
        System.out.println("+++++++"+boo);
        return boo;
    }





}




