package cn.edu.bcu.demo.domain;


public class User {
    private Integer id;
    private String user_name;
    private String psw;
    private String address;
    private String phone;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUser_name() {
        return user_name;
    }
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "TUser{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", psw='" + psw + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

