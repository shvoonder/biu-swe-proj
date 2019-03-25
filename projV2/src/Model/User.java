package Model;

public class User {

    private int id;
    private String firstName;
    private String sureName;
    private String userName;
    private String password;
    private String email;
    private boolean isAdmin;

    public User(int id, String firstName, String sureName, String userName, String email, String password, boolean isAdmin) {
        this.id = id;
        this.firstName = firstName;
        this.sureName = sureName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
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

    public boolean isisAdmin() {
        return isAdmin;
    }

    public void setisAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}