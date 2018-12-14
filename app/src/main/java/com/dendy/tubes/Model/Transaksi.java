package com.dendy.tubes.Model;

import com.google.gson.annotations.SerializedName;

public class Transaksi {
    @SerializedName("id_trans")
    private String id_trans;
    @SerializedName("id_user")
    private String id_user;
    @SerializedName("id_novel")
    private String id_novel;
    @SerializedName("tanggal_beli")
    private String tanggal_beli;
    @SerializedName("harga")
    private String harga;

    public Transaksi(String id_trans, String id_user, String id_novel, String tanggal_beli, String harga) {
        this.id_trans = id_trans;
        this.id_user = id_user;
        this.id_novel = id_novel;
        this.tanggal_beli = tanggal_beli;
        this.harga = harga;
    }

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
