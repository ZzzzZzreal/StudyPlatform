package studyarea.interact.appointment.dao.impl;

import domain.Data;
import studyarea.interact.appointment.domain.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zlc on 17-7-24.
 * 这个类是预约课程时对数据库的操作
 */
public class AppointDaoImpl implements studyarea.interact.appointment.dao.AppointDao {
    /**
     * 这个方法是进入课程预约页面时对数据库的操作
     * 查询课程详情，并按上传时间排序
     *
     * @return
     */
    public Data appointList() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Course> list = new ArrayList<Course>();
        Data data = new Data();
        String status = null;
        String note = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "SELECT appo.c_id,user.u_id,appo.c_name,user.u_name,appo.c_type,appo.integral FROM appointment appo LEFT OUTER JOIN user ON appo.u_id=user.u_id ORDER BY issuetime DESC";
            System.out.println("进入预约课程时的sql语句：" + sql);
            resultSet = statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()) {
                //将查询结果依次存入JavaBean中
                Course course = new Course();
                String c_id = resultSet.getString(1);
                System.out.println(c_id);
                course.setC_id(c_id);
                String u_id = resultSet.getString(2);
                course.setU_id(u_id);
                String c_name = resultSet.getString(3);
                course.setC_name(c_name);
                String u_name = resultSet.getString(4);
                course.setU_name(u_name);
                String c_type = resultSet.getString(5);
                course.setC_type(c_type);
                String integral = resultSet.getString(6);
                course.setIntegral(integral);
                list.add(course);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //判断集合是否为空
        if (list.size() == 0) {
            status = "0";
            note = "更新失败";
        } else {
            status = "1";
            note = "更新成功";
        }
        //将结果存入JavaBean中
        data.setStatus(status);
        data.setList(list);
        data.setNote(note);
        return data;
    }

    /**
     * 这个方法是查询课程详情时对数据库的操作
     * 查询课程详情
     *
     * @return
     */
    public Course appointDetail(String id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Course course = new Course();
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "SELECT appo.*,user.u_id,user.u_name FROM appointment appo LEFT OUTER JOIN user ON appo.u_id=user.u_id WHERE c_id='" + id + "'";
            System.out.println("预约课程详情的sql语句：" + sql);
            resultSet = statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()) {
                //将查询结果依次存入JavaBean中
                String c_id = resultSet.getString("c_id");
                System.out.println(c_id);
                course.setC_id(c_id);
                String u_id = resultSet.getString("u_id");
                course.setU_id(u_id);
                String c_name = resultSet.getString("c_name");
                course.setC_name(c_name);
                String u_name = resultSet.getString("u_name");
                course.setU_name(u_name);
                String c_type = resultSet.getString("c_type");
                course.setC_type(c_type);
                String integral = resultSet.getString("integral");
                course.setIntegral(integral);
                String issuetime = resultSet.getString("issuetime");
                course.setIssuetime(issuetime);
                String introduce = resultSet.getString("introduce");
                course.setIntroduce(introduce);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //将结果存入JavaBean中
        return course;
    }

    /**
     * 预约申请时对数据库的操作
     * 将学员id与课程id存入课程表
     *
     * @param u_id
     * @param c_id
     * @return
     */
    public String appointApply(String u_id, String c_id) {
        Connection connection = null;
        Statement statement = null;
        String result = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "INSERT INTO curriculum(u_id,c_id) VALUES(" + u_id + "," + c_id + ")";
            System.out.println("申请预约课程的sql语句：" + sql);
            int resultSet = statement.executeUpdate(sql);
            //处理结果
            if (resultSet == 0) {
                result = "预约失败";
            } else {
                result = "预约成功";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 预约成功后，修改课程预约表appointment中的课程状态
     * @param c_id
     * @return
     */
    public String appointModify(String c_id){
        Connection connection = null;
        Statement statement = null;
        String result = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "UPDATE appointment SET status='已预约'";
            System.out.println("修改课程状态的sql语句：" + sql);
            int resultSet = statement.executeUpdate(sql);
            //处理结果
            if (resultSet == 0) {
                result = "修改失败";
            } else {
                result = "修改成功";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
    public String viewCharacter(String u_id){
        Connection connection = null;
        Statement statement = null;
        String result = null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "SELECT character FROM user WHERE u_id='"+u_id+"'";
            System.out.println("申请预约课程的sql语句：" + sql);
            resultSet = statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()){
                result=resultSet.getString(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
