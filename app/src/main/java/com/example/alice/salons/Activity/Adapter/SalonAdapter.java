package com.example.alice.salons.Activity.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alice.salons.Activity.Other.Salon;
import com.example.alice.salons.Activity.R;

import java.util.List;

public class SalonAdapter extends RecyclerView.Adapter<SalonAdapter.MyViewHolder> {

    private List<Salon> salonList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, year, genre;
        public ImageView thumbnail;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public SalonAdapter(List<Salon> salonList) {
        this.salonList = salonList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.salon_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Salon salon = salonList.get(position);
        holder.title.setText(salon.getTitle());
        holder.genre.setText(salon.getGenre());
        holder.year.setText(salon.getYear());

     //  Glide.with(mContext).load(salon.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return salonList.size();
    }

}


