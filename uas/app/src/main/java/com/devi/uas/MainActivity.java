package com.devi.uas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.devi.uas.Models.GetUser;
import com.devi.uas.Models.User;
import com.devi.uas.Rest.InterfaceAPI;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    Button btn_login;
    boolean cek;
    public static MainActivity ak;
    InterfaceAPI mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        checkSavedCredentials();

        username = (EditText) findViewById(R.id.txt_username);
        password = (EditText) findViewById(R.id.txt_password);
        btn_login = (Button) findViewById(R.id.btn_login);

        ak = this;
    }


//    @Override
//    protected void onPause() {
//        // TODO Auto-generated method stub
//        super.onPause();
//        finish();
//    }
//
//    public void button_onClick(View view)
//    {
//        if (username.getText().toString().equals("") || password.getText().toString().equals("")) {
//            Toast.makeText(MainActivity.this, "Mohon Semua Data Di isi!", Toast.LENGTH_SHORT).show();
//        } else {
//            String tusername = username.getText().toString();
//            String tpassword = password.getText().toString();
//            checkCredentials(tusername, tpassword);
//        }
//    }
//
//    private void checkSavedCredentials()
//    {
//        SharedPreferences handler = this.getPreferences(Context.MODE_PRIVATE);
//        String tusername = handler.getString("username", "");
//        String tpassword = handler.getString("password", "");
//        checkCredentials(tusername, tpassword);
//    }
//
//    public void Logout()
//    {
//        SharedPreferences handler = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = handler.edit();
////        editor.remove("username");
//        editor.clear();
//        editor.commit();
//    }
//
//    private void saveCredentials()
//    {
//        SharedPreferences handler = this.getPreferences(Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = handler.edit();
//        editor.putString("username", this.username.getText().toString());
//        editor.putString("password", this.password.getText().toString());
//        editor.commit();
////        Toast.makeText(Akun.this, "Login Sukses", Toast.LENGTH_SHORT).show();
//    }
//
//
//    private boolean checkCredentials(String tusername, String tpassword)
//    {
//        SharedPreferences handler = this.getPreferences(Context.MODE_PRIVATE);
//        final String uss = handler.getString("username", "");
//        final String passw = handler.getString("password", "");
////            mApiInterface = Server.getClient().create(RegisterAPI.class); //PENTING
//        Call<List<User>> postUserCall = mApiInterface.getLogin(
//                tusername,
//                tpassword
//        );
//
//        postUserCall.enqueue(new Callback<List<User>>() {
//            @Override
//            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
//                List<User> userList = response.body();
//                if (userList.size() != 0){
//                    String id = userList.get(0).getId_user();
//                    String user = userList.get(0).getUsername();
//                    String pass = userList.get(0).getPassword();
//                    if (TextUtils.isEmpty(uss) || TextUtils.isEmpty(passw)) {
//                        saveCredentials();
//                        logedIn(id, user, pass);
//                    }
//                    else {
//                        logedIn(id, user, pass);
//                    }
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "Maaf, Gagal Login", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<User>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Silahkan Periksa Koneksi Lagi", Toast.LENGTH_SHORT).show();
//            }
//        });
//        return true;
//    }
//
//    private void logedIn(String id, String user, String pass) {
//        Intent i = new Intent(getApplicationContext(), MainActivity.class);
//        i.putExtra("username", user);
//        i.putExtra("password", pass);
//        i.putExtra("id", id);
//        startActivity(i);
//    }

}
