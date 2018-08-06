package com.example.alice.salons.Activity.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alice.salons.Activity.Other.Barber;
import com.example.alice.salons.Activity.R;

import java.util.List;


public class BarberAdapter extends RecyclerView.Adapter<BarberAdapter.MyViewHolder> {

    private List<Barber> barberList;

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

    public BarberAdapter(List<Barber> barberList) {
        this.barberList = barberList;
    }

    @Override
    public BarberAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.salon_list_row, parent, false);

        return new BarberAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BarberAdapter.MyViewHolder holder, int position) {
        Barber barber = barberList.get(position);
        holder.title.setText(barber.getTitle());
        holder.genre.setText(barber.getGenre());
        holder.year.setText(barber.getYear());

        //  Glide.with(mContext).load(salon.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return barberList.size();
    }

}
