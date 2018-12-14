package com.dendy.tubes.Model;

import com.google.gson.annotations.SerializedName;

public class Buku {

    @SerializedName("id_novel")
    private String id_novel;
    @SerializedName("nama")
    private String nama;
    @SerializedName("tanggal_rilis")
    private String tanggal_rilis;
    @SerializedName("kategori")
    private String kategori;
    @SerializedName("sinopsis")
    private String sinopsis;
    @SerializedName("pengarang")
    private String pengarang;
    @SerializedName("photo_url")
    private String photoUrl;
    private String action;

    public Buku(String id_novel, String nama, String tanggal_rilis, String kategori, String sinopsis, String pengarang, String photoUrl, String
            action) {
        this.id_novel = id_novel;
        this.nama = nama;
        this.tanggal_rilis = tanggal_rilis;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
        this.pengarang = pengarang;
        this.photoUrl = photoUrl;
        this.action = action;
    }

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

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPhotoUrl() { return photoUrl; }

    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    public String getAction() { return action; }

    public void setAction(String action) { this.action = action; }
}
