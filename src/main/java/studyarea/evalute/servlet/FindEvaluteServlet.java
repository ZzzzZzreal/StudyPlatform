package studyarea.evalute.servlet;

import studyarea.evalute.service.FindEvaluteService;
import studyarea.evalute.service.impl.FindEvaluteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by yrq on 17-7-26.
 */
public class FindEvaluteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        String c_id=req.getParameter("c_id");

        FindEvaluteService findEvaluteService=new FindEvaluteServiceImpl();
     ArrayList array= findEvaluteService.evalute(c_id);


        if(array!=null||"".equals(array)) {

            req.setAttribute("evalute", array);
            req.getRequestDispatcher("/courseEvalute.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
