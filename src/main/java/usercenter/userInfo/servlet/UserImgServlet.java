package usercenter.userInfo.servlet;

import domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import usercenter.userInfo.service.UserInfoService;
import usercenter.userInfo.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by yrq on 17-7-25.
 */
public class UserImgServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf8");

        Object object= req.getSession().getAttribute("user");


        User user=(User)object;
        if(user!=null) {


            String uid = user.getU_id();


            try {
                //创建一个解析其工厂
                DiskFileItemFactory factory = new DiskFileItemFactory();
                //创建解析其
                ServletFileUpload upload = new ServletFileUpload(factory);
                upload.setHeaderEncoding("UTF-8");//解决文件名乱马
                //解析request对象
                List<FileItem> fileItems = upload.parseRequest(req);

                for (FileItem fileItem : fileItems) {
                    String name = fileItem.getFieldName();//上传表单name
                    String filename = fileItem.getName();//得到文件名
                    System.out.println(name + filename);//原文件名

                    String suffix = filename.substring(filename.lastIndexOf('.'));//扩展名

                    // 新文件名（唯一）
                    String newFileName = new Date().getTime() + suffix;
                    System.out.println("新文件名：" + newFileName);// image\1478509873038.jpg
                    //上传到那的目录
                    System.out.println(this.getServletContext().getRealPath("/upload"));
                    //创建目录
                    File sctoreDirectory = new File(this.getServletContext().getRealPath("/upload"));

                    if (!sctoreDirectory.exists()) {

                        sctoreDirectory.mkdirs();
                    }
                    //创建文件对象
                    File file = new File(sctoreDirectory, newFileName);
                    //保存文件到制定目录
                    fileItem.write(file);
                    //删除临文件
                    fileItem.delete();
                    String url = newFileName;

                    UserInfoService userInfoService = new UserInfoServiceImpl();
                    Boolean fale = userInfoService.updateImg(url, uid);

                    if (fale) {

                        String    photo=  user.getPhoto();

                        req.setAttribute("photo", photo);
                        req.getRequestDispatcher("/userCenter.jsp").forward(req, resp);
                    }

                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else{

            req.setAttribute("img2", "请先登录");
            req.getRequestDispatcher("userCenter.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
