package loginregist.servlet;
/**
 * 创建链接 请求方式
 * 获取客户端的消息
 * 然后将数据
 * 出传到javaBean中
 * 此类为主要的链接类
 *
 */
//导包
import domain.User;
import loginregist.dao.RegistDao;
import loginregist.service.CKservice;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//.创建类继承HttpSerclet
public class RegistServlet extends HttpServlet {
    /**
     * 创建doGet doPost方法进行请求
     * 处理乱码问题
     * 获取从客户端发来的消息进行处理
     * 并对密码进行加密处理
     * 然后对客户端进行相应
     * 完成交互
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //进行对客户端编码问题处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        //创建Users 对象 然后Get数据 将数据传到javaBean 里
        //将客户端传来的消息得到
        //接收客户端的消息
        String username=request.getParameter("username");
        String pwd=request.getParameter("password");
        String pwd1=request.getParameter("repassword");
        String phone=request.getParameter("phone");
        String email=request.getParameter("email");
        String identify=request.getParameter("identify");
        String photo=request.getParameter("photo");
        String gender=request.getParameter("gender");
        String checkcode=request.getParameter("checkCode");
        String status="0";
        RegistDao regist=new RegistDao();
        String  randCheckCode=(String) request.getSession().getAttribute("randCheckCode");
        CKservice cKservice=new CKservice();
        String note=null;
        try {
            note=cKservice.CkAll(username,pwd,pwd1,phone,email,checkcode,randCheckCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建对象对
        //判断是否是学员
        if (note.equals("正确")){
            if (identify.equals("学员") ){
                boolean bb = false;

                try {
                    bb = regist.cKstudent(username, phone);
                } catch (SQLException e) {
                e.printStackTrace();
                } catch (ClassNotFoundException e) {
                e.printStackTrace();
                }

                if (bb) {
                    User user = new User(username, identify, phone, email, pwd, status, gender, photo);
                //创建对象将数据传到dao中

                    boolean reg = false;
                    try {
                        reg = regist.cKuser(user);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (reg) {
                        request.getRequestDispatcher("/login.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("mss", "注册失败!您不是学员,请重新注册!");
                    request.getRequestDispatcher("/regist.jsp").forward(request, response);
                }
            }else{
                User user = new User(username, identify, phone, email, pwd, status, gender, photo);
                //创建对象将数据传到dao中

                boolean reg = false;
                try {
                    reg = regist.cKuser(user);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (reg) {
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
                else {
                //request.setAttribute("mss", "注册失败!您不是学员,请重新注册!");
                request.getRequestDispatcher("/regist.jsp").forward(request, response);
                }
            }
        }else {
            request.setAttribute("msg", note);
            request.getRequestDispatcher("/regist.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}




