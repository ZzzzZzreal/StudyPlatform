package usercenter.userInfo.dao.impl;

import domain.User;
import usercenter.userInfo.dao.UserInfoDao;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public class UserInfoDaoImpl implements UserInfoDao {

    String url = "jdbc:mysql://192.168.3.230:3306/studyplatform?"
            + "user=test&password=!@12QWqw&useUnicode=true&characterEncoding=UTF8";

    public   ArrayList findAllUser(String u_id){
        System.out.println(u_id);
        Connection conn = null;
        String sql;
        ArrayList arrayList=new ArrayList();


        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql="select * from user where u_id='"+u_id+"'";

            System.out.println(sql);

            ResultSet result= stmt.executeQuery(sql);

            while(result.next()){
                System.out.println("222222");
               String uid=result.getString("u_id");
               String u_name=result.getString("u_name");
               String identify=result.getString("identify");
               String phone =result.getString("phone");
               String email=result.getString("email");
               String pwd=result.getString("pwd");
               String status=result.getString("status");
               String gender=result.getString("gender");
               String photo =result.getString("photo");

               User user=new User();

               user.setU_name(u_name);
               user.setPwd(pwd);
               user.setEmail(email);
               user.setIdentify(identify);
               user.setPhoto(photo);
               user.setPhone(phone);
               user.setStatus(status);
               user.setGender(gender);

               arrayList.add(user);


            }


        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return arrayList;
    }

    public Boolean updateUser(User user){
        String uid=user.getU_id();
        String email = user.getEmail();
        String u_name=user.getU_name();
        String pwd=user.getPwd();
        String phone=user.getPhone();
        String identify=user.getIdentify();
        String status=user.getStatus();
        String gender=user.getGender();
        String photo =user.getPhoto();

        Connection conn = null;
        String sql;
        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();


            sql = "update user set  email='"+email+"', phone='"+phone+"',gender='"+gender+"' where u_id='"+uid+"'";

            System.out.println(sql);
            int result=   stmt.executeUpdate(sql);
            if(result>0){
                System.out.println("数据添加成功");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }



    public Boolean updateImg(String img,String uid){

        Connection conn = null;
        String sql;
        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();


            sql = "update user set photo='"+img+"' where  u_id='"+uid+"'";

            System.out.println(sql);
            int result=   stmt.executeUpdate(sql);
            if(result>0){
                System.out.println("数据添加成功");
                return true;
            }

        } catch (SQLException e) {
            System.out.println("MySQL操作错误");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

}
