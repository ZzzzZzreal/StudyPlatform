package usercenter.complaint.dao;

import domain.Complaint;
import domain.Data;
import utils.JDBC_Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComplaintDao {

    public Data doAdd(Data data, String u_id, String cp_content) {
        //定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "INSERT INTO complaint (cp_a_id,cp_content,cp_time,cp_status) VALUES " +
                    "('"+u_id+"','"+cp_content+"','"+ sdf.format(new Date(System.currentTimeMillis()))+"','0')";
            //获取通知的标题、内容、发布者
            createStatement.executeUpdate(sql);
            data.setStatus("1");
            data.setNote("发布成功");
            System.out.println("发布通知 数据库返回的data："+data);
        } catch (SQLException e) {
            e.printStackTrace();
            data.setStatus("0");
            data.setNote("发布失败");
            System.out.println("发布通知 数据库返回的data："+data);
        }finally {
            JDBC_Util.close(createStatement);
        }
        return data;
    }

    public Data doRead(Data data) {
        ResultSet result = null;
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "SELECT * FROM complaint";
            //获取意见反馈的内容、发布者、发布时间、回复状态
            result = createStatement.executeQuery(sql);
            //创建一个List
            List list = new ArrayList();
            while(result.next()) {
                //创建Complaint对象
                Complaint complaint = new Complaint();
                String arrContent = result.getString("cp_content");
                String arrID = result.getString("cp_id");
                String arrAID = result.getString("cp_a_id");
                String arrTime = result.getString("cp_time");
                String arrStatus = result.getString("cp_status");
                //将数据存入Notice
                complaint.setCp_content(arrContent);
                complaint.setCp_id(arrID);
                complaint.setCp_a_id(arrAID);
                complaint.setCp_status(arrStatus);
                complaint.setCp_time(arrTime);
                //将同一个Notice放入集合
                list.add(complaint);
                System.out.println("查看意见反馈 数据库返回的 list："+list);
            }
            data.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC_Util.close(createStatement);
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
