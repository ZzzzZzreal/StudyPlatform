package studyarea.interact.appointment.servlet;

import studyarea.interact.appointment.domain.Course;
import studyarea.interact.appointment.service.AppointService;
import studyarea.interact.appointment.service.impl.AppointServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zlc on 17-7-25.
 */
public class AppointDetailServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        //接受客户端的请求
        String id=request.getParameter("c_id");
        //对客户端请求进行处理
        AppointService service=new AppointServiceImpl();
        Course course=service.goDetail(id);
        System.out.println(course.toString());
        request.setAttribute("detail",course);
        request.getRequestDispatcher("/appoint.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
