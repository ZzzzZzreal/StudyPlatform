package usercenter.mytracks.dao;

import domain.Data;
import domain.Resource;
import utils.JDBC_Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * MyTracksDao,我的足迹的dao
 */
public class MyTracksDao {
    /**
     * myCollect方法，查询我的收藏
     *
     * @param u_id
     */
    public Data myCollect(Data data, String u_id) {

        ResultSet result = null;
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "SELECT * FROM collection LEFT JOIN resource ON collection.r_id=resource.r_id WHERE u_id='" + u_id + "'";
            //获取收藏内容的名称、链接
            result = createStatement.executeQuery(sql);
            //创建一个List
            List list = new ArrayList();
            while (result.next()) {
                //创建Resource对象
                Resource resource = new Resource();
                String arrName = result.getString("resource.r_name");
                String arrURL = result.getString("r_URL");
                String arrID = result.getString("r_id");
                //将数据存入Resource
                resource.setR_name(arrName);
                resource.setR_URL(arrURL);
                resource.setR_id(arrID);
                //将同一个Resource放入集合
                list.add(resource);
                System.out.println("我的收藏 数据库返回的 list：" + list);
            }
            data.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Util.close(createStatement);
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public Data myDownload(Data data, String u_id) {

        ResultSet result = null;
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "SELECT * FROM download LEFT JOIN resource ON download.r_id=resource.r_id WHERE u_id='" + u_id + "'";
            //获取收藏内容的名称、链接
            result = createStatement.executeQuery(sql);
            //创建一个List
            List list = new ArrayList();
            while (result.next()) {
                //创建Resource对象
                Resource resource = new Resource();
                String arrName = result.getString("r_name");
                String arrURL = result.getString("r_URL");
                String arrID = result.getString("r_id");
                String arrType = result.getString("r_type");
                String arrSize = result.getString("filesize");
                String arrIsDel = result.getString("isDel");
                System.out.println(arrIsDel);

                if ("1".equals(arrIsDel)) {
                    //将数据存入Resource
                    resource.setR_name(arrName);
                    resource.setR_URL(arrURL);
                    resource.setR_id(arrID);
                    resource.setR_type(arrType);
                    resource.setFilesize(arrSize);
                    System.out.println("我的下载 数据库返回的 Resource：" + resource);
                    //将同一个Resource放入集合
                    list.add(resource);
                    System.out.println("我的下载 数据库返回的 list：" + list);
                }

            }
            data.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Util.close(createStatement);
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public Data myUpload(Data data, String u_id) {

        ResultSet result = null;
        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "SELECT * FROM upload LEFT JOIN resource ON upload.r_id=resource.r_id WHERE u_id='" + u_id + "'";
            //获取收藏内容的名称、链接
            result = createStatement.executeQuery(sql);
            //创建一个List
            List list = new ArrayList();
            while (result.next()) {
                //创建Resource对象
                Resource resource = new Resource();
                String arrName = result.getString("r_name");
                String arrMajor = result.getString("major");
                String arrID = result.getString("r_id");
                String arrType = result.getString("r_type");
                String arrSize = result.getString("filesize");
                String arrTime = result.getString("r_uptime");
                String arrIsDel = result.getString("isDel");
                System.out.println(arrIsDel);
                if ("1".equals(arrIsDel)) {
                    //将数据存入Resource
                    resource.setR_name(arrName);
                    resource.setMajor(arrMajor);
                    resource.setR_id(arrID);
                    resource.setR_type(arrType);
                    resource.setFilesize(arrSize);
                    resource.setR_uptime(arrTime);
                    //将同一个Resource放入集合
                    list.add(resource);
                    System.out.println("我的上传 数据库返回的 list：" + list);
                }

            }
            data.setList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Util.close(createStatement);
            try {
                result.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public void delMyDownload(String r_id, String u_id) {

        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "UPDATE download SET isDel='0' WHERE u_id='" + u_id + "' AND r_id='" + r_id + "'";
            //获取收藏内容的名称、链接
            createStatement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Util.close(createStatement);
        }
    }

    public void delMyUpload(String r_id, String u_id) {

        Statement createStatement = null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql语句
            String sql = "UPDATE upload SET isDel='0' WHERE u_id='" + u_id + "' AND r_id='" + r_id + "'";
            //获取收藏内容的名称、链接
            createStatement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBC_Util.close(createStatement);
        }
    }
}
