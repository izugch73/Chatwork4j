package izumi.cw4j.bean;

/**
 * Created by izumi on 2016/08/01.
 */
public class NetMe {
    private int account_id;
    private int room_id;
    private String name;
    private String chatwork_id;
    private int organization_id;
    private String organization_name;
    private String department;
    private String title;
    private String url;
    private String introduction;
    private String mail;
    private String tel_organization;
    private String tel_extension;
    private String tel_mobile;
    private String skype;
    private String facebook;
    private String twitter;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel_organization() {
        return tel_organization;
    }

    public void setTel_organization(String tel_organization) {
        this.tel_organization = tel_organization;
    }

    public String getTel_extension() {
        return tel_extension;
    }

    public void setTel_extension(String tel_extension) {
        this.tel_extension = tel_extension;
    }

    public String getTel_mobile() {
        return tel_mobile;
    }

    public void setTel_mobile(String tel_mobile) {
        this.tel_mobile = tel_mobile;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getAvatar_image_url() {
        return avatar_image_url;
    }

    public void setAvatar_image_url(String avatar_image_url) {
        this.avatar_image_url = avatar_image_url;
    }


    @Override
    public String toString() {
        return "NetMe{" +
                "account_id=" + account_id +
                ", room_id=" + room_id +
                ", name='" + name + '\'' +
                ", chatwork_id='" + chatwork_id + '\'' +
                ", organization_id=" + organization_id +
                ", organization_name='" + organization_name + '\'' +
                ", department='" + department + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", introduction='" + introduction + '\'' +
                ", mail='" + mail + '\'' +
                ", tel_organization='" + tel_organization + '\'' +
                ", tel_extension='" + tel_extension + '\'' +
                ", tel_mobile='" + tel_mobile + '\'' +
                ", skype='" + skype + '\'' +
                ", facebook='" + facebook + '\'' +
                ", twitter='" + twitter + '\'' +
                ", avatar_image_url='" + avatar_image_url + '\'' +
                '}';
    }
}
