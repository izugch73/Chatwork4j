package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/02.
 */
public class NetAssigner {

    private int account_id;
    private String name;
    private String avatar_image_url;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar_image_url() {
        return avatar_image_url;
    }

    public void setAvatar_image_url(String avatar_image_url) {
        this.avatar_image_url = avatar_image_url;
    }

    @Override
    public String toString() {
        return "NetAssigner{" +
                "account_id=" + account_id +
                ", name='" + name + '\'' +
                ", avatar_image_url='" + avatar_image_url + '\'' +
                '}';
    }
}
