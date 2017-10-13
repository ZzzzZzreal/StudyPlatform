package studyarea.interact.questionarea.servlet;

import domain.Question;
import studyarea.interact.questionarea.service.impl.ListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 此类作为列表servlet
 * 进入问答区后会显示数据库表中的信息
 * Created by jaques on 17-7-25.
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setCharacterEncoding("utf-8");
        //获取请求方式
        String method=req.getMethod();
        //响应输出
        PrintWriter out=resp.getWriter();
        //调用RegistService
        ListServiceImpl listServiceImpl=new ListServiceImpl();
        String data="";
        ArrayList check = listServiceImpl.check();
        for (Object object : check) {
            data+=((Question)object).toString();
        }
        System.out.println(data);
       // out.write(data);
       req.setAttribute("quest",check);
       req.getRequestDispatcher("/questlist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
