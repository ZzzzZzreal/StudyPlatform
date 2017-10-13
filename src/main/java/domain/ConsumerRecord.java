package domain;

/**
 * Created by yqy on 17-7-26.
 */
public class ConsumerRecord {
    private String id;
    //用户id
    private String u_id;
    //消费时间
    private String datetime;
    //支付收入类型  '0支付，1充值',
    private String payincometype;
    //金币
    private String coin;
    //原因
    private String cause;

    public ConsumerRecord() {
    }

    public ConsumerRecord(String u_id, String datetime, String payincometype, String coin, String cause) {
        this.u_id = u_id;
        this.datetime = datetime;
        this.payincometype = payincometype;
        this.coin = coin;
        this.cause = cause;
    }

    public ConsumerRecord(String id, String u_id, String datetime, String payincometype, String coin, String cause) {
        this.id = id;
        this.u_id = u_id;
        this.datetime = datetime;
        this.payincometype = payincometype;
        this.coin = coin;
        this.cause = cause;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getPayincometype() {
        return payincometype;
    }

    public void setPayincometype(String payincometype) {
        this.payincometype = payincometype;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Override
    public String toString() {
        return "ConsumerRecord{" +
                "id='" + id + '\'' +
                ", u_id='" + u_id + '\'' +
                ", datetime='" + datetime + '\'' +
                ", payincometype='" + payincometype + '\'' +
                ", coin='" + coin + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
