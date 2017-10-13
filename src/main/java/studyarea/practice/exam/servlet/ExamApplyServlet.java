package studyarea.practice.exam.servlet;

import studyarea.practice.domain.ExamData;
import studyarea.practice.exam.service.ExamService;
import studyarea.practice.exam.service.impl.ExamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zlc on 17-7-26.
 */
public class ExamApplyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        //接受客户端的请求
        String belong=request.getParameter("belong");
        System.out.println(belong);
        //对客户端请求进行处理
        ExamService service=new ExamServiceImpl();
        ExamData result=service.goExam(request,belong);
        System.out.println("考试申请:"+result.toString());
        request.setAttribute("exam",result);
        if (result.getStatus()=="0"){
            request.getRequestDispatcher("/goExam.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/exam.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
