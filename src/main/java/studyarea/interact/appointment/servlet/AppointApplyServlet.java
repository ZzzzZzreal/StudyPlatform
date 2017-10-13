package studyarea.interact.appointment.servlet;

import studyarea.interact.appointment.domain.Course;
import studyarea.interact.appointment.service.AppointService;
import studyarea.interact.appointment.service.impl.AppointServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zlc on 17-7-25.
 */
public class AppointApplyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        //response.setContentType("application/json;charset=utf-8");
        //接受客户端的请求
        String c_id=request.getParameter("c_id");
        System.out.println(c_id);
        //对客户端请求进行处理
        AppointService service=new AppointServiceImpl();
        String result=service.goApply(request,c_id);
        System.out.println("预约申请:"+result);
        request.setAttribute("apply",result);
        request.getRequestDispatcher("/appointResult.jsp").forward(request,response);
        //response代表服务端响应的对象，写入处理后的结果
//     response.getWriter().print(result);
//        //writer.print(result);
//        //刷新流
//        writer.flush();
//        //关闭流
//        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
