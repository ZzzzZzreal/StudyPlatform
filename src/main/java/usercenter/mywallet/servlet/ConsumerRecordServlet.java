package usercenter.mywallet.servlet;

import usercenter.mywallet.service.WalletService;
import usercenter.mywallet.service.impl.WalletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 消费记录的servlet
 */
public class ConsumerRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String u_id= req.getParameter("u_id");
        WalletService walletService=new WalletServiceImpl();
        List list = walletService.findConsumerRecordByu_id(u_id);
        req.setAttribute("list",list);
        req.getRequestDispatcher("/consumerRecord.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
