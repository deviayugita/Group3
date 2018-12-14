package com.devi.uas;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.devi.uas.Models.GetBuku;
import com.devi.uas.Models.PostPutDelNovel;
import com.devi.uas.Rest.ClientAPI;
import com.devi.uas.Rest.InterfaceAPI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Detail_buku extends AppCompatActivity {
    TextView judulnovel, penulisnovel, tanggalnovel, kategorinovel, sinopsisnovel, harganovel;
    Button btbuy, btBack;
    ImageView gambarnovel;
    InterfaceAPI mApiInterface;
    String id_user, id_novel, tgl;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        mApiInterface = ClientAPI.getClient().create(InterfaceAPI.class);
        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
        judulnovel= (TextView) findViewById(R.id.judulnovel);
        penulisnovel= (TextView) findViewById(R.id.penulisnovel);
        tanggalnovel= (TextView) findViewById(R.id.tglnovel);
        kategorinovel= (TextView) findViewById(R.id.kategorinovel);
        sinopsisnovel= (TextView) findViewById(R.id.sinopsisnovel);
        harganovel= (TextView) findViewById(R.id.harganovel);
        gambarnovel= (ImageView) findViewById(R.id.gambarnovel);
        btbuy = (Button) findViewById(R.id.btbuy);
        btBack = (Button) findViewById(R.id.btback);

        Intent mIntent = getIntent();
        id_user = "1";
        id_novel = (mIntent.getStringExtra("id_novel"));
        judulnovel.setText(mIntent.getStringExtra("nama"));
        penulisnovel.setText(mIntent.getStringExtra("penulis"));
        tanggalnovel.setText(mIntent.getStringExtra("tanggal_rilis"));
        kategorinovel.setText(mIntent.getStringExtra("kategori"));
        sinopsisnovel.setText(mIntent.getStringExtra("sinopsis"));
        harganovel.setText(mIntent.getStringExtra("harga"));
        Glide.with(getApplicationContext())
                .load("http://192.168.43.242:8080/novel/upload/" + mIntent.getStringExtra("photo"))
                .into(gambarnovel);

        Calendar newCalendar = Calendar.getInstance();
        tgl = dateFormatter.format(newCalendar.getTime());

        btbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                RequestBody idUser = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        (id_user.isEmpty())?"":id_user);
//                RequestBody idBuku = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        (id_novel.isEmpty())?"":id_novel);
//                RequestBody Tgl = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        (tgl.isEmpty())?"":tgl);
//                RequestBody Harga = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        (harganovel.getText().toString().isEmpty())?"":harganovel.getText().toString());
//                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"),
//                        "insert");
                Call<GetBuku> mPembeliCall = mApiInterface.postTrans(id_user, id_novel, tgl, harganovel.getText().toString());
                mPembeliCall.enqueue(new Callback<GetBuku>() {
                    @Override
                    public void onResponse(Call<GetBuku> call, Response<GetBuku> response) {
//                      Log.d("Insert Retrofit", response.body().getStatus());
                        if (response.body().getStatus().equals("fail")){
//                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body()
//                                    .getStatus()+"\n"+
//                                    "Message = "+response.body().getMessage()+"\n");
                            Toast.makeText(getApplicationContext(), "Retrofit Insert. Status = " + response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }else{
//                            String detail = "\n"+
//                                    "id_pembeli = "+response.body().getResult().get(0).getIdPembeli()+"\n"+
//                                    "nama = "+response.body().getResult().get(0).getNama()+"\n"+
//                                    "alamat = "+response.body().getResult().get(0).getAlamat()+"\n"+
//                                    "telp = "+response.body().getResult().get(0).getTelp()+"\n"+
//                                    "photo_url = "+response.body().getResult().get(0).getPhotoUrl()
//                                    +"\n";
//                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body().getStatus()+"\n"+
//                                    "Message = "+response.body().getMessage()+detail);
                            Toast.makeText(getApplicationContext(), "Retrofit Insert. Status = " + response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<GetBuku> call, Throwable t) {
//                      Log.d("Insert Retrofit", t.getMessage());
                        Toast.makeText(getApplicationContext(), "Retrofit Insert. Status = Berhasil", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


//        btbuy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Call<PostPutDelNovel> postPembelianCall =
//                        mApiInterface.postNovel(
//                                edtIdPembelian.getText().toString(),
//                                edtIdPembeli.getText().toString(),
//                                edtTanggalBeli.getText().toString(),
//                                edtTotalHarga.getText().toString(),
//                                edtIdTiket.getText().toString());
//                postPembelianCall.enqueue(new Callback<PostPutDelPembelian>() {
//                    @Override
//                    public void onResponse(Call<PostPutDelNovel> call,
//                                           Response<PostPutDelNovel> response) {
//                        tvMessage.setText(" Retrofit Insert: " +
//                                "\n " + " Status Insert : " +
//                                response.body().getStatus() +
//                                "\n " + " Message Insert : "+
//                                response.body().getMessage());
//                    }
//                    @Override
//                    public void onFailure(Call<PostPutDelNovel> call, Throwable t) {
//                        tvMessage.setText("Retrofit Insert: \n Status Insert :"+
//                                t.getMessage());
//                    }
//                });
//            }
//        });
//
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
