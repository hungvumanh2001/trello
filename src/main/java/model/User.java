package model;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String fullname;
    private String address;
    private String phonenumber;
    private String role;
    private String status;

    public User() {
    }

    public User(int id, String username, String password, String email, String fullname, String address, String phonenumber, String role, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullname = fullname;
        this.address = address;
        this.phonenumber = phonenumber;
        this.role = role;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
