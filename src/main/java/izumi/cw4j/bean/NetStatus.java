package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/02.
 */
public class NetStatus {

    private int unread_room_num;
    private int mention_room_num;
    private int mytask_room_num;
    private int unread_num;
    private int mention_num;
    private int mytask_num;

    public int getUnread_room_num() {
        return unread_room_num;
    }

    public void setUnread_room_num(int unread_room_num) {
        this.unread_room_num = unread_room_num;
    }

    public int getMention_room_num() {
        return mention_room_num;
    }

    public void setMention_room_num(int mention_room_num) {
        this.mention_room_num = mention_room_num;
    }

    public int getMytask_room_num() {
        return mytask_room_num;
    }

    public void setMytask_room_num(int mytask_room_num) {
        this.mytask_room_num = mytask_room_num;
    }

    public int getUnread_num() {
        return unread_num;
    }

    public void setUnread_num(int unread_num) {
        this.unread_num = unread_num;
    }

    public int getMention_num() {
        return mention_num;
    }

    public void setMention_num(int mention_num) {
        this.mention_num = mention_num;
    }

    public int getMytask_num() {
        return mytask_num;
    }

    public void setMytask_num(int mytask_num) {
        this.mytask_num = mytask_num;
    }

    @Override
    public String toString() {
        return "NetStatus{" +
                "unread_room_num=" + unread_room_num +
                ", mention_room_num=" + mention_room_num +
                ", mytask_room_num=" + mytask_room_num +
                ", unread_num=" + unread_num +
                ", mention_num=" + mention_num +
                ", mytask_num=" + mytask_num +
                '}';
    }
}
