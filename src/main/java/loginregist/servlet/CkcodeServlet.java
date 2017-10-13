package loginregist.servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ch on 17-7-26.
 */
public class CkcodeServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //进行对客户端编码问题处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        String checkcode=request.getParameter("checkCode");
        String  string=(String) request.getSession().getAttribute("randCheckCode");
        boolean ch=false;
        if( checkcode==null||checkcode.equals("")) {
                ch=false;
        }else  if (string.equals(checkcode)){
            ch=true;
        }else {
            ch=false;
        }
        System.out.println(ch);
        response.getWriter().print(ch);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
