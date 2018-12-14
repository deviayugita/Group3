package com.devi.uas.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by TEst on 13/12/2017.
 */

public class Transaksi {
    @SerializedName("id_trans")
    @Expose
    private String id_trans;
    @SerializedName("id_user")
    @Expose
    private String id_user;
    @SerializedName("id_novel")
    @Expose
    private String id_novel;
    @SerializedName("tanggal_beli")
    @Expose
    private String tanggal_beli;
    @SerializedName("harga")
    @Expose
    private String harga;


    public String getId_trans() {
        return id_trans;
    }

    public void setId_trans(String id_trans) {
        this.id_trans = id_trans;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_novel() {
        return id_novel;
    }

    public void setId_novel(String id_novel) {
        this.id_novel = id_novel;
    }

    public String getTanggal_beli() {
        return tanggal_beli;
    }

    public void setTanggal_beli(String tanggal_beli) {
        this.tanggal_beli = tanggal_beli;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
}

