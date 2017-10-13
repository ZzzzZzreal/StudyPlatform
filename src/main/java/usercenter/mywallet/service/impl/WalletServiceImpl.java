package usercenter.mywallet.service.impl;

import domain.ConsumerRecord;
import usercenter.mywallet.dao.WalletDao;
import usercenter.mywallet.dao.impl.WalletDaoImpl;
import usercenter.mywallet.service.WalletService;

import java.sql.SQLException;
import java.util.List;

/**
 * 钱包的service实现类
 */
public class WalletServiceImpl implements WalletService{

    //创建WalletDao的对象
    WalletDao walletDao=new WalletDaoImpl();

    /**
     * 根据用户id查找积分
     * @param u_id
     */
    public String findCointByu_id(String u_id) {
        String u_coin="0";
        try {
             u_coin = walletDao.findCoinByu_id(u_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u_coin;
    }


    /**
     * 根据用户id查询消费历史
     * @param u_id
     * @return
     */
    public List findConsumerRecordByu_id(String u_id){

        List list = walletDao.findConsumerRecordByu_id(u_id);

        return list;
    }

    /**
     * 修改金币
     * @param consumerRecord
     */
    public String  alterCoin(ConsumerRecord consumerRecord){
        //0表示消费 1表示充值
        String payincometype = consumerRecord.getPayincometype();
        String u_coin="0";
        try {
            //根据用户id查找金币
            u_coin = walletDao.findCoinByu_id(consumerRecord.getU_id());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //剩余积分
        int u_coin2 = Integer.parseInt(u_coin);
        //需要消费或收入的金币
        String coin = consumerRecord.getCoin();
        int coin2 = Integer.parseInt(coin);
        if("0".equals(payincometype)){
            System.out.println("支出金币");
            if(u_coin2<coin2){
                return "金币不够";
            }
            //
            //添加消费记录
            String falg=walletDao.consumeCoin(consumerRecord);
            if("false".equals(falg)){
                return "添加消费记录失败";

            }
            //根据用户id修改积分
            falg= walletDao.uploadCoinByu_id(consumerRecord.getU_id(),u_coin2-coin2+"");
            if("false".equals(falg)){
                return "消费失败";
            }
            return "购买成功";

        }else{
            System.out.println("收入金币");
            String falg=walletDao.consumeCoin(consumerRecord);
            if("false".equals(falg)){
                return "添加消费记录失败";
            }
           int addcoin= u_coin2+coin2;
            System.out.println(addcoin);
            //根据用户id修改积分
            falg= walletDao.uploadCoinByu_id(consumerRecord.getU_id(),addcoin+"");
            if("false".equals(falg)){
                return "添加金币失败";
            }
            return "添加金币成功";
        }
    }
}
