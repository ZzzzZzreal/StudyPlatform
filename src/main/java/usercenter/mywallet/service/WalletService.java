package usercenter.mywallet.service;

import domain.ConsumerRecord;

import java.util.List;

/**
 * 钱包的service接口
 */
public interface WalletService {
    /**
     * 根据用户id查找积分
     * @param u_id
     * @return
     */
    String findCointByu_id(String u_id);
    /**
     * 根据用户id查询消费历史
     * @param u_id
     * @return
     */
    public List findConsumerRecordByu_id(String u_id);
    /**
     * 添加消费记录
     * @param consumerRecord
     */
    public String alterCoin(ConsumerRecord consumerRecord);
}
