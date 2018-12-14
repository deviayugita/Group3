package com.dendy.tubes.Rest;

import com.dendy.tubes.Model.GetBuku;
import com.dendy.tubes.Model.GetTransaksi;
import com.dendy.tubes.Model.GetUser;
import com.dendy.tubes.Model.PostPutDelTransaksi;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

public interface ApiInterface {
    @GET("transaksi/user")
    Call<GetTransaksi> getTransaksi();

    @FormUrlEncoded
    @POST("transaksi/user")
    Call<PostPutDelTransaksi> postTransaksi
            (@Field("id_trans") String idTrans,
             @Field("id_user") String idUser,
             @Field("id_novel") String idNovel,
             @Field("tanggal_beli") String tanggalBeli,
             @Field("harga") String harga);

    @FormUrlEncoded
    @PUT("transaksi/user")
    Call<PostPutDelTransaksi> putTransaksi
            (@Field("id_trans") String idTrans,
             @Field("id_user") String idUser,
             @Field("id_novel") String idNovel,
             @Field("tanggal_beli") String tanggalBeli,
             @Field("harga") String harga);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "transaksi/user", hasBody = true)
    Call<PostPutDelTransaksi> deletePembelian(@Field("id_trans") String idTrans);

    @GET("user/all")
    Call<GetUser> getUser();

    @Multipart
    @POST("user/all")
    Call<GetUser> postUser(
            @Part MultipartBody.Part file,
            @Part("nama") RequestBody nama,
            @Part("alamat") RequestBody alamat,
            @Part("tempatlahir") RequestBody tempatlahir,
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("user/all")
    Call<GetUser> putUser(
            @Part MultipartBody.Part file,
            @Part("id_user") RequestBody idPembeli,
            @Part("nama") RequestBody nama,
            @Part("alamat") RequestBody alamat,
            @Part("tempatlahir") RequestBody tempatlahir,
            @Part("username") RequestBody username,
            @Part("password") RequestBody password,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("user/all")
    Call<GetUser> deleteUser(
            @Part("id_user") RequestBody idUser,
            @Part("action") RequestBody action);


    @GET("buku/all")
    Call<GetBuku> getBuku();

    @Multipart
    @POST("buku/all")
    Call<GetBuku> postBuku(
            @Part MultipartBody.Part file,
            @Part("nama") RequestBody nama,
            @Part("kategori") RequestBody kategori,
            @Part("sinopsis") RequestBody sinopsis,
            @Part("pengarang") RequestBody pengarang,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("buku/all")
    Call<GetBuku> putBuku(
            @Part MultipartBody.Part file,
            @Part("id_novel") RequestBody id_novel,
            @Part("nama") RequestBody nama,
            @Part("kategori") RequestBody kategori,
            @Part("sinopsis") RequestBody sinopsis,
            @Part("pengarang") RequestBody pengarang,
            @Part("action") RequestBody action
    );

    @Multipart
    @POST("buku/all")
    Call<GetBuku> deleteBuku(
            @Part("id_novel") RequestBody idNovel,
            @Part("action") RequestBody action);
}
