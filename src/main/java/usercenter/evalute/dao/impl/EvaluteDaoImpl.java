package usercenter.evalute.dao.impl;

import usercenter.evalute.dao.EvaluteDao;
import utils.NowDate;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by yrq on 17-7-26.
 */
public class EvaluteDaoImpl implements EvaluteDao{


    String url = "jdbc:mysql://192.168.3.230:3306/studyplatform?"
            + "user=test&password=!@12QWqw&useUnicode=true&characterEncoding=UTF8";
    public Boolean evalute(String c_id, String evalute) {

        Connection conn = null;
        String sql;
        //创建当前时间
        NowDate nowDate=new NowDate();
      String dateTime=  nowDate.nowDate();
        System.out.println(dateTime);


        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动

            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();


            sql = "insert into evalute (c_id,evalute,e_datetime)values('"+c_id+"','"+evalute+"','"+dateTime+"')" ;

            System.out.println(sql);
            int result=   stmt.executeUpdate(sql);
            if(result>0){
                System.out.println("评价成功");
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
