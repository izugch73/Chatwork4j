package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/19
 */
public class NetChatbotMessage {

    private String status;
    private String result;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "NetChatbotMessage{" +
                "status='" + status + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
