package com.dendy.tubes.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTransaksi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Transaksi> listDataPembelian;
    @SerializedName("message")
    String message;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Transaksi> getListDataPembelian() {
        return listDataPembelian;
    }

    public void setListDataPembelian(List<Transaksi> listDataPembelian) {
        this.listDataPembelian = listDataPembelian;
    }
}
