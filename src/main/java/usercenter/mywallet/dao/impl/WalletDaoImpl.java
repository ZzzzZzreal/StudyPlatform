package usercenter.mywallet.dao.impl;

import domain.ConsumerRecord;
import usercenter.mywallet.dao.WalletDao;
import utils.JDBC_Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 对钱包操作的dao实现类
 */
public class WalletDaoImpl implements WalletDao{


    /**
     * 根据用户id查找积分
     * @param u_id
     * @return
     */
    public String findCoinByu_id(String u_id)  {
        String u_coin="0";
        Statement createStatement =null;
        ResultSet resultSet=null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql
            String sql = "select u_coin from coin  where u_id='" + u_id + "'";
            System.out.println("根据用户id查询金币sql语句：" + sql);
            resultSet = createStatement.executeQuery(sql);
            //处理结果
            if (resultSet.next()) {
                u_coin = resultSet.getString(1);
            } else {
                sql = "INSERT INTO coin(u_id,u_coin) values('" + u_id + "','0')";
                System.out.println("根据添加金币的sql语句：" + sql);
                int i = createStatement.executeUpdate(sql);
                u_coin = "0";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=createStatement) {
                try {
                    createStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(null!=resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //将结果返回
        return u_coin;




    }

    /**
     * 修改我的金币
     * @param u_id
     * @param u_coin
     * @return
     */
    public String uploadCoinByu_id(String u_id,String u_coin){
        String falg="false";
        Statement createStatement =null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql
            String  sql = "UPDATE coin  set u_coin='"+u_coin+"' where u_id='"+u_id+"'";
            System.out.println("根据用户id修改金币的sql语句：" + sql);
            int i = createStatement.executeUpdate(sql);
            falg="true";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=createStatement) {
                try {
                    createStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //将结果返回
        return falg;

    }
    /**
     * 根据用户id查询消费历史
     * @param u_id
     * @return
     */
    public List findConsumerRecordByu_id(String u_id){
        Statement createStatement =null;
        ResultSet resultSet=null;
        List list=new ArrayList();
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql
            String sql = "select u_id,datetime,payincometype,coin,cause from consumerrecord  where u_id='" + u_id + "'";
            System.out.println("根据用户id查询消费历史的sql语句：" + sql);
            resultSet = createStatement.executeQuery(sql);
            //处理结果
            while (resultSet.next()) {
                 u_id = resultSet.getString(1);
                String datetime = resultSet.getString(2);
                String payincometype = resultSet.getString(3);
                String coin = resultSet.getString(4);
                String cause = resultSet.getString(5);
                ConsumerRecord consumerRecord=new ConsumerRecord(u_id,datetime,payincometype,coin,cause);
                list.add(consumerRecord);
            }


        } catch (SQLException e) {
            e.printStackTrace();
            list.add("false");
        } finally {
            if (null != createStatement) {
                try {
                    createStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    /**
     * 添加消费记录
     * @param consumerRecord
     */
    public String consumeCoin(ConsumerRecord consumerRecord){
        String falg="false";
        Statement createStatement =null;
        try {
            //调用doJDBC方法，连接数据库
            createStatement = JDBC_Util.doJDBC();
            //执行sql
           String  sql = "INSERT INTO consumerrecord(u_id,datetime,payincometype,coin,cause) " +
                   "values('" + consumerRecord.getU_id() + "','"+consumerRecord.getDatetime()+"','"+
                   consumerRecord.getPayincometype()+"','"+consumerRecord.getCoin()
                   +"','"+consumerRecord.getCause()+"')";
            System.out.println("修改消费金币记录的sql语句：" + sql);
            int i = createStatement.executeUpdate(sql);
            falg="true";
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(null!=createStatement) {
                try {
                    createStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        //将结果返回
        return falg;
    }

}
