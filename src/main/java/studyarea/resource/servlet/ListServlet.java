package studyarea.resource.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hp on 17-7-24.
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求编码
        request.setCharacterEncoding("utf-8");
        //设置响应的编码
        response.setCharacterEncoding("utf-8");
        //设置响应的数据类型
        response.setContentType("application/json;charset=utf-8");
        //获取客户端参数
        String l_id=request.getParameter("u_id");
        String l_name=request.getParameter("u_name");
        //创建S


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
