package studyarea.evalute.dao.impl;

import domain.Evalute;
import domain.User;
import studyarea.evalute.dao.FindEvaluteDao;
import utils.NowDate;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by yrq on 17-7-26.
 */
public class FindEvaluteDaoImpl implements FindEvaluteDao {


    String url = "jdbc:mysql://192.168.3.230:3306/studyplatform?"
            + "user=test&password=!@12QWqw&useUnicode=true&characterEncoding=UTF8";

    public ArrayList evalute(String c_id) {


        Connection conn = null;
        String sql;
        ArrayList arrayList = new ArrayList();


        try {

            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select * from evalute where c_id='"+c_id+"'";

            System.out.println(sql);

            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                System.out.println("222222");
                String eid=result.getString("e_id");
                String cid=result.getString("c_id");
                String evalute = result.getString("evalute");
                String e_datetime = result.getString("e_datetime");

                Evalute evalute1 =new Evalute();

                evalute1.setcId(cid);
                evalute1.setDatetime(e_datetime);
                evalute1.setEvalute(evalute);
                evalute1.seteId(eid);
                arrayList.add(evalute1);


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