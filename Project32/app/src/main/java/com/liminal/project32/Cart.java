package com.liminal.project32;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Cart extends AppCompatActivity implements Adapter.ItemClickListener {

    Adapter adapter;
    ArrayList<String> options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        options = new ArrayList<>();

        options.add("• Fresh Fish");
        options.add("• Hot sauce dipped clams");
        options.add("• Octopus with lemon");
        options.add("• Fried squid rings");
        options.add("• French fries");
        options.add("• Haddock in the stove");


        // set up the RecyclerView
        RecyclerView recyclerView2 = findViewById(R.id.list);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecor2 = new DividerItemDecoration(this, 1);
        itemDecor2.setDrawable(this.getDrawable(R.drawable.divider));
        recyclerView2.addItemDecoration(itemDecor2);

        recyclerView2.getRecycledViewPool().setMaxRecycledViews(0, 0);

        adapter = new Adapter(this, options, true);
        adapter.setClickListener(this);
        recyclerView2.setAdapter(adapter);

    }

    public void onItemClick(TextView view, int position) {

    }

}