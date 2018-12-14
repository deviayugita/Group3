package com.dendy.tubes.Model;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id_user")
    private String id_user;
    @SerializedName("nama")
    private String nama;
    @SerializedName("alamat")
    private String alamat;
    @SerializedName("tempatlahir")
    private String tempatlahir;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;
    @SerializedName("photo_url")
    private String photoUrl;
    private String action;

    public User(String id_user, String nama, String alamat, String tempatlahir, String username, String password, String photoUrl, String
            action) {
        this.id_user = id_user;
        this.nama = nama;
        this.alamat = alamat;
        this.tempatlahir = tempatlahir;
        this.username = username;
        this.password = password;
        this.photoUrl = photoUrl;
        this.action = action;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTempatlahir() {
        return tempatlahir;
    }

    public void setTempatlahir(String tempatlahir) {
        this.tempatlahir = tempatlahir;
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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
