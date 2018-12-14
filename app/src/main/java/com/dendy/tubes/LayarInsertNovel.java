package com.dendy.tubes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dendy.tubes.Model.GetBuku;
import com.dendy.tubes.Rest.ApiClient;
import com.dendy.tubes.Rest.ApiInterface;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarInsertNovel extends AppCompatActivity {

    Context mContext;
    CircleImageView mImageView;
    Button btAddPhotoId, btAddData;
    EditText edtAddIdNovel, edtAddNamaNovel, edtAddTanggalRilis, edtAddKategori, edtAddSinopsis, edtAddPengarang;
    TextView tvAddMessage;
    String imagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_insert_novel);

        mContext = getApplicationContext();
        mImageView = (CircleImageView) findViewById(R.id.imgAddPhotoId);
        btAddPhotoId = (Button)  findViewById(R.id.btAddPhotoId);
        edtAddNamaNovel = (EditText) findViewById(R.id.pecel2);
        edtAddKategori = (EditText) findViewById(R.id.pecel3);
        edtAddSinopsis = (EditText) findViewById(R.id.pecel4);
        edtAddPengarang = (EditText) findViewById(R.id.pecel5);

        btAddData = (Button) findViewById(R.id.btAddData);
        tvAddMessage = (TextView) findViewById(R.id.tvAddMessage);

        btAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

                MultipartBody.Part body = null;
                if (!imagePath.isEmpty()){
                    // Buat file dari image yang dipilih
                    File file = new File(imagePath);

                    // Buat RequestBody instance dari file
                    RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);

                    // MultipartBody.Part digunakan untuk mendapatkan nama file
                    body = MultipartBody.Part.createFormData("photo_url", file.getName(),
                            requestFile);
                }
                RequestBody reqNama = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddNamaNovel.getText().toString().isEmpty())?"":edtAddNamaNovel.getText().toString());
                RequestBody reqKategori = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddKategori.getText().toString().isEmpty())?"":edtAddKategori.getText().toString());
                RequestBody reqPengarang = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddPengarang.getText().toString().isEmpty())?"":edtAddPengarang.getText().toString());
                RequestBody reqSinopsis = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddSinopsis.getText().toString().isEmpty())?"":edtAddSinopsis.getText().toString());
                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        "insert");
                Call<GetBuku> mPembeliCall = mApiInterface.postBuku(body, reqNama,
                        reqKategori, reqPengarang ,reqSinopsis, reqAction );
                mPembeliCall.enqueue(new Callback<GetBuku>() {
                    @Override
                    public void onResponse(Call<GetBuku> call, Response<GetBuku> response) {
//                      Log.d("Insert Retrofit",response.body().getMessage());
                        if (response.body().getStatus().equals("failed")){
                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body()
                                    .getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+
                                    "nama = "+response.body().getResult().get(0).getNama()+"\n"+
                                    "kategori = "+response.body().getResult().get(0).getKategori()+"\n"+
                                    "sinopsis = "+response.body().getResult().get(0).getSinopsis()+"\n"+
                                    "pengarang = "+response.body().getResult().get(0).getPengarang()+"\n"+
                                    "photo_url = "+response.body().getResult().get(0).getPhotoUrl()
                                    +"\n";
                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body().getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+detail);
                        }
                    }

                    @Override
                    public void onFailure(Call<GetBuku> call, Throwable t) {
//                      Log.d("Insert Retrofit", t.getMessage());
                        tvAddMessage.setText("Retrofit Insert Failure \n Status = "+ t.getMessage
                                ());
                    }
                });
            }
        });
        btAddPhotoId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(
                        galleryIntent,
                        "Pilih foto untuk di-upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }
}
