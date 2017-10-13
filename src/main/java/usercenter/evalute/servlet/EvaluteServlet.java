package usercenter.evalute.servlet;

import usercenter.evalute.service.EvaluteService;
import usercenter.evalute.service.impl.EvaluteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yrq on 17-7-26.
 */
public class EvaluteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json;charset=utf-8");
        String c_id=req.getParameter("cid");
        String evalute=req.getParameter("evalute");

        System.out.println(c_id);
        System.out.println(evalute);

        EvaluteService evaluteService=new EvaluteServiceImpl();
      Boolean fale=  evaluteService.evalute(c_id,evalute);

        if(fale){

            req.setAttribute("evalute", "评论成功");
            req.getRequestDispatcher("/userCenter.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
