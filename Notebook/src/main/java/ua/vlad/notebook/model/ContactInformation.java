package ua.vlad.notebook.model;

/**
 * Created by vlad on 07.11.16.
 */
public class ContactInformation {

    private String homePhone;
    private String mobilePhone;
    private String mobilePhone2;
    private String email;
    private String skype;

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getMobilePhone2() {
        return mobilePhone2;
    }

    public void setMobilePhone2(String mobilePhone2) {
        this.mobilePhone2 = mobilePhone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
                "homePhone='" + homePhone + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", mobilePhone2='" + mobilePhone2 + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                '}';
    }
}
