package studyarea.resource.list.dao.impl;

import domain.ListDomain;
import studyarea.resource.list.dao.ListDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 这个类为listdao接口的实现类
 * 对数据库进行连接和操作
 * 查询数据库内resuource内的数据
 * 将其存到集合内返回
 * Created by hp on 17-7-25.
 */
public class ListDaoimpl implements ListDao {
    public List listdao(String major,String genre) {
        List list=new ArrayList();
        Connection conn=null;
        Statement createStatement=null;
        ResultSet executeQuery=null;
        //加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到sql语句对象
            createStatement = conn.createStatement();
            //执行sql语句
            String sql=null;
            if(genre.equals("0")) {
                sql = "select r_id,r_name,r_uptime,duration,filesize from resource WHERE major='" + major + "'";
            }else {
                sql = "select r_id,r_name,r_uptime,duration,filesize from resource WHERE major='" + major + "' AND genre='"+genre+"'";
            }
            System.out.println(sql);
            //执行aql语句
            executeQuery=createStatement.executeQuery(sql);
            //处理结果
            while (executeQuery.next()){
                String r_id=executeQuery.getString("r_id");
                String r_name=executeQuery.getString("r_name");
                String r_uptime=executeQuery.getString("r_uptime");
                String duration=executeQuery.getString("duration");
                //大小
                String filesize=executeQuery.getString("filesize");

                ListDomain   listDomain=new ListDomain(r_id,r_name,r_uptime,duration,filesize);
                list.add(listDomain);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                createStatement.cancel();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                executeQuery.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        System.out.println(list);

        return list;
    }
}
