package com.devi.uas.Models;

import com.google.gson.annotations.SerializedName;

public class PostPutDelNovel {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Buku mBuku;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Buku getPembelian() {
        return mBuku;
    }
    public void setPembelian(Buku buku) {
        mBuku = buku;
    }
}
