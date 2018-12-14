package com.dendy.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dendy.tubes.Model.PostPutDelTransaksi;
import com.dendy.tubes.Rest.ApiClient;
import com.dendy.tubes.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarDetailTransaksi extends AppCompatActivity {

    EditText edtIdTrans, edtIdUser, edtTanggalBeli, edtIdNovel, edtHarga;
    Button btInsert, btUpdate, btDelete, btBack;
    TextView tvMessage;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_detail_transaksi);

        edtIdTrans = (EditText) findViewById(R.id.edtIdTrans);
        edtIdUser = (EditText) findViewById(R.id.edtIdUser);
        edtTanggalBeli = (EditText) findViewById(R.id.edtTanggal);
        edtIdNovel = (EditText) findViewById(R.id.edtIdNovel);
        edtHarga = (EditText) findViewById(R.id.edtHarga);
        tvMessage = (TextView) findViewById(R.id.tvMessage2);

        btInsert = (Button) findViewById(R.id.btInsert2);
        btUpdate = (Button) findViewById(R.id.btUpdate2);
        btDelete = (Button) findViewById(R.id.btDelete2);
        btBack = (Button) findViewById(R.id.btBack);

        Intent mIntent = getIntent();
        edtIdTrans.setText(mIntent.getStringExtra("id_trans"));
        edtIdUser.setText(mIntent.getStringExtra("id_user"));
        edtTanggalBeli.setText(mIntent.getStringExtra("tanggal_beli"));
        edtIdNovel.setText(mIntent.getStringExtra("id_novel"));
        edtHarga.setText(mIntent.getStringExtra("harga"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelTransaksi> updatePembelianCall = mApiInterface.putTransaksi(
                        edtIdTrans.getText().toString(),
                        edtIdUser.getText().toString(),
                        edtTanggalBeli.getText().toString(),
                        edtHarga.getText().toString(),
                        edtIdNovel.getText().toString());

                updatePembelianCall.enqueue(new Callback<PostPutDelTransaksi>() {
                    @Override
                    public void onResponse(Call<PostPutDelTransaksi> call, Response<PostPutDelTransaksi> response) {
                        tvMessage.setText(" Retrofit Update: " +
                                "\n " + " Status Update : " +response.body().getStatus() +
                                "\n " + " Message Update : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelTransaksi> call, Throwable t) {
                        tvMessage.setText("Retrofit Update: \n Status Update :"+ t.getMessage());
                    }
                });
            }
        });

        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<PostPutDelTransaksi> postPembelianCall = mApiInterface.postTransaksi(
                        edtIdTrans.getText().toString(),
                        edtIdUser.getText().toString(),
                        edtTanggalBeli.getText().toString(),
                        edtHarga.getText().toString(),
                        edtIdNovel.getText().toString());

                postPembelianCall.enqueue(new Callback<PostPutDelTransaksi>() {
                    @Override
                    public void onResponse(Call<PostPutDelTransaksi> call, Response<PostPutDelTransaksi> response) {
                        tvMessage.setText(" Retrofit Insert: " +
                                "\n " + " Status Insert : " +
                                response.body().getStatus() +
                                "\n " + " Message Insert : "+ response.body().getMessage());
                    }

                    @Override
                    public void onFailure(Call<PostPutDelTransaksi                      > call, Throwable t) {
                        tvMessage.setText("Retrofit Insert: \n Status Insert :"+ t.getMessage());
                    }
                });
            }
        });

        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtIdTrans.getText().toString().trim().isEmpty()){

                    Call<PostPutDelTransaksi> deletePembelian = mApiInterface.deletePembelian(edtIdTrans.getText().toString());
                    deletePembelian.enqueue(new Callback<PostPutDelTransaksi>() {
                        @Override
                        public void onResponse(Call<PostPutDelTransaksi> call, Response<PostPutDelTransaksi> response) {
                            tvMessage.setText(" Retrofit Delete: " +
                                    "\n " + " Status Delete : " +response.body().getStatus() +
                                    "\n " + " Message Delete : "+ response.body().getMessage());
                        }

                        @Override
                        public void onFailure(Call<PostPutDelTransaksi> call, Throwable t) {
                            tvMessage.setText("Retrofit Delete: \n Status Delete :"+ t.getMessage());
                        }
                    });
                }else{
                    tvMessage.setText("id_pembelian harus diisi");
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mIntent);
            }
        });
    }
}
