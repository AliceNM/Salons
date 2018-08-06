package com.example.alice.salons.Activity.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.alice.salons.Activity.Adapter.BarberAdapter;
import com.example.alice.salons.Activity.Deco.RecyclerTouchListener;
import com.example.alice.salons.Activity.Other.Barber;
import com.example.alice.salons.Activity.R;

import java.util.ArrayList;
import java.util.List;


public class BarberShopActivity extends AppCompatActivity {

    private List<Barber> barberList = new ArrayList<>();
    private RecyclerView recyclerView;
    private BarberAdapter mAdapter;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barber_shop);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new BarberAdapter(barberList);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        // recyclerView.addItemDecoration(new MyDividerItemDecoration(this, LinearLayoutManager.HORIZONTAL, 16));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                startActivity(new Intent(BarberShopActivity.this,BarberRecyclerActivity.class));

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BarberShopActivity.this,BarberAgentActivity.class));
            }
        });

        prepareBarberData();


    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void prepareBarberData() {

        int[] covers = new int[]{
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
                R.mipmap.ic_launcher,
        };


        Barber barber = new Barber("Lorem Ipsum", "Some Text Goes Here ", "2015",covers[0]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here", "2015",covers[1]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here ", "2015",covers[2]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here", "2015",covers[3]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here", "2015",covers[4]);
        barberList.add(barber);

        barber = new Barber("MLorem Ipsum", "Some Text Goes Here", "2015",covers[5]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here", "2009",covers[6]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here", "2009",covers[7]);
        barberList.add(barber);

        barber = new Barber("The Lorem Ipsum", "Some Text Goes Here", "2014",covers[8]);
        barberList.add(barber);

        barber = new Barber("Lorem Ipsum", "Some Text Goes Here", "2008",covers[9]);
        barberList.add(barber);

        mAdapter.notifyDataSetChanged();
    }




}
