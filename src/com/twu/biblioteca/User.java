package com.twu.biblioteca;

public class User {
    String libraryNo;
    String password;
    String name;
    String email;
    String phoneNo;

    public User(String libraryNo, String password, String name, String email, String phoneNo) {
        this.libraryNo = libraryNo;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getLibraryNo() {
        return libraryNo;
    }

    public void setLibraryNo(String libraryNo) {
        this.libraryNo = libraryNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}
