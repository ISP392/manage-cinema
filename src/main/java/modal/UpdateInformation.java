package modal;

import util.Encrypt;

import java.security.NoSuchAlgorithmException;

public class UpdateInformation {
    private String information;
    private String oldEmail;
    private String oldDisplayName;
    private String oldPassword;

    public UpdateInformation(String information, String oldEmail, String oldDisplayName, String oldPassword) {
        this.information = information;
        this.oldEmail = oldEmail;
        this.oldDisplayName = oldDisplayName;
        this.oldPassword = oldPassword;
    }

    public UpdateInformation() {
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getOldEmail() {
        return oldEmail;
    }

    public void setOldEmail(String oldEmail) {
        this.oldEmail = oldEmail;
    }

    public String getOldDisplayName() {
        return oldDisplayName;
    }

    public void setOldDisplayName(String oldDisplayName) {
        this.oldDisplayName = oldDisplayName;
    }

    public String getOldPassword() {
        return oldPassword;
    }
}
