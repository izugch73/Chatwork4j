package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/01.
 */
public class NetMessage {

    private int message_id;
    private NetAccount account;
    private String body;
    private long send_time;
    private long update_time;

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public NetAccount getAccount() {
        return account;
    }

    public void setAccount(NetAccount account) {
        this.account = account;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getSend_time() {
        return send_time;
    }

    public void setSend_time(long send_time) {
        this.send_time = send_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "NetMessage{" +
                "message_id=" + message_id +
                ", account=" + account +
                ", body='" + body + '\'' +
                ", send_time=" + send_time +
                ", update_time=" + update_time +
                '}';
    }
}
