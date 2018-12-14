package com.dendy.tubes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.dendy.tubes.Adapter.MyAdapter;
import com.dendy.tubes.Model.GetTransaksi;
import com.dendy.tubes.Model.Transaksi;
import com.dendy.tubes.Rest.ApiClient;
import com.dendy.tubes.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FloatingActionButton btGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btGet = findViewById(R.id.btGet);

        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Call<GetTransaksi> pembelianCall = mApiInterface.getTransaksi();
                pembelianCall.enqueue(new Callback<GetTransaksi>() {
                    @Override
                    public void onResponse(Call<GetTransaksi> call, Response<GetTransaksi> response) {
                        List<Transaksi> pembelianList = response.body().getListDataPembelian();
                        Log.d("Retrofit Get", "Jumlah data pembelian: " + String.valueOf(pembelianList.size()));

                        mAdapter = new MyAdapter(pembelianList);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetTransaksi> call, Throwable t) {
                        // Log error
                        Log.e("Retrofit Get", t.toString());
                    }
                });
            }
        });
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {

            case R.id.menuTambahTransPembelian:
                mIntent = new Intent(this, LayarDetailTransaksi.class);
                startActivity(mIntent);
                return true;

            case R.id.menuListUser:
                mIntent = new Intent(this, LayarListUser.class);
                startActivity(mIntent);
                return true;

            case R.id.menuInsertDataUser:
                Intent intent = new Intent(this, LayarInsertUser.class);
                startActivity(intent);
                return true;

            case R.id.menuListNovel:
                mIntent = new Intent(this, LayarListNovel.class);
                startActivity(mIntent);
                return true;

            case R.id.menuInsertDataNovel:
                Intent intent1 = new Intent(this, LayarInsertNovel.class);
                startActivity(intent1);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
