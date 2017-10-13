package loginregist.servlet;
/**
 * 创建链接 请求方式
 * 获取客户端的消息
 * 然后将数据
 *
 */
//导包


import loginregist.dao.RegistDao;
import loginregist.service.CKusersNameService;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//创建类继承HttpServlet类
public class CKusersNameServlet extends HttpServlet {
    /**
     * 这个类主要是为了完成对用户名在从客户端
     * 接收过来然后完成在数据库的查询
     * 是否存在这个用户名如果存在就不能进行注册.
     *
     */
    //创建doGet方法进行对客户端的链接并抛出异常
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //对数据进编码的设定如果这样处理就不会乱码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //得到的是什么格式,一般都为json格式
        response.setContentType("application/json;charset=UTF-8");
        //创建UserData对象 然后将判断后`的数据放在UserData 中返回
        //UsersData userdata=new UsersData();
        //从客户端哪里获得一个用户名
        String userName =request.getParameter("username");
        //创建cKusersNameService对象对用户名进行合法判断
        //System.out.println(userName);
        CKusersNameService cKuserNameService=new CKusersNameService();
        //调用cKusersNameService里面的ckUsersNameService方法判断是否合法返回值为Boolean
        boolean ckns=cKuserNameService.ckUsersNameService(userName);
        //判断如果合法是否再数据库中有数据如果有返回false如果无进行注册并返回json字符串
        if(ckns){
            RegistDao registdao=new RegistDao();
            try {
                //判断是数据库中是否存在邮箱
                boolean reg=registdao.cKuserName(userName);
                //如果返回为true
                if(reg){
                    response.getWriter().print(reg);
                }else {
                    response.getWriter().print(reg);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    //post请求将post请求调用get请求进行请求
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}




