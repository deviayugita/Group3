package com.devi.uas.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Buku {
    @SerializedName("id_novel")
    @Expose
    private String id_novel;
    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("penulis")
    @Expose
    private String penulis;
    @SerializedName("tanggal_rilis")
    @Expose
    private String tanggal_rilis;
    @SerializedName("kategori")
    @Expose
    private String kategori;
    @SerializedName("sinopsis")
    @Expose
    private String sinopsis;
    @SerializedName("harga")
    @Expose
    private String harga;
    @SerializedName("photo")
    @Expose
    private String photo;


    public String getId_novel() {
        return id_novel;
    }

    public void setId_novel(String id_novel) {
        this.id_novel = id_novel;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTanggal_rilis() {
        return tanggal_rilis;
    }

    public void setTanggal_rilis(String tanggal_rilis) {
        this.tanggal_rilis = tanggal_rilis;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}
