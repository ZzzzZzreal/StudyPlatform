package studyarea.notice.dao;

import domain.Data;
import domain.Notice;
import utils.JDBC_Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * NoticeDao，公告通知的dao，用来执行对数据库notice表的操作
 */
public class NoticeDao {

    /**
     * doSelect方法，查询数据库
     * @param orderBy
     * @return
     */
    public Data doSelect(Data data, String orderBy,String author,String isMore) {

        System.out.println("NoticeDao 排序方式："+orderBy);
        ResultSet result = null;
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            String sql = "";
            if ("1".equals(isMore)){
                //执行sql语句

                if ("author".equals(orderBy)){
                    sql = "SELECT n_title,n_content,n_id,n_time,user.u_name FROM notice LEFT JOIN user ON notice.n_a_id = user.u_id WHERE user.u_name='"+author+"'"  ;
                }
                if ("time".equals(orderBy)){
                    sql = "SELECT n_title,n_content,n_id,n_time,user.u_name FROM notice LEFT JOIN user ON notice.n_a_id = user.u_id ORDER BY n_time DESC";
                }
            }else{
            //执行sql语句
            if ("author".equals(orderBy)){
                sql = "SELECT n_title,n_content,n_id,n_time,user.u_name FROM notice LEFT JOIN user ON notice.n_a_id = user.u_id WHERE user.u_name='"+author+"' LIMIT 0,10"  ;
            }
            if ("time".equals(orderBy)){
                sql = "SELECT n_title,n_content,n_id,n_time,user.u_name FROM notice LEFT JOIN user ON notice.n_a_id = user.u_id ORDER BY n_time DESC LIMIT 0,10";
            }
            }
            //获取通知的标题、内容、发布者
            result = createStatement.executeQuery(sql);
            //创建一个集合
            List<Notice> list = new ArrayList();
            while(result.next()) {
                //创建Notice对象
                Notice notice = new Notice();
                String arrTitle = result.getString("n_title");
                String arrContent = result.getString("n_content");
                String arrID = result.getString("n_id");
                String arrTime = result.getString("n_time");
                String arrAuthor = result.getString("u_name");
                //将数据存入Notice
                notice.setN_id(arrID);
                notice.setN_title(arrTitle);
                notice.setN_content(arrContent);
                notice.setN_time(arrTime);
                notice.setN_author(arrAuthor);
                //将同一个Notice放入集合
                list.add(notice);
            }
            data.setList(list);
            System.out.println(" 条件查询 数据库返回的data："+data);
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

    /**
     * doSelectDetail方法，查询数据库
     * @param
     * @return
     */
    public Data doSelectDetail(Data data, String n_id) {

        System.out.println("NoticeDao detail公告id："+n_id);
        ResultSet result = null;
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "SELECT * FROM notice WHERE n_id='"+n_id+"'";
            //获取通知的标题、内容、发布者
            result = createStatement.executeQuery(sql);
            //创建一个List
            List list = new ArrayList();
            while(result.next()) {
                //创建Notice对象
                Notice notice = new Notice();
                String arrContent = result.getString("n_content");
                String arrID = result.getString("n_id");
                //将数据存入Notice
                notice.setN_content(arrContent);
                notice.setN_id(arrID);
                //将同一个Notice放入集合
                list.add(notice);
                System.out.println("查看详情 数据库返回的 list："+list);
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

    public Data doDelete(Data data, String n_id) {
        System.out.println("NoticeDao delete公告id："+n_id);
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "DELETE FROM notice WHERE n_id='"+n_id+"'";
            //获取通知的标题、内容、发布者
            createStatement.executeUpdate(sql);
           data.setStatus("1");
           data.setNote("删除成功");
            System.out.println("删除通知 数据库返回的data："+data);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC_Util.close(createStatement);
        }
        return data;
    }

    public Data doAdd(Data data, String u_id, String n_title, String n_content) {

        //定义日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "INSERT INTO notice(n_a_id,n_title,n_content,n_time) VALUES " +
                    "('"+u_id+"','"+n_title+"','"+n_content+"','"+ sdf.format(new Date(System.currentTimeMillis()))+"')";
            //获取通知的标题、内容、发布者
            createStatement.executeUpdate(sql);
            data.setStatus("1");
            data.setNote("发布成功");
            System.out.println("发布通知 数据库返回的data："+data);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBC_Util.close(createStatement);
        }
        return data;
    }
}