package com.dendy.tubes;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dendy.tubes.Model.GetUser;
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

public class LayarInsertUser extends AppCompatActivity {

    Context mContext;
    CircleImageView mImageView;
    Button btAddPhotoId, btAddData;
    EditText edtAddIdPembeli, edtAddNama, edtAddAlamat, edtAddTempatlahir, edtAddUsername, edtAddPassword;
    TextView tvAddMessage;
    String imagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_insert_user);

        mContext = getApplicationContext();
        mImageView = (CircleImageView) findViewById(R.id.imgAddPhotoId);
        btAddPhotoId = (Button)  findViewById(R.id.btAddPhotoId);
        edtAddNama = (EditText) findViewById(R.id.EditText2);
        edtAddAlamat = (EditText) findViewById(R.id.EditText3);
        edtAddTempatlahir = (EditText) findViewById(R.id.EditText4);
        edtAddUsername = (EditText) findViewById(R.id.EditText5);
        edtAddPassword = (EditText) findViewById(R.id.EditText6);

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
                        (edtAddNama.getText().toString().isEmpty())?"":edtAddNama.getText().toString());
                RequestBody reqAlamat = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddAlamat.getText().toString().isEmpty())?"":edtAddAlamat.getText().toString());
                RequestBody reqTempatlahir = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddTempatlahir.getText().toString().isEmpty())?"":edtAddTempatlahir.getText().toString());
                RequestBody reqUsername = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddUsername.getText().toString().isEmpty())?"":edtAddUsername.getText().toString());
                RequestBody reqPassword = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        (edtAddPassword.getText().toString().isEmpty())?"":edtAddPassword.getText().toString());
                RequestBody reqAction = MultipartBody.create(MediaType.parse("multipart/form-data"),
                        "insert");
                Call<GetUser> mPembeliCall = mApiInterface.postUser(body, reqNama,
                        reqAlamat, reqTempatlahir ,reqUsername, reqPassword, reqAction );
                mPembeliCall.enqueue(new Callback<GetUser>() {
                    @Override
                    public void onResponse(Call<GetUser> call, Response<GetUser> response) {
//                      Log.d("Insert Retrofit",response.body().getMessage());
                        if (response.body().getStatus().equals("failed")){
                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body()
                                    .getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+"\n");
                        }else{
                            String detail = "\n"+
                                    "nama = "+response.body().getResult().get(0).getNama()+"\n"+
                                    "alamat = "+response.body().getResult().get(0).getAlamat()+"\n"+
                                    "tempatlahir = "+response.body().getResult().get(0).getTempatlahir()+"\n"+
                                    "username = "+response.body().getResult().get(0).getUsername()+"\n"+
                                    "password = "+response.body().getResult().get(0).getPassword()+"\n"+
                                    "photo_url = "+response.body().getResult().get(0).getPhotoUrl()
                                    +"\n";
                            tvAddMessage.setText("Retrofit Insert \n Status = "+response.body().getStatus()+"\n"+
                                    "Message = "+response.body().getMessage()+detail);
                        }
                    }

                    @Override
                    public void onFailure(Call<GetUser> call, Throwable t) {
//                      Log.d("Insert Retrofit", t.getMessage());
                        tvAddMessage.setText("Retrofit Insert Failure \n Status = "+ t.getMessage
                                ());
                    }
                });
            }
        });
    }
}
