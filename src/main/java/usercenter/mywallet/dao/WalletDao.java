package usercenter.mywallet.dao;

import domain.ConsumerRecord;

import java.sql.SQLException;
import java.util.List;

/**
 * 对钱包操作的dao接口
 */
public interface WalletDao {
    /**
     * 根据用户id查找积分
     * @param u_id
     * @return
     * @throws SQLException
     */
    public String findCoinByu_id(String u_id) throws SQLException;
    /**
     * 修改我的金币
     * @param u_id
     * @param u_coin
     * @return
     */
    public String uploadCoinByu_id(String u_id,String u_coin);
    /**
     * 根据用户id查询消费历史
     * @param u_id
     * @return
     */
    public List findConsumerRecordByu_id(String u_id) ;
    /**
     * 添加消费记录
     * @param consumerRecord
     */
    public String consumeCoin(ConsumerRecord consumerRecord);

}
