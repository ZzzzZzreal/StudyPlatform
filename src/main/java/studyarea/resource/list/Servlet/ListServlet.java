package studyarea.resource.list.Servlet;

import studyarea.resource.list.service.ListService;
import studyarea.resource.list.service.impl.ListServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 *
 * 这个类为列表的Servlet
 * Created by hp on 17-7-25.
 */
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求编码
        request.setCharacterEncoding("utf-8");
        //获取响应编码
        response.setCharacterEncoding("utf-8");
        //设置响应的数据类型
        response.setContentType("application/json;charset=utf-8");
        String method = request.getMethod();
        String major = request.getParameter("major");
        String genre = request.getParameter("genre");
        if(method.equals("GET")||"get".equals(method)){
            major =new String (major.getBytes("ISO-8859-1"),"utf-8");
            genre =new String (genre.getBytes("ISO-8859-1"),"utf-8");
        }


        //创建Service对象
        ListService listService=new ListServiceimpl();
        //调用方法
        List list=listService.listservice(major,genre);
        //将listService存到list变量里传到页面
        request.setAttribute("major",major);
        //打印传过来的数据
        System.out.println(list);
        request.setAttribute("list",list);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
