package com.dendy.tubes.Model;

import com.google.gson.annotations.SerializedName;

public class PostPutDelTransaksi {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Transaksi mPembelian;
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

    public Transaksi getPembelian() {
        return mPembelian;
    }

    public void setmPembelianLagu(Transaksi transaksi) {
        mPembelian = transaksi;
    }

}
