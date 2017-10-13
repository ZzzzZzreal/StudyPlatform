package studyarea.resource.servlet;

import studyarea.resource.dao.impl.ResourceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 此类实现客户端点击点赞按钮访问的服务端
 * 获取请求参数 r_id,u_id
 * 查询点赞表 如果此资源当前用户已点赞，用户点击点赞按钮则实现取消点赞，如果此资源用户没有点赞，用户点击点赞按钮实现点赞
 * 弹出提示框
 * Created by huangwei on 17-7-25.
 */
public class LikeServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码格式
        response.setCharacterEncoding("utf-8");
        //设置响应数据的类型
        response.setContentType("applocation/jeson;charset=utf-8");
        //获取当前资源的id
        String r_id=request.getParameter("r_id");
        //获取当前用户id
        String u_id=request.getParameter("u_id");
        //String u_id=(String) request.getSession().getAttribute("u_id");
        //创建ResourceDaoImpl对象
        ResourceDaoImpl resourceDaoImpl=new ResourceDaoImpl();
        //调用ckLike()方法
        boolean flag=resourceDaoImpl.ckLike(r_id,u_id);
        //判断此资源当前用户是否已收藏
        if (flag){
            //调用addLike()方法 点赞
            boolean b=resourceDaoImpl.addLike(r_id,u_id);
            if (b){
                //返回结果a
                response.getWriter().print("a");
                return;
            }else {
                //返回结果b
                response.getWriter().print("b");
                return;
            }
        }else {
            //调用deleteLike()方法 取消点赞
            boolean b=resourceDaoImpl.deletelike(r_id,u_id);
            if (b){
                //返回结果c
                response.getWriter().print("c");
                return;
            }else {
                //返回结果b
                response.getWriter().print("b");
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
