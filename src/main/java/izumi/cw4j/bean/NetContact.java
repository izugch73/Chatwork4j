package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/02.
 */
public class NetContact {

    private int account_id;
    private int room_id;
    private String name;
    private String chatwork_id;
    private int organization_id;
    private String organization_name;
    private String department;
    private String avatar_image_url;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

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

    public String getChatwork_id() {
        return chatwork_id;
    }

    public void setChatwork_id(String chatwork_id) {
        this.chatwork_id = chatwork_id;
    }

    public int getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(int organization_id) {
        this.organization_id = organization_id;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAvatar_image_url() {
        return avatar_image_url;
    }

    public void setAvatar_image_url(String avatar_image_url) {
        this.avatar_image_url = avatar_image_url;
    }

    @Override
    public String toString() {
        return "NetContact{" +
                "account_id=" + account_id +
                ", room_id=" + room_id +
                ", name='" + name + '\'' +
                ", chatwork_id='" + chatwork_id + '\'' +
                ", organization_id=" + organization_id +
                ", organization_name='" + organization_name + '\'' +
                ", department='" + department + '\'' +
                ", avatar_image_url='" + avatar_image_url + '\'' +
                '}';
    }
}
