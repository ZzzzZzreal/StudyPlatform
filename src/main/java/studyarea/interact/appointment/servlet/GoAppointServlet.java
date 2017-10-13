package studyarea.interact.appointment.servlet;

import domain.Data;
import studyarea.interact.appointment.service.AppointService;
import studyarea.interact.appointment.service.impl.AppointServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zlc on 17-7-24.
 * 这个类是进入课程预约页面的接口
 * 客户端请求的参数为课程类型、教师名
 * 返回的JavaBean是课程的集合
 */
public class GoAppointServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        //对客户端请求进行处理
        AppointService service=new AppointServiceImpl();
        Data data=service.goAppoint();
        System.out.println(data.toString());
        request.setAttribute("appointList",data);
        request.getRequestDispatcher("/goAppoint.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
