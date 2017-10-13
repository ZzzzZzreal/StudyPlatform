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
public class LoginDao {
    ////创建方法判断用户名是否在数据库中
    public boolean cKuserName(String userName ,String passWord) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select pwd from user where u_name='"+userName+"'";
        //判断数据库中是否有存在用户名
        ResultSet resulSet = statement.executeQuery(sql);
        //System.out.println("+++"+userName+"     "+passWord);
        boolean boo=false;
        while(resulSet.next()){
            //得到结果1
            String pwd=resulSet.getString(1);
            if(null==pwd){
                boo=false;
            }
            else if(pwd.equals(MD5Util.encode2hex(passWord))){
                boo=true;
            }else{
                boo=false;
            }
        }
        return boo;
    }
    public User serch(String userName)throws SQLException, ClassNotFoundException{
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select * from user where u_name='"+userName+"'";
        //判断数据库中是否有存在用户名
        ResultSet resulSet = statement.executeQuery(sql);
        String u_id=null;
        String u_name=null;
        String identify=null;
        String phone=null;
        String status=null;
        String gender=null;
        String photo=null;
        while(resulSet.next()){
//            //得到结果1
//              String email,
//                    String pwd, String status, String gender, String photo
            u_id=resulSet.getString("u_id");
            u_name=resulSet.getString("u_name");
            identify=resulSet.getString("identify");
            phone=resulSet.getString("phone");
            status=resulSet.getString("status");
            gender=resulSet.getString("gender");
            photo=resulSet.getString("photo");
        }
        //String u_id, String u_name, String identify, String phone, String email,  String status, String gender
        User user=new User(u_id,u_name,identify,phone,status,gender,photo);
        return user;
    }

    public boolean cKuserphone(String userName ,String phone) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        //写sql语句
        String sql="select phone from user where u_name='"+userName+"'";
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

    public boolean looktrue(String u_id ,String passWord) throws SQLException, ClassNotFoundException {
        //加载驱动 用Class 类进行
        Class.forName("com.mysql.jdbc.Driver");
        //创建与数据库的链接主要用了DriverManager这个静态类的方法
        Connection connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
        //得到执行Sql语句的对象
        Statement statement = connection.createStatement();
        String jmPwd= MD5Util.encode2hex(passWord);
        //写sql语句
        String sql="update user set pwd='"+jmPwd+"' where u_id='"+u_id+"'";
        //判断数据库中是否有存在用户名
        int resulSet = statement.executeUpdate(sql);
        //System.out.println("+++"+userName+"     "+passWord);
        boolean boo=true;

        return boo;
    }


}








