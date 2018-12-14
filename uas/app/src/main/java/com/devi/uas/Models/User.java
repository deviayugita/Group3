package com.devi.uas.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class User {
    //----------------------

//    @SerializedName("status")
//    String status;
//
//    @SerializedName("result")
//    private List<User> result = new ArrayList<>();
//
//
//    @SerializedName("message")
//    String message;


    //----------------------



    @SerializedName("id_user")
    @Expose
    private String id_user;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("tempatlahir")
    @Expose
    private String tempatlahir;
    @SerializedName("photo")
    @Expose
    private String photo;

//-----------------

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public List<User> getResult() {
//        return result;
//    }
//
//    public void setResult(List<User> result) {
//        this.result = result;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

//----------------------



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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
