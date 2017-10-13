package studyarea.practice.exam.servlet;

import studyarea.practice.domain.ErrorData;
import studyarea.practice.domain.ExamData;
import studyarea.practice.exam.service.ExamService;
import studyarea.practice.exam.service.impl.ExamServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zlc on 17-7-26.
 */
public class ExamResultServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        /*接受客户端的请求
          由于客户端传来的数据为题目选项的集合
          所以使用循环依次接受并存入集合
         */
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 5; i++) {
            String receive = request.getParameter(String.valueOf(i + 1));
            System.out.println(receive);
            list.add(receive);
        }
        //对客户端请求进行处理
        ExamService service = new ExamServiceImpl();
        ErrorData result = service.afterExam(request, list);
        System.out.println("考试结果:" + result.toString());
        request.setAttribute("result", result);
        request.getRequestDispatcher("/exam.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
