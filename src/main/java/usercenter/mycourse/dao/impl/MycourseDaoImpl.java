package usercenter.mycourse.dao.impl;

import domain.Mycourse;
import domain.User;
import usercenter.mycourse.dao.MycourseDao;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by yrq on 17-7-24.
 */
public class MycourseDaoImpl implements MycourseDao {

    String url = "jdbc:mysql://192.168.3.230:3306/studyplatform?"
            + "user=test&password=!@12QWqw&useUnicode=true&characterEncoding=UTF8";



    public   ArrayList findMycourse(String u_id){
        System.out.println(u_id);
        Connection conn = null;
        String sql;
        ArrayList arrayList=new ArrayList();


        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql="select * from curriculum a left join appointment b on a.c_id=b.c_id where a.u_id ='"+u_id+"'";

            System.out.println(sql);

            ResultSet result= stmt.executeQuery(sql);

            while(result.next()){
                System.out.println("222222");

               String c_id=result.getString("c_id");
               String c_name=result.getString("c_name");
               String c_type=result.getString("c_type");

               Date start=result.getDate("start");
               Date end=result.getDate("end");
               Time begin=result.getTime("begin");
               Time terminal=result.getTime("terminal");
               String introduce=result.getString("introduce");

                System.out.println(c_name);
                System.out.println(start);
                Mycourse mycourse=new Mycourse();
                mycourse.setcId(c_id);
                mycourse.setcName(c_name);
                mycourse.setcType(c_type);
                mycourse.setIntroduce(introduce);
                mycourse.setStart(start);
                mycourse.setEnd(end);
                mycourse.setBegin(begin);
                mycourse.setTerminal(terminal);

                arrayList.add(mycourse);


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





}
