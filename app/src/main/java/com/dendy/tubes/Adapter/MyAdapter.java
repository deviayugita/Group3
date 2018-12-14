package com.dendy.tubes.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dendy.tubes.LayarDetailTransaksi;
import com.dendy.tubes.Model.Transaksi;
import com.dendy.tubes.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Transaksi> mTransaksiList;

    public MyAdapter(List<Transaksi> transaksiList){ mTransaksiList = transaksiList; }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        MyViewHolder mViewHolder = new MyViewHolder(mView);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.mTextViewIdTrans.setText("Id Pembelian :  " + mTransaksiList.get(position)
                .getId_trans());
        holder.mTextViewIdUser.setText("Id User :  " + mTransaksiList.get(position)
                .getId_user());
        holder.mTextViewIdNovel.setText("Id Lagu :  " + mTransaksiList.get(position)
                .getId_novel());
        holder.mTextViewTanggal.setText("Tanggal Beli :  " + String.valueOf(mTransaksiList.get
                (position).getTanggal_beli()));
        holder.mTextViewHarga.setText("Total Harga :  " + mTransaksiList.get(position)
                .getHarga());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(view.getContext(), LayarDetailTransaksi.class);
                mIntent.putExtra("id_trans",mTransaksiList.get(position).getId_trans());
                mIntent.putExtra("id_user",mTransaksiList.get(position).getId_user());
                mIntent.putExtra("id_novel",mTransaksiList.get(position).getId_novel());
                mIntent.putExtra("tanggal_beli",mTransaksiList.get(position).getTanggal_beli());
                mIntent.putExtra("harga",String.valueOf(mTransaksiList.get(position).getHarga()));
                view.getContext().startActivity(mIntent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mTransaksiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewIdTrans, mTextViewIdUser, mTextViewTanggal,mTextViewIdNovel,mTextViewHarga;
        public MyViewHolder(View itemView) {
            super(itemView);
            mTextViewIdTrans = (TextView) itemView.findViewById(R.id.tvIdTrans);
            mTextViewIdUser = (TextView) itemView.findViewById(R.id.tvIdUser);
            mTextViewIdNovel = (TextView) itemView.findViewById(R.id.tvIdNovel);
            mTextViewTanggal = (TextView) itemView.findViewById(R.id.tvTanggal);
            mTextViewHarga = (TextView) itemView.findViewById(R.id.tvIdHarga);
        }
    }
}
