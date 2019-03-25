package Model;

public class User {

    private int id;
    private String firstName;
    private String sureName;
    private String userName;
    private String password;
    private String email;
    private boolean is_admin;

    public User(int id, String firstName, String sureName, String userName, String email, String password, boolean is_admin) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.is_admin = is_admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }
}