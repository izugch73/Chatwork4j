package izumi.cw4j.bean;

import izumi.cw4j.Chatwork4j;

import java.util.List;

/**
 * Created by izumi on 2016/08/02.
 */
public class NetTask {

    private int task_id;
    private NetRoom room;
    private NetAssigner assigned_by_account;
    private int message_id;
    private String body;
    private long limit_time;
    private String status;

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public NetRoom getRoom() {
        return room;
    }

    public void setRoom(NetRoom room) {
        this.room = room;
    }

    public NetAssigner getAssigned_by_account() {
        return assigned_by_account;
    }

    public void setAssigned_by_account(NetAssigner assigned_by_account) {
        this.assigned_by_account = assigned_by_account;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getLimit_time() {
        return limit_time;
    }

    public void setLimit_time(long limit_time) {
        this.limit_time = limit_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NetTask{" +
                "task_id=" + task_id +
                ", room=" + room +
                ", assigned_by_account=" + assigned_by_account +
                ", message_id=" + message_id +
                ", body='" + body + '\'' +
                ", limit_time=" + limit_time +
                ", status=" + status +
                '}';
    }
}
