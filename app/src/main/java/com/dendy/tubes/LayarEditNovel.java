package com.dendy.tubes;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.dendy.tubes.Model.GetBuku;
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

public class LayarEditNovel extends AppCompatActivity {

    CircleImageView mPhotoUrl;
    EditText edtIdNovel, edtNama, edtKategori, edtSinopsis , edtPengarang;
    TextView tvMessage;
    Context mContext;
    Button btUpdate, btDelete, btPhotoUrl;
    String pathImage="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_edit_novel);

        mContext = getApplicationContext();

        mPhotoUrl = (CircleImageView) findViewById(R.id.imgPhotoId);
        edtIdNovel = (EditText) findViewById(R.id.edtIdUser);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtKategori = (EditText) findViewById(R.id.edtAlamat);
        edtSinopsis = (EditText) findViewById(R.id.edtTempatlahir);
        edtPengarang = (EditText) findViewById(R.id.edtUsername);

        tvMessage = (TextView) findViewById(R.id.tvMessage);

        btUpdate = (Button) findViewById(R.id.btUpdate);
        btDelete = (Button) findViewById(R.id.btDelete);
        btPhotoUrl = (Button) findViewById(R.id.btPhotoId);

        Intent mIntent = getIntent();

        edtIdNovel.setText(mIntent.getStringExtra("id_novel"));
        edtNama.setText(mIntent.getStringExtra("nama"));
        edtKategori.setText(mIntent.getStringExtra("kategori"));
        edtSinopsis.setText(mIntent.getStringExtra("sinopsis"));
        edtPengarang.setText(mIntent.getStringExtra("pengarang"));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();

        //        if (mIntent.getStringExtra("photo_url").length()>0) Picasso.with(mContext).load
// (ApiClient.BASE_URL + mIntent.getStringExtra("photo_url")).into(mPhotoUrl);
//        else Picasso.with(mContext).load(R.drawable.photoid).into(mPhotoUrl);
        if (mIntent.getStringExtra("photo_url") != null)
            Glide.with(mContext).load(ApiClient.BASE_URL + mIntent.getStringExtra("photo_url")).into(mPhotoUrl);
        else
            Glide.with(mContext).load(R.drawable.default_user).into(mPhotoUrl);

        pathImage = mIntent.getStringExtra("photo_url");
        setListener();
    }
    private void setListener() {
        final ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MultipartBody.Part body = null;
                //dicek apakah image sama dengan yang ada di server atau berubah
                //jika sama dikirim lagi jika berbeda akan dikirim ke server
                if ((!pathImage.contains("upload/" + edtIdNovel.getText().toString())) &&
                        (pathImage.length() > 0)) {
                    //File creating from selected URL
                    File file = new File(pathImage);

                    // create RequestBody instance from file
                    RequestBody requestFile = RequestBody.create(
                            MediaType.parse("multipart/form-data"), file);

                    // MultipartBody.Part is used to send also the actual file name
                    body = MultipartBody.Part.createFormData("photo_url", file.getName(),
                            requestFile);
                }

                RequestBody reqIdNovel =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtIdNovel.getText().toString().isEmpty()) ?
                                        "" : edtIdNovel.getText().toString());

                RequestBody reqNama =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtNama.getText().toString().isEmpty()) ?
                                        "" : edtNama.getText().toString());

                RequestBody reqKategori =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtKategori.getText().toString().isEmpty()) ?
                                        "" : edtKategori.getText().toString());

                RequestBody reqSinopsis =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtSinopsis.getText().toString().isEmpty()) ?
                                        "" : edtSinopsis.getText().toString());

                RequestBody reqPengarang =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtPengarang.getText().toString().isEmpty()) ?
                                        "" : edtPengarang.getText().toString());
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"), "update");

                Call<GetBuku> callUpdate = mApiInterface.putBuku(body, reqIdNovel, reqNama,
                        reqKategori, reqSinopsis, reqPengarang, reqAction);

                callUpdate.enqueue(new Callback<GetBuku>() {
                    @Override
                    public void onResponse(Call<GetBuku> call, Response<GetBuku> response) {
                        //Log.d("Update Retrofit ", response.body().getStatus());
                        if (response.body().getStatus().equals("failed")) {
                            tvMessage.setText("Retrofit Update \n Status = " + response.body()
                                    .getStatus() + "\n" +
                                    "Message = " + response.body().getMessage() + "\n");
                        } else {
                            String detail = "\n" +
                                    "id_user = " + response.body().getResult().get(0).getId_novel() + "\n" +
                                    "nama = " + response.body().getResult().get(0).getNama() + "\n" +
                                    "kategori = " + response.body().getResult().get(0).getKategori() + "\n" +
                                    "sinopsis = " + response.body().getResult().get(0).getSinopsis() + "\n" +
                                    "pengarang = " + response.body().getResult().get(0).getPengarang() + "\n" +
                                    "photo_url = " + response.body().getResult().get(0).getPhotoUrl()
                                    + "\n";
                            tvMessage.setText("Retrofit Update \n Status = " + response.body().getStatus() + "\n" +
                                    "Message = " + response.body().getMessage() + detail);
                        }
                    }

                    @Override
                    public void onFailure(Call<GetBuku> call, Throwable t) {
                        //Log.d("Update Retrofit ", t.getMessage());
                        tvMessage.setText("Retrofit Update \n Status = " + t.getMessage());
                    }
                });

            }
        });
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestBody reqIdPembeli =
                        MultipartBody.create(MediaType.parse("multipart/form-data"),
                                (edtIdNovel.getText().toString().isEmpty()) ?
                                        "" : edtIdNovel.getText().toString());
                RequestBody reqAction =
                        MultipartBody.create(MediaType.parse("multipart/form-data"), "delete");

                Call<GetUser> callDelete = mApiInterface.deleteUser(reqIdPembeli, reqAction);
                callDelete.enqueue(new Callback<GetUser>() {
                    @Override
                    public void onResponse(Call<GetUser> call, Response<GetUser> response) {
                        tvMessage.setText("Retrofit Delete \n Status = " + response.body()
                                .getStatus() + "\n" +
                                "Message = " + response.body().getMessage() + "\n");
                    }

                    @Override
                    public void onFailure(Call<GetUser> call, Throwable t) {
                        tvMessage.setText("Retrofit Delete \n Status = " + t.getMessage());
                    }
                });
            }
        });
        btPhotoUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent galleryIntent = new Intent();
                galleryIntent.setType("image/*");
                galleryIntent.setAction(Intent.ACTION_PICK);
                Intent intentChoose = Intent.createChooser(galleryIntent, "Pilih foto untuk " +
                        "di-upload");
                startActivityForResult(intentChoose, 10);
            }
        });
    }
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == RESULT_OK && requestCode ==10) {
                if (data == null) {
                    Toast.makeText(mContext, "Foto gagal di-load", Toast.LENGTH_LONG).show();
                    return;
                }
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    pathImage = cursor.getString(columnIndex);

                    //Picasso.with(mContext).load(new File(imagePath)).fit().into(mImageView);
                    Glide.with(mContext).load(new File(pathImage)).into(mPhotoUrl);
                    cursor.close();
                } else {
                    Toast.makeText(mContext, "Foto gagal di-load", Toast.LENGTH_LONG).show();
                }
            }
        }
    @Override
    public boolean onSupportNavigateUp() {
        Intent tempIntent = new Intent(mContext, LayarListUser.class);
        startActivity(tempIntent);
        return true;
    }
}
