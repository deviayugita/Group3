package com.dendy.tubes;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dendy.tubes.Adapter.UserAdapter;
import com.dendy.tubes.Model.GetUser;
import com.dendy.tubes.Model.User;
import com.dendy.tubes.Rest.ApiClient;
import com.dendy.tubes.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListUser extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    FloatingActionButton btGet,btnAddData;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_user);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);
        btGet = findViewById(R.id.btGet);
        btnAddData = findViewById(R.id.btnInsert);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();

        btGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<GetUser> mPembeliCall = mApiInterface.getUser();
                mPembeliCall.enqueue(new Callback<GetUser>() {
                    @Override
                    public void onResponse(Call<GetUser> call, Response<GetUser> response) {
                        Log.d("Get Pembeli",response.body().getStatus());
                        List<User> listUser = response.body().getResult();
                        mAdapter = new UserAdapter(listUser);
                        mRecyclerView.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<GetUser> call, Throwable t) {
                        Log.d("Get Pembeli",t.getMessage());
                    }
                });
            }
        });

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, LayarInsertUser.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent intent = new Intent(mContext, MainActivity.class);
        startActivity(intent);
        return true;
    }
}
