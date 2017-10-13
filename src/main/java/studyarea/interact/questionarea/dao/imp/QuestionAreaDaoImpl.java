package studyarea.interact.questionarea.dao.imp;

import domain.Question;
import studyarea.interact.questionarea.dao.QuestionAreaDao;

import java.sql.*;

/**
 * 实现dao接口 操作数据库
 * 将question 参数 存入 数据库
 * 并返回
 * Created by jaques on 17-7-25.
 */
public class QuestionAreaDaoImpl implements QuestionAreaDao {
    public boolean addQuestion(Question question) {
        Connection connection=null;
        Statement statement=null;
        //int resultSet=0;
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接，创建与数据库的连接，主要用了DriverManager这个静态类方法
           // connection= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","root","!@12QWqw");
            connection= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //3.得到执行sql语句的对象
            statement=connection.createStatement();
            //4.执行sql语句
            String sql="insert into question(u_id,q_uptime,q_title,q_detail,q_picture,q_score,q_a_id)values" +
                    "('"+question.getU_id()+"','"+question.getTime()+"','"+question.getTitle()+"'," +
                    "'"+question.getDetail()+"','"+question.getPicture()+"','"+question.getScore()+"','"+question.getA_id()+"')";
            System.out.println(sql);
            int resultSet=statement.executeUpdate(sql);
            System.out.println(resultSet);
            if(resultSet>0){
                System.out.print("提交成功");
                return true;
            }
            else{
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
        return false;
    }
}
