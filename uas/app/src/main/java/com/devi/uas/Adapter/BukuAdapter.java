package com.devi.uas.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.devi.uas.Detail_buku;
import com.devi.uas.Models.Buku;
import com.devi.uas.R;

import java.util.List;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {
    List<Buku> listBuku;

    public BukuAdapter(List<Buku> listBuku) {
        this.listBuku = listBuku;
    }

    @Override
    public BukuAdapter.BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_buku, parent, false);
        BukuViewHolder mHolder = new BukuViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(BukuAdapter.BukuViewHolder holder, final int position) {

        holder.mNama.setText(listBuku.get(position).getNama());
        holder.mKategori.setText(listBuku.get(position).getKategori());
        holder.mHarga.setText(listBuku.get(position).getHarga());
        holder.mTanggal.setText(listBuku.get(position).getTanggal_rilis());

        if (listBuku.get(position).getPhoto() != null ){
            Glide.with(holder.itemView.getContext()).load("http://192.168.43.242:8080/novel/upload/"+listBuku.get(position).getPhoto())
                    .into(holder.mPhoto);
        } else {
            Glide.with(holder.itemView.getContext()).load(R.drawable.buku).into(holder
                    .mPhoto);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Detail_buku.class);
                intent.putExtra("id_novel", listBuku.get(position).getId_novel());
                intent.putExtra("nama", listBuku.get(position).getNama());
                intent.putExtra("penulis", listBuku.get(position).getPenulis());
                intent.putExtra("tanggal_rilis", listBuku.get(position).getTanggal_rilis());
                intent.putExtra("kategori", listBuku.get(position).getKategori());
                intent.putExtra("sinopsis", listBuku.get(position).getSinopsis());
                intent.putExtra("photo", listBuku.get(position).getPhoto());
                intent.putExtra("harga", listBuku.get(position).getHarga());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBuku.size();
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        ImageView mPhoto;
        TextView mNama, mTanggal, mKategori, mHarga;

        public BukuViewHolder(View itemView) {
            super(itemView);
            mPhoto = (ImageView) itemView.findViewById(R.id.mPhoto);
            mNama = (TextView) itemView.findViewById(R.id.mNama);
            mTanggal = (TextView) itemView.findViewById(R.id.mTanggal);
            mKategori = (TextView) itemView.findViewById(R.id.mKategori);
            mHarga = (TextView) itemView.findViewById(R.id.mHarga);
        }
    }
}
