package usercenter.mywallet.servlet;

import domain.User;
import usercenter.mywallet.service.WalletService;
import usercenter.mywallet.service.impl.WalletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据用户id查询积分的servlet
 */
public class CoinServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取session中的用户id
           User  user = (User)request.getSession().getAttribute("user");
        //session中的用户id为null
        if(null==user){
            //转发至登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }
        String  u_id=user.getU_id();
        //创建WalletService对象
        WalletService walletService =new WalletServiceImpl();
        //根据用户查找积分
        String u_coin=walletService.findCointByu_id(u_id);
        request.setAttribute("u_id",u_id);
        request.setAttribute("u_coin",u_coin);
        request.getRequestDispatcher("/MyWallet.jsp").forward(request,response);



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

}
