package studyarea.resource.dao.impl;

import domain.Resource;
import studyarea.resource.dao.ResourceDao;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * 链接数据库查询资源详情的实现类
 * Created by huangwei on 17-7-24.
 */
public class ResourceDaoImpl implements ResourceDao{
    public Resource ckDetails(String r_id){
        /**
         * 查询资源详情的方法
         * 1、链接数据库
         * 2、根据资源id查资源表
         * 3、创建javabean
         * 4、添加到集合
         * 5、返回集合
         */
        //创建集合
        Resource resource=new Resource();
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection= DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql="select r_name,r_uptime,desp,r_type,duration,filesize,major,genre,r_price from resource where r_id='"+r_id+"'";
            //执行sql语句
            resultSet=statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()){
                //读取资源名称
                resource.setR_name(resultSet.getString(1));
                //读取资源上传时间
                resource.setR_uptime(resultSet.getString(2));
                //读取资源描述
                resource.setDesp(resultSet.getString(3));
                //读取文件类型
                resource.setR_type(resultSet.getString(4));
                //读取资源时长
                resource.setDuration(resultSet.getString(5));
                //读取资源文件大小
                resource.setFilesize(resultSet.getString(6));
                //读取资源的课程方向
                resource.setMajor(resultSet.getString(7));
                //读取资源的课程类型
                resource.setGenre(resultSet.getString(8));
                //读取资源的价格
                resource.setR_price(resultSet.getString(9));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回集合
        return resource;
    }
    public boolean ckCollect(String r_id,String u_id){
        /**
         * 查询资源是否已收藏的方法
         * 1、连接数据库
         * 2、根据资源id和用户id 查询收藏表
         * 3、返回结果
         */
        //创建布尔型变量
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql="select count(*) from collection where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql语句
            resultSet=statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()){
                //读取第一列数据
                String count=resultSet.getString(1);
                //如果为0则表示此资源当前用户没有收藏
                if(count.equals("0")){
                    //flag为true
                    flag=true;
                //如果不为0则表示字资源当前用户已收藏
                }else {
                    //flag为false
                    flag=false;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public boolean addCollect(String r_id,String u_id){
        /**
         * 添加收藏资源的方法
         * 1、连接数据库
         * 2、添加数据到收藏表
         * 3、查询是否添加成功
         * 4、返回结果
         */
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet1=null;
        ResultSet resultSet2=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句
            statement=connection.createStatement();
            //创建sql1语句
            String sql1="select r_name from resource where r_id='"+r_id+"'";
            //执行sql1语句 查询资源名称
            resultSet1=statement.executeQuery(sql1);
            //处理结果
            resultSet1.next();
            //获取资源名称
            String r_name=resultSet1.getString(1);
            //获取当前时间
            Date date=new Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String c_date=format.format(date);
            //创建sql2语句
            String sql2="insert into collection (r_id,r_name,u_id,c_date)values ('"+r_id+"','"+r_name+"','"+u_id+"','"+c_date+"')";
            //执行sql2语句
            statement.executeUpdate(sql2);
            //创建sql3语句查询收藏表 判断是否收藏成功
            String sql3="select count(*) from collection where r_id='"+r_id+"' and u_id='"+u_id+"'";
            resultSet2=statement.executeQuery(sql3);
            //处理结果
            while (resultSet2.next()){
                //读取查询结果
                String count=resultSet2.getString(1);
                //如果结果为0 表示收藏表没有添加成功 返回false
                if (count.equals("0")){
                    flag=false;
                //如果结果不为0 表示收藏表添加成功 返回true
                }else {
                    flag=true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet1.close();
                resultSet2.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public boolean deleteCollect(String r_id,String u_id){
        /**
         * 删除收藏的方法
         * 1、连接数据库
         * 2、删除collection表中的数据
         * 3、查询是否已删除
         * 4、返回结果
         */
        System.out.println("删除收藏的方法");
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql1语句 删除表记录
            String sql1="delete from collection where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql1语句
            statement.executeUpdate(sql1);
            System.out.println("已删除");
            //创建sql2语句 查询是否已删除
            String sql2="select count(*) from collection where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql2语句
            resultSet=statement.executeQuery(sql2);
            //处理结果
            while (resultSet.next()){
                //获取查询结果
                String count = resultSet.getString(1);
                System.out.println(count);
                //如果结果为0，表示删除成功
                if (count.equals("0")){
                    //flag为false
                    flag=true;
                //如果结果不为0,表示没有删除
                }else {
                    //flag为false
                    flag=false;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public boolean ckLike(String r_id,String u_id){
        /**
         * 查询此资源是否已点赞的方法
         * 1、连接数据库
         * 2、根据资源id和用户id查询点赞表
         * 3、返回结果
         */
        System.out.println(u_id);
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql="select count(*) from mylike where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql语句
            resultSet=statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()){
                //读取查询的数据
                String count = resultSet.getString(1);
                //如果查询结果为0表示此资源当前用户没有点赞
                if(count.equals("0")){
                    //flag为true
                    flag=true;
                //如果查询结果不为0 表示此资源当前用户已点赞
                }else {
                    //flag为false
                    flag=false;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public boolean addLike(String r_id,String u_id){
        /**
         * 点赞的方法
         * 1、连接数据库
         * 2、添加数据到点赞表
         * 3、查询是否添加成功
         * 4、返回结果
         */
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的方法
            statement=connection.createStatement();
            //创建sql语句 插入数据到点赞表
            String sql1="insert into mylike values('"+r_id+"','"+u_id+"')";
            //执行sql语句
            statement.executeUpdate(sql1);
            //创建sql语句 查询是否插入成功
            String sql2="select count(*) from mylike where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql2语句
            resultSet=statement.executeQuery(sql2);
            //处理结果
            while (resultSet.next()){
                //读取查询结果
                String count = resultSet.getString(1);
                //如果结果为0 表示没有添加成功
                if(count.equals("0")){
                    //flag为恶false
                    flag=false;
                //结果不为0 表示添加成功
                }else {
                    flag=true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public boolean deletelike(String r_id,String u_id){
        /**
         * 取消点赞的方法
         * 1、连接数据库
         * 2、删除数据库数据
         * 3、查询是否删除
         * 4、返回结果
         */
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql1="delete from mylike where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql1语句
            statement.executeUpdate(sql1);
            //创建sql2语句 查询是否删除
            String sql2="select count(*) from mylike where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql2语句
            resultSet=statement.executeQuery(sql2);
            //处理结果
            while (resultSet.next()){
                //读取查询结果
                String count = resultSet.getString(1);
                //如果结果为0 表示已删除
                if (count.equals("0")){
                    //flag为true
                    flag=true;
                //如果结果不为0 表示为删除
                }else {
                    flag=false;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public Resource ckURL(String r_id){
        /**
         * 查询资源格式，URL，名称的方法
         * 1、连接数据库
         * 2、根据资源id查询资源表
         * 3、返回结果
         */
        //创建Resource对象
        Resource resource=null;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        String r_URL= null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到指向sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql="select r_name,r_URL,r_type from resource where r_id='"+r_id+"'";
            //执行sql语句
            resultSet=statement.executeQuery(sql);
            //数里结果
            resultSet.next();
            //读取查询结果 设置到resource
            resource=new Resource();
            resource.setR_name(resultSet.getString(1));
            resource.setR_URL(resultSet.getString(2));
            resource.setR_type(resultSet.getString(3));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回resource
        return  resource;
    }

    public boolean ckPurchase(String r_id,String u_id){
        /**
         * 查询资源是否已购买的方法
         * 1、连接数据库
         * 2、根据资源id和用户id来查询purchase表
         * 3、返回结果
         */
        boolean flag=false;
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            connection=DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql="select count(*) from purchase where r_id='"+r_id+"' and u_id='"+u_id+"'";
            //执行sql语句
            resultSet=statement.executeQuery(sql);
            //处理结果
            while (resultSet.next()){
                //读取查询结果
                String count = resultSet.getString(1);
                //如果结果为0 表示资源没有购买
                if (count.equals("0")){
                    //flag为false
                    flag=false;
                //结果不为0 表示资源已购买
                }else {
                    //flag为true
                    flag=true;
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //返回flag
        return flag;
    }

    public void addDownload(String r_id,String u_id,String del){
        /**
         * 添加下载记录的方法
         * 1、连接数据库
         * 2、添加数据到表中
         */
        Connection connection=null;
        Statement statement=null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            connection = DriverManager.getConnection("jdbc:mysql://192.168.3.230:3306/studyplatform","test","!@12QWqw");
            //得到执行sql语句的对象
            statement=connection.createStatement();
            //创建sql语句
            String sql="insert into download (r_id,u_id,isDel)values('"+r_id+"','"+u_id+"','"+del+"')";
            //执行sql语句
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
