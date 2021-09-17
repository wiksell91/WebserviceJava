package com.ViMiJo.webservicemusicaccount;

public class AccountUser {

    // Autogenerera Id eller felhantgering vid id
    private int id;
    private String userName;
    private String name;
    private String passWord;



    public AccountUser(int id, String userName, String name, String passWord) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
