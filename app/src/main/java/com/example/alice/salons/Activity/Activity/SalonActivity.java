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

import com.example.alice.salons.Activity.Adapter.SalonAdapter;
import com.example.alice.salons.Activity.Deco.RecyclerTouchListener;
import com.example.alice.salons.Activity.Other.Salon;
import com.example.alice.salons.Activity.R;

import java.util.ArrayList;
import java.util.List;

public class SalonActivity extends AppCompatActivity {

    private List<Salon> salonList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SalonAdapter mAdapter;
    FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new SalonAdapter(salonList);
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

                startActivity(new Intent(SalonActivity.this,SalonRecyclerActivity.class));

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));


        fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SalonActivity.this,SalonAgentActivity.class));
            }
        });


        prepareSalonData();

        /*try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void prepareSalonData() {

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


        Salon salon = new Salon("Lorem Ipsum", "Alkaline Perm ", "2015",covers[0]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Acupressure", "2015",covers[1]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Carbon Dioxide Laser ", "2015",covers[2]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Animation", "2015",covers[3]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Science Fiction & Fantasy", "2015",covers[4]);
        salonList.add(salon);

        salon = new Salon("MLorem Ipsum", "Cushing Syndrome", "2015",covers[5]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Cushing Syndrome", "2009",covers[6]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Chemical Depilatories", "2009",covers[7]);
        salonList.add(salon);

        salon = new Salon("The Lorem Ipsum", "Animation", "2014",covers[8]);
        salonList.add(salon);

        salon = new Salon("Lorem Ipsum", "Couture Cut ", "2008",covers[9]);
        salonList.add(salon);

        mAdapter.notifyDataSetChanged();
    }

}
