package com.devi.uas.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.devi.uas.Models.Buku;
import com.devi.uas.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    List<Buku> mBuku;
    public MyAdapter(List<Buku> buku) {
        mBuku = buku;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_buku,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
//        viewHolder.nGambarnovel.setImageDrawable(mBuku[i]);
        viewHolder.nJudulnovel.setText(mBuku.get(i).getNama());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView nGambarnovel;
        public TextView nJudulnovel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nGambarnovel = itemView.findViewById(R.id.mPhoto);
            nJudulnovel = itemView.findViewById(R.id.mNama);
        }
    }
}
