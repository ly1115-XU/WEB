package model;

public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String name;
    private String phone;
    private String address;
    private int admintype;
    private boolean isadmin=false;
    private boolean isvalidate=false;
    private boolean ismanage=false;

    public User(){

    }

    public User(int id, String username, String email, String password, String name, String phone,
                String address, int admintype, boolean isadmin, boolean isvalidate, boolean ismanage) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.admintype = admintype;
        this.isadmin = isadmin;
        this.isvalidate = isvalidate;
        this.ismanage = ismanage;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", admintype=" + admintype +
                ", isadmin=" + isadmin +
                ", isvalidate=" + isvalidate +
                ", ismanage=" + ismanage +
                '}';
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public int getAdmintype() {
        return admintype;
    }

    public void setAdmintype(int admintype) {
        this.admintype = admintype;
    }

    public boolean isIsmanage() {
        return ismanage;
    }

    public void setIsmanage(boolean ismanage) {
        this.ismanage = ismanage;
    }

    public boolean isIsvalidate() {
        return isvalidate;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public void setIsvalidate(boolean isvalidate) {
        this.isvalidate = isvalidate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
