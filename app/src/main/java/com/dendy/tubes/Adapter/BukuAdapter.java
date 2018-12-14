package com.dendy.tubes.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dendy.tubes.LayarEditNovel;
import com.dendy.tubes.Model.Buku;
import com.dendy.tubes.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BukuAdapter extends RecyclerView.Adapter<BukuAdapter.BukuViewHolder> {

    List<Buku> BukuList;
    public BukuAdapter(List<Buku> Bukulist) {
        this.BukuList = Bukulist;
    }

    @Override
    public BukuAdapter.BukuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_buku, parent, false);
        BukuViewHolder mHolder = new BukuViewHolder(view);
        return mHolder;
    }
    @Override
    public void onBindViewHolder(BukuAdapter.BukuViewHolder holder, final int position) {

        holder.tvIdPembeli.setText(BukuList.get(position).getId_novel());
        holder.tvNama.setText(BukuList.get(position).getNama());
        holder.tvKategori.setText(BukuList.get(position).getKategori());
        holder.tvSinopsis.setText(BukuList.get(position).getSinopsis());
        holder.tvPengarang.setText(BukuList.get(position).getPengarang());
        if (BukuList.get(position).getPhotoUrl() != null) {
//            Picasso.with(holder.itemView.getContext()).load(ApiClient.BASE_URL+listPembeli.get(position).getPhotoId())
//                    .into(holder.mPhotoURL);
            Glide.with(holder.itemView.getContext()).load(BukuList.get
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
                Intent intent = new Intent(v.getContext(),LayarEditNovel.class);
                intent.putExtra("id_pembeli",BukuList.get(position).getId_novel());
                intent.putExtra("nama",BukuList.get(position).getNama());
                intent.putExtra("kategori",BukuList.get(position).getKategori());
                intent.putExtra("sinopsis",BukuList.get(position).getSinopsis());
                intent.putExtra("pengarang",BukuList.get(position).getPengarang());
                intent.putExtra("photo_url",BukuList.get(position).getPhotoUrl());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return BukuList.size();
    }

    public class BukuViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mPhotoURL;
        TextView tvIdPembeli, tvNama, tvKategori, tvSinopsis, tvPengarang;

        public BukuViewHolder(View itemView) {
            super(itemView);
            mPhotoURL =  itemView.findViewById(R.id.imgPembeli);
            tvIdPembeli = (TextView) itemView.findViewById(R.id.tvIdPembeli);
            tvNama = (TextView) itemView.findViewById(R.id.tvNama);
            tvKategori = (TextView) itemView.findViewById(R.id.tvKategoriContent);
            tvSinopsis = (TextView) itemView.findViewById(R.id.tvSinopsisContent);
            tvPengarang = (TextView) itemView.findViewById(R.id.tvPengarangContent);
        }
    }
}
