package model;

public class User {
    private int idUser;
    private String nameUser;
    private String userName;
    private String passWord;
    private String contact;
    private String address;
    private String email;
    private String img;
    private int role;

    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(int idUser, String nameUser, String userName, String passWord, String contact, String address, String email, String img, int role, int status) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.userName = userName;
        this.passWord = passWord;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.img = img;
        this.role = role;
        this.status = status;
    }

    public User(int idUser, String nameUser, String userName, String passWord, String contact, String address, String email, String img, int status) {
        this.idUser = idUser;
        this.nameUser = nameUser;
        this.userName = userName;
        this.passWord = passWord;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.img = img;
        this.status = status;
    }

    public User(String nameUser, String userName, String passWord, String contact, String address, String email, String img, int role, int status) {
        this.nameUser = nameUser;
        this.userName = userName;
        this.passWord = passWord;
        this.contact = contact;
        this.address = address;
        this.email = email;
        this.img = img;
        this.role = role;
        this.status = status;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
