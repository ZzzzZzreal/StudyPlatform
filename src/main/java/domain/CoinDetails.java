package domain;

/**
 * 积分详情
 */
public class CoinDetails {

    /**
     * 需要调转的地址
     */
    private String path;
    //积分
    private String coin;
    //原因
    private String cause;
     //支付收入类型  '0支付，1充值',
    private String payincometype;

    public CoinDetails() {
    }

    public CoinDetails(String path, String coin, String cause, String payincometype) {
        this.path = path;
        this.coin = coin;
        this.cause = cause;
        this.payincometype = payincometype;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getPayincometype() {
        return payincometype;
    }

    public void setPayincometype(String payincometype) {
        this.payincometype = payincometype;
    }

    @Override
    public String toString() {
        return "CoinDetails{" +
                "path='" + path + '\'' +
                ", coin='" + coin + '\'' +
                ", cause='" + cause + '\'' +
                ", payincometype='" + payincometype + '\'' +
                '}';
    }
}
