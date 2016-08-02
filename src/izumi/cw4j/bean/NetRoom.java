package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/02.
 */
public class NetRoom {

    private int room_id;
    private String name;
    private String icon_path;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon_path() {
        return icon_path;
    }

    public void setIcon_path(String icon_path) {
        this.icon_path = icon_path;
    }

    @Override
    public String toString() {
        return "NetRoom{" +
                "room_id=" + room_id +
                ", name='" + name + '\'' +
                ", icon_path='" + icon_path + '\'' +
                '}';
    }
}
