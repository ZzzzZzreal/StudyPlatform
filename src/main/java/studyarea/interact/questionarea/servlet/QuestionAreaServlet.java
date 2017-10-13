package studyarea.interact.questionarea.servlet;

import domain.Question;
import domain.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import studyarea.interact.questionarea.service.QuestionAreaService;
import studyarea.interact.questionarea.service.impl.QuestionAreaServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 此类作为问答区的servlet
 * 需要的参数：用户id u_id
 *           问题主题title
 *           问题的详情detail
 *           图片 picture
 *           悬赏积分 score
 *           回复问题的id a_id
 * Created by jaques on 17-7-24.
 */
public class QuestionAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求编码
        req.setCharacterEncoding("utf-8");
        //设置响应编码
        resp.setCharacterEncoding("utf-8");
        //获取请求方式
        String method=req.getMethod();
        //响应输出
       // PrintWriter out=resp.getWriter();
        //获取请求参数
//        try{
//            //创建一个解析器工厂
//            DiskFileItemFactory factory=new DiskFileItemFactory();
//            //创建解析其
//            ServletFileUpload upload =new ServletFileUpload(factory);
//            upload.setHeaderEncoding("UTF-8");//解决文件名乱马
//            //解析request对象
//            List<FileItem> fileItems =upload.parseRequest(req);
//            //便利每个表单
//            for(FileItem fileItem : fileItems){
//                //判断不为普通表单项
//                if(fileItem.isFormField()){
//                    String fname =fileItem.getFieldName();
//                    String value =fileItem.getString("UTF-8");
//
//                    System.out.print(value);
//
//                }
//                else{
//
//                    String name=fileItem.getFieldName();//上传表单name
//                    String filename =fileItem.getName();//得到文件名
//                    System.out.println(name+filename);
//                    //上传到那的目录
//                    System.out.println(this.getServletContext().getRealPath("/upload"));
//                    //创建目录
//                    File sctoreDirectory =new File(this.getServletContext().getRealPath("/upload"));
//                    if(!sctoreDirectory.exists()){
//
//                        sctoreDirectory.mkdirs();
//                    }
//                    //创建文件对象
//                    File file =new File(sctoreDirectory,filename);
//                    //保存文件到制定目录
//                    fileItem.write(file);
//                    //删除临文件
//                    fileItem.delete();
//                }
//
//            }
//
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }




        String a_id= req.getParameter("a_id");
        //String u_id="1";
        String title=req.getParameter("title");
        String detail=req.getParameter("detail");
        String picture=req.getParameter("picture");
        String score=req.getParameter("score");
        if(null==score){
            score="0";
        }
        Object object= req.getSession().getAttribute("user");
        User user=(User)object;
        String u_id =null;
        if(null!=user) {
            u_id = user.getU_id();
        }
        if(null==a_id){
            a_id="0";
        }
       // System.out.println(a_id);
        //创建当前时间
        Date date=new Date();
        //日期的格式化
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time=dateFormat.format(date);
        System.out.print(time);
        //确认是否接收到参数
        System.out.print("============"+u_id+" "+title+" "+detail+" "+picture+" "+score+" "+a_id+" ");
        //创建对象 将参数存入javabean
        Question question=new Question(u_id,time,title,detail,picture,score,a_id);
        //创建对象 调用addQuestion方法
        QuestionAreaServiceImpl questionAreaServiceImpl=new QuestionAreaServiceImpl();
        boolean boo=questionAreaServiceImpl.addQuestion(question);
        if(boo){
            req.getRequestDispatcher("/list").forward(req,resp);
           // out.write("提交成功");
        }
        else{
            //out.write("提交失败");
            req.getRequestDispatcher("/questionarea.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
