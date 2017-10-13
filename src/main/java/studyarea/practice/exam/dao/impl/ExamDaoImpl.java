package studyarea.practice.exam.dao.impl;

import studyarea.practice.domain.Examination;
import studyarea.practice.domain.Problem;
import studyarea.practice.exam.dao.ExamDao;
import utils.CreateID;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zlc on 17-7-25.
 * 测试时对数据库的操作
 */
public class ExamDaoImpl implements ExamDao {
    public Examination examApply(String belong) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Problem> questionList = new ArrayList<Problem>();
        List<String> answerList = new ArrayList<String>();
        Examination examination = new Examination();
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "SELECT * FROM test WHERE q_course='" + belong + "'";
            System.out.println("查找试题：" + sql);
            resultSet = statement.executeQuery(sql);
            //处理结果
            int i = 1;
            while (resultSet.next()) {
                //将查询结果依次存入JavaBean中
                Problem problem = new Problem();
                String q_id = resultSet.getString(1);
                System.out.println("数据库中的数据" + q_id);
                System.out.println(i);
                problem.setPid(i);
                String question = resultSet.getString(3);
                problem.setQuestion(question);
                String answer = resultSet.getString(4);
                answerList.add(answer);
                String ansA = resultSet.getString(5);
                problem.setAnsA(ansA);
                String ansB = resultSet.getString(6);
                problem.setAnsB(ansB);
                String ansC = resultSet.getString(7);
                problem.setAnsC(ansC);
                String ansD = resultSet.getString(8);
                problem.setAnsD(ansD);
                questionList.add(problem);
                i++;
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
        //随机生成id
        CreateID createID = new CreateID();
        String id = createID.createID();
        examination.setId(id);
        //这份试题的所属课程模块
        examination.setBelong(belong);
        //问题集合
        examination.setQuestionList(questionList);
        //答案集合
        examination.setAnswerList(answerList);
        //当前日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(new java.util.Date(System.currentTimeMillis()));
        examination.setDate(date);
        return examination;
    }

    public boolean examResult(String s_id, String u_id, String belong, int score, String date) {
        Connection connection = null;
        Statement statement = null;
        boolean result = false;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform", "test", "!@12QWqw");
            //得到执行sql语句的对象
            statement = connection.createStatement();
            //执行sql
            String sql = "INSERT INTO score VALUES('" + s_id + "'," + u_id + ",'" + date + "','"+belong+"'," + score + ")";
            System.out.println("查找试题：" + sql);
            int update = statement.executeUpdate(sql);
            if (update != 0) {
                result = true;
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
}
