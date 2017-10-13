package studyarea.resource.servlet;

import domain.CoinDetails;
import domain.User;
import studyarea.resource.dao.impl.ResourceDaoImpl;
import usercenter.mywallet.dao.impl.WalletDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 此类实现客户端点击购买按钮访问的服务端
 * 先判断用户的身份 学员提示不需要购买  普通用户查询是否已购买
 * Created by huangwei on 17-7-27.
 */
public class PurchaseServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求的编码格式
        request.setCharacterEncoding("utf-8");
        //设置响应的编码格式
        response.setCharacterEncoding("utf-8");
        //获取资源id
        String r_id=request.getParameter("r_id");
        //获取资源的价格
        String r_price=request.getParameter("r_price");
        //获取session中的user
        User user=(User) request.getSession().getAttribute("user");
        //获取当前用户的id
        String u_id=user.getU_id();
        //获取当前用户的身份
        String identify=user.getIdentify();
        if(identify.equals("学员")){
            request.setAttribute("note","亲，您是内部学员不需要购买可直接下载");
            request.getRequestDispatcher("/details.jsp").forward(request,response);
            return;
        }else {
            //创建ResourceDaoImpl对象
            ResourceDaoImpl resourceDaoImpl=new ResourceDaoImpl();
            //调用ckPurchase方法 查询是否已购买
            boolean flag=resourceDaoImpl.ckPurchase(r_id,u_id);
            //判断
            if (flag){
                request.setAttribute("note","亲，您已购买此资源，可直接下载");
                request.getRequestDispatcher("/details.jsp").forward(request,response);
                return;
            //如果用户不是学员也没有购买此视频 先查询用户的
            }else {
                //创建WalletDaoImpl对象
                WalletDaoImpl walletDaoImpl=new WalletDaoImpl();
                //调用findCointByu_id()方法
                String u_coin=walletDaoImpl.findCoinByu_id(u_id);
                //把r_price和u_coin转换成int型
                System.out.println(r_price);
                System.out.println(r_id);
                System.out.println(u_coin);
                int price=Integer.parseInt(r_price);
                int coin=Integer.parseInt(u_coin);
                //判断用户的积分是否足够
                if (coin>=price){
                    //创建CoinDetails对象
                    CoinDetails coinDetails=new CoinDetails();
                    //设置CoinDetails参数
                    coinDetails.setPath("details.jsp");
                    coinDetails.setCoin(r_price);
                    coinDetails.setCause("购买资源");
                    coinDetails.setPayincometype("0");
                    request.setAttribute("coinDetails",coinDetails);
                    request.getRequestDispatcher("/alterCoinServlet").forward(request,response);
                }else {
                    request.setAttribute("note","亲，您的余额不足，请先充值");
                    request.getRequestDispatcher("/details.jsp").forward(request,response);
                    return;
                }
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
