package com.devi.uas.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devi.uas.Detail_user;
import com.devi.uas.Models.User;
import com.devi.uas.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    List<User> listUser;

    public UserAdapter(List<User> listUser) {
        this.listUser = listUser;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_buku, parent, false);
        UserAdapter.UserViewHolder mHolder = new UserAdapter.UserViewHolder(view);
        return mHolder;
    }



    @Override
    public void onBindViewHolder(UserAdapter.UserViewHolder holder, final int position) {

        holder.mNama.setText(listUser.get(position).getNama());
        holder.mUsername.setText(listUser.get(position).getUsername());
        holder.mPassword.setText(listUser.get(position).getPassword());
        holder.mAlamat.setText(listUser.get(position).getAlamat());
        holder.mTempatlahir.setText(listUser.get(position).getTempatlahir());

        if (listUser.get(position).getPhoto() != null ){
            Glide.with(holder.itemView.getContext()).load("http://192.168.43.242:8080/novel/upload/"
                    +listUser.get(position).getPhoto())
                    .into(holder.mPhoto);
        } else {
            Glide.with(holder.itemView.getContext()).load(R.drawable.buku).into(holder
                    .mPhoto);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detail_user.class);
                intent.putExtra("id_user", listUser.get(position).getId_user());
                intent.putExtra("nama", listUser.get(position).getNama());
                intent.putExtra("username", listUser.get(position).getUsername());
                intent.putExtra("password", listUser.get(position).getPassword());
                intent.putExtra("alamat", listUser.get(position).getAlamat());
                intent.putExtra("tempatlahir", listUser.get(position).getTempatlahir());
                intent.putExtra("photo", listUser.get(position).getPhoto());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView mPhoto;
        TextView mNama, mUsername, mPassword, mAlamat, mTempatlahir;

        public UserViewHolder(View itemView) {
            super(itemView);
//            mPhoto = (ImageView) itemView.findViewById(R.id.mPhoto);
//            mNama = (TextView) itemView.findViewById(R.id.mNama);
//            mUsername = (TextView) itemView.findViewById(R.id.mUsername);
//            mPassword = (TextView) itemView.findViewById(R.id.mPassword);
//            mAlamat = (TextView) itemView.findViewById(R.id.mAlamat);
//            mTempatlahir = (TextView) itemView.findViewById(R.id.mTempatlahir);
        }
    }
}
