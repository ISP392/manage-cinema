/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modal;

/**
 *
 *
 * @author MISS NGA
 */
public class Users {

    private int userID;
    private String displayName;
    private String userName;
    private String password;
    private Role roleID;
    private String email;
    private String providerID;
    private int point;
    private StaffStatus phone;

    public Users() {
    }

    public Users(int userID, String displayName, String userName, String password, Role roleID, String email, String providerID, int point, StaffStatus phone) {
        this.userID = userID;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.roleID = roleID;
        this.email = email;
        this.providerID = providerID;
        this.point = point;
        this.phone = phone;
    }

    
    public Users(String email) {
        this.email = email;
    }

    public Users(int userID, String email) {
        this.userID = userID;
        this.email = email;
    }

    public Users(String email, String displayName) {
        this.displayName = displayName;
        this.email = email;
    }

    public Users(String email, String password, int dummy) {
        this.email = email;
        this.password = password;
    }

    public Users(String userName, String displayName, String email) {
        this.userName = userName;
        this.displayName = displayName;
        this.email = email;
    }

    public Users(int userID, String displayName, String userName, String password, String email, Role roleID, int point, String providerID) {
        this.userID = userID;
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.roleID = roleID;
        this.point = point;
        this.providerID = providerID;
    }

    public Users(String displayName, String userName, String password, String email) {
        this.displayName = displayName;
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRoleID() {
        return roleID;
    }

    public void setRoleID(Role roleID) {
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getProviderID() {
        return providerID;
    }

    public void setProviderID(String providerID) {
        this.providerID = providerID;
    }

    public StaffStatus getPhone() {
        return phone;
    }

    public void setPhone(StaffStatus phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Users{" + "userID=" + userID + ", displayName=" + displayName + ", userName=" + userName + ", password=" + password + ", roleID=" + roleID + ", email=" + email + ", providerID=" + providerID + ", point=" + point + ", phone=" + phone + '}';
    }

    

}
