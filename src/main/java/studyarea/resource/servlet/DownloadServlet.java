package studyarea.resource.servlet;

import domain.User;
import studyarea.resource.dao.impl.ResourceDaoImpl;
import studyarea.resource.service.DownloadService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 此类实现客户端点击下载按钮访问的服务端
 * 获取请求参数：资源id:r_id,用户id:u_id,用户身份：identify
 * 判断用户身份
 * 1、如果用户身份为学员
 *      连接数据库，查询资源URL
 *      多线程下载到指定路径
 * 2、如果用户身份为普通用户提示用户购买后下载
 *      用户点击购买按钮
 *      查询当前用户的余额是否大于此资源的价格 如果足够点击确认 如果不够提示余额不足
 * Created by huangwei on 17-7-24.
 */
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应的编码格式
        response.setCharacterEncoding("utf-8");
        //设置响应数据的类型
        response.setContentType("applocation/jeson;charset=utf-8");
        //获取资源id
        String r_id=request.getParameter("r_id");
        //获取session中的user
        User user=(User) request.getSession().getAttribute("user");
        //获取当前用户的身份
        String identify=user.getIdentify();
        //获取当前用户的id
        String u_id=user.getU_id();
        //创建ResourceDaoImpl对象
        ResourceDaoImpl resourceDaoImpl=new ResourceDaoImpl();
        //判断用户身份 学员直接下载
        if(identify.equals("学员")){
            //创建DownloadService对象
            DownloadService downloadService=new DownloadService();
            //调用service()方法
            boolean b=downloadService.service(r_id,u_id);
            if (b){
                //提示已添加到下载列表
                response.getWriter().print("true");
            }else {
                //提示下载失败
                response.getWriter().print("error");
            }

        //如果为普通用户
        }else {
            //查询此资源当前用户是否已购买
            boolean flag=resourceDaoImpl.ckPurchase(r_id,u_id);
            //如果falg为true 表示用户可以下载 提示已添加到下载列表
            if (flag) {
                //创建DownloadService对象
                DownloadService downloadService=new DownloadService();
                //调用service()方法
                boolean b=downloadService.service(r_id,u_id);
                if (b){
                    //提示已添加到下载列表
                    response.getWriter().print("true");
                }else {
                    //提示下载失败
                    response.getWriter().print("error");
                }
            }else {
                //如果flag为false 表示用户没有购买 提示先购买
                response.getWriter().print("false");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
