package com.dendy.tubes.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dendy.tubes.LayarEditUser;
import com.dendy.tubes.Model.User;
import com.dendy.tubes.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user, parent, false);
        UserViewHolder mHolder = new UserViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(UserAdapter.UserViewHolder holder, final int position) {

        holder.tvIdPembeli.setText(userList.get(position).getId_user());
        holder.tvNama.setText(userList.get(position).getNama());
        holder.tvAlamat.setText(userList.get(position).getAlamat());
        holder.tvTempatLahir.setText(userList.get(position).getTempatlahir());
        holder.tvUsername.setText(userList.get(position).getUsername());
        holder.tvPassword.setText(userList.get(position).getPassword());
        if (userList.get(position).getPhotoUrl() != null) {
//            Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listPembeli.get(position).getPhotoId())
//                    .into(holder.mPhotoURL);
            Glide.with(holder.itemView.getContext()).load(userList.get
                    (position).getPhotoUrl())
                    .into(holder.mPhotoURL);
        } else {
//          Picasso.with(holder.itemView.getContext()).load(R.drawable.photoid).into(holder
// .mPhotoURL);
            Glide.with(holder.itemView.getContext()).load(R.drawable.default_user).into(holder
                    .mPhotoURL);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),LayarEditUser.class);
                intent.putExtra("id_pembeli",userList.get(position).getId_user());
                intent.putExtra("nama",userList.get(position).getNama());
                intent.putExtra("alamat",userList.get(position).getAlamat());
                intent.putExtra("tempatlahir",userList.get(position).getTempatlahir());
                intent.putExtra("username",userList.get(position).getUsername());
                intent.putExtra("password",userList.get(position).getPassword());
                intent.putExtra("photo_url",userList.get(position).getPhotoUrl());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mPhotoURL;
        TextView tvIdPembeli, tvNama, tvAlamat, tvTempatLahir, tvUsername, tvPassword;

        public UserViewHolder(View itemView) {
            super(itemView);
            mPhotoURL =  itemView.findViewById(R.id.imgPembeli);
            tvIdPembeli = (TextView) itemView.findViewById(R.id.tvIdPembeli);
            tvNama = (TextView) itemView.findViewById(R.id.tvNama);
            tvAlamat = (TextView) itemView.findViewById(R.id.tvAlamatContent);
            tvTempatLahir = (TextView) itemView.findViewById(R.id.tvTempatlahirContent);
            tvUsername = (TextView) itemView.findViewById(R.id.tvUsernameContent);
            tvPassword = (TextView) itemView.findViewById(R.id.tvPasswordContent);
        }
    }
}