package studyarea.resource.servlet;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import domain.User;
import studyarea.resource.dao.ResourceDao;
import studyarea.resource.dao.impl.ResourceDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangwei on 17-7-24.
 */
public class CollectionServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("CollectionServlet 执行了，收藏");
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应编码
        response.setCharacterEncoding("utf-8");
        //设置响应数据的类型
        response.setContentType("applocation/jeson;charset=utf-8");
        //获取资源id
        String r_id=request.getParameter("r_id");
        //获取资源的价格
        //System.out.println(r_id);
        //获取当前用户的id
        User user=(User) request.getSession().getAttribute("user");
        String u_id=null;
        if(null!=user) {
            u_id = user.getU_id();
        }
        //String u_id=(String) request.getSession().getAttribute("u_id");
        //System.out.println(u_id);
        //创建ResourceDaoImpl对象
        ResourceDaoImpl resourceDaoImpl=new ResourceDaoImpl();
        //调用ckCollect()方法 查询此资源当前用户是否已收藏
        boolean flag=resourceDaoImpl.ckCollect(r_id,u_id);
        //如果flag为true 此资源当前用户没有收藏 用户点击收藏按钮 添加收藏
        if(flag){
            //调用addCollect()方法 添加收藏
            boolean b=resourceDaoImpl.addCollect(r_id,u_id);
            //如果b为true 表示添加成功
            if (b){
                //弹出框 收藏成功
                response.getWriter().print("a");
                return;
            }else {
                //弹出框 出错了
                response.getWriter().print("b");
                return;
            }
        //如果flag为false 此资源当前用户已经收藏 用户点击收藏按钮 删除收藏
        }else {
            boolean b=resourceDaoImpl.deleteCollect(r_id,u_id);
            //如果b为true 取消收藏
            if (b){
                response.getWriter().print("c");
                return;
                //弹出窗口 取消收藏
            }else {
                //弹出窗口 出错了
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
