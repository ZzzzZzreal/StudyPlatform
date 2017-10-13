package usercenter.mywallet.servlet;

import domain.CoinDetails;
import domain.ConsumerRecord;
import domain.User;
import usercenter.mywallet.service.WalletService;
import usercenter.mywallet.service.impl.WalletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消费金币
 */
public class AlterCoinServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AlterCoinServlet-- 积分的修改的servlet");
        User user = (User) req.getSession().getAttribute("user");
        if(null==user){
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
            return;
        }
        //消费的用户id
        String u_id = user.getU_id();
       /* String path=req.getParameter("path");
        //消费的金币
        String coin = req.getParameter("coin");
        //消费的原因
        String cause=req.getParameter("cause");
        if (req.getMethod().equals("GET")){
            cause= new String(cause.getBytes("ISO-8859-1"),"utf-8");
        }
        //类型
        String payincometype=req.getParameter("payincometype");*/

        CoinDetails coinDetails =(CoinDetails) req.getAttribute("coinDetails");
        String path = coinDetails.getPath();
        String cause = coinDetails.getCause();
        String payincometype = coinDetails.getPayincometype();
        String coin = coinDetails.getCoin();
        System.out.println(coinDetails);
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = df.format(new Date());
        ConsumerRecord consumerRecord=new ConsumerRecord(u_id,datetime,payincometype,coin,cause);
        System.out.println("数据:"+consumerRecord);
        WalletService walletService=new WalletServiceImpl();

        //调用修改金币的service
        String note = walletService.alterCoin(consumerRecord);

        req.setAttribute("note",note);
        req.getRequestDispatcher("/"+path).forward(req,resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
