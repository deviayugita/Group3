package com.devi.uas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.devi.uas.Adapter.BukuAdapter;
import com.devi.uas.Models.GetBuku;
import com.devi.uas.Rest.InterfaceAPI;
import com.devi.uas.Adapter.MyAdapter;
import com.devi.uas.Models.Buku;
import com.devi.uas.Rest.ClientAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Home extends AppCompatActivity {
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    InterfaceAPI mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        loadData();
    }

    private void loadData() {
        mApiInterface = ClientAPI.getClient().create(InterfaceAPI.class);
        Call<GetBuku> mBukuCall = mApiInterface.getBuku();
        mBukuCall.enqueue(new Callback<GetBuku>() {
            @Override
            public void onResponse(Call<GetBuku> call, Response<GetBuku> response) {
//
                List<Buku> bukuList = response.body().getResult();
                mAdapter = new BukuAdapter(bukuList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetBuku> call, Throwable t) {
                Log.d("Get Buku",t.getMessage());
            }
        });
    }
}
