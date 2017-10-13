package studyarea.interact.questionarea.dao.imp;

import domain.Question;
import studyarea.interact.questionarea.dao.ListDao;

import java.sql.*;
import java.util.ArrayList;

/**
 * 列表  查询数据库的实现类
 * Created by jaques on 17-7-25.
 */
public class ListDaoImpl implements ListDao{
    public ArrayList check() {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        ArrayList list=new ArrayList();
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接，创建与数据库的连接，主要用了DriverManager这个静态类方法
            connection= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //3.得到执行sql语句的对象
            statement=connection.createStatement();
            //4.执行sql语句
            String sql="select * from question WHERE q_a_id='0' order by q_uptime DESC ";
            resultSet=statement.executeQuery(sql);
            System.out.println(sql);
            //5.判断数据库中
            while(resultSet.next()){
                Question question=null;
                //得到结果1
                question=new Question(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4),resultSet.getString(5),resultSet.getString(6),
                        resultSet.getString(7),resultSet.getString(8));
                list.add(question);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}
