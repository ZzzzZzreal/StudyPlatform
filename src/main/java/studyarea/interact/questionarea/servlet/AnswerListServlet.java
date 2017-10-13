package studyarea.interact.questionarea.servlet;

import domain.Question;
import studyarea.interact.questionarea.service.impl.AnswerListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 此类作为回复评论的servlet
 * 查询
 * Created by jaques on 17-7-26.
 */
public class AnswerListServlet extends HttpServlet {
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
        //获取问题id
        String a_id=req.getParameter("q_id");
        //调用RegistService
        AnswerListServiceImpl listServiceImpl=new AnswerListServiceImpl();
        String data="";
        ArrayList check = listServiceImpl.check(a_id);
        for (Object object : check) {
            data+=((Question)object).toString();
        }
        System.out.println(data);
        // out.write(data);
        req.setAttribute("q_id",a_id);
        req.setAttribute("quest",check);
        req.getRequestDispatcher("/answerlist.jsp").forward(req,resp);
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
