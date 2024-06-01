package modal;

public class Role {
    private int roleID;
    private String name;

    public Role() {
    }

    public Role(int roleID, String name) {
        this.roleID = roleID;
        this.name = name;
    }

    public Role(int roleID) {
        this.roleID = roleID;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
