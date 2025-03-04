package org.codenova.talkhub.model.vo;

import java.util.Date;

public class User {
    private String id;
    private String password;
    private String nickname;
    private String gender;
    private int birth;
    private Date createdAt;

    public User() {
    }

    public User(String id, String password, String nickname, String gender, int birth, Date createdAt) {
        this.id = id;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.birth = birth;
        this.createdAt = createdAt;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getGender() {
        return gender;
    }

    public int getBirth() {
        return birth;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
