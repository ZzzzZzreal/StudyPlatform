package studyarea.practice.assignment.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by zlc on 17-7-25.
 * 上传的接口
 */
public class Upload extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //创建一个解析工厂
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //创建解析器
        ServletFileUpload servletFileUpload=new ServletFileUpload(diskFileItemFactory);
        //解决文件名乱码
        servletFileUpload.setHeaderEncoding("utf-8");
        //解析request对象
        try {
            List<FileItem> fileItems=servletFileUpload.parseRequest(request);
            for (FileItem fileItem:fileItems) {
                //判断不为普通表单项的内容
                if (!fileItem.isFormField()){
                    //上传表单项的名称
                    String name=fileItem.getFieldName();
                    //得到文件名
                    String fileName=fileItem.getName();
                    System.out.println(name+fileName);
                    //创建服务器的上传目录
                    File directory=new File(this.getServletContext().getRealPath("/upload"));
                    if (!directory.exists()){
                        directory.mkdirs();
                    }
                    //创建文件对象
                    File file=new File(directory,fileName);
                    //保存文件到指定目录中
                    fileItem.write(file);
                    //删除临时文件
                    fileItem.delete();
                }else {
                    String name=request.getParameter("name");
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
