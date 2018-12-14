package com.devi.uas.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetBuku {
    @SerializedName("status")
    String status;

    @SerializedName("result")
    private List<Buku> result = new ArrayList<Buku>();


    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Buku> getResult() {
        return result;
    }

    public void setResult(List<Buku> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
