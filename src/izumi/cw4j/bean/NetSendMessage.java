package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/01.
 */
public class NetSendMessage {

    private String message_id;

    public String getMessage_id() {
        return message_id;
    }

    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    @Override
    public String toString() {
        return "NetSendMessage{" +
                "message_id='" + message_id + '\'' +
                '}';
    }
}
