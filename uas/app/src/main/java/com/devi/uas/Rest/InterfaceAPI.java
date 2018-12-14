package com.devi.uas.Rest;

import com.devi.uas.Models.Buku;
import com.devi.uas.Models.GetBuku;
import com.devi.uas.Models.GetUser;
import com.devi.uas.Models.User;

import java.util.List;

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
import retrofit2.http.Query;

/**
 * Created by TEst on 10/12/2017.
 */

public interface InterfaceAPI {
    @GET("Novel/all")
    Call<GetBuku> getBuku();

    @FormUrlEncoded
    @POST("Transaksi/all")
    Call<GetBuku> postTrans(
            @Field("id_user") String id_user,
            @Field("id_novel") String id_novel,
            @Field("tanggal_beli") String tanggal_beli,
            @Field("harga") String harga);

//    @FormUrlEncoded
//    @POST("User")
//    Call<Value> daftar(@Field("username") String username,
//                       @Field("password") String password,
//                       @Field("level") String level);
//
//    @FormUrlEncoded
//    @PUT("User")
//    Call<Value> putUser(@Field("id_user") String idUser,
//                        @Field("username") String username,
//                        @Field("password") String password,
//                        @Field("level") String level);
//
    @GET("Login")
    Call<List<User>> getLogin(@Query("username") String username,
                              @Query("password") String password);
    //@FormUrlEncoded
//
//    @GET("tanamanScan")
//    Call<List<Result>> view(@Query("nama") String nama);
//
//    @FormUrlEncoded
//    @POST("Histori")
//    Call<Value> histori(@Field("id_user") String id_user,
//                        @Field("id_tnmn") String id_tnmn);
//
//    @GET("Histori")
//    Call<List<Result>> viewH(@Query("id_user") String id_user);
//
//    @FormUrlEncoded
//    @HTTP(method = "DELETE", path = "Histori", hasBody = true)
//    Call<Value> deleteH(@Field("id_user") String idUser);

}
