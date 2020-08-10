package com.liminal.project32;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class EditMenu extends AppCompatActivity implements Adapter.ItemClickListener {

    Adapter adapter;

    static public ArrayList<String> selected = new ArrayList<String>();
    ArrayList<String> offeredCuisines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);

        offeredCuisines = new ArrayList<>();

        offeredCuisines.add(getResources().getString(R.string.grill));
        offeredCuisines.add(getResources().getString(R.string.chicken));
        offeredCuisines.add(getResources().getString(R.string.chinese));
        offeredCuisines.add(getResources().getString(R.string.icecream));
        offeredCuisines.add(getResources().getString(R.string.freshJuices));
        offeredCuisines.add(getResources().getString(R.string.smoothies));
        offeredCuisines.add(getResources().getString(R.string.fasting));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.hlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        DividerItemDecoration itemDecor = new DividerItemDecoration(this, 0);
        itemDecor.setDrawable(this.getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(itemDecor);

        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);

        adapter = new Adapter(this, offeredCuisines, false);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);


        offeredCuisines = new ArrayList<>();

        offeredCuisines.add("• Fresh Fish");
        offeredCuisines.add("• Hot sauce dipped clams");
        offeredCuisines.add("• Octopus with lemon");
        offeredCuisines.add("• Fried squid rings");
        offeredCuisines.add("• French fries");
        offeredCuisines.add("• Haddock in the stove");


        // set up the RecyclerView
        RecyclerView recyclerView2 = findViewById(R.id.vlist);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration itemDecor2 = new DividerItemDecoration(this, 1);
        itemDecor2.setDrawable(this.getDrawable(R.drawable.divider));
        recyclerView2.addItemDecoration(itemDecor2);

        recyclerView2.getRecycledViewPool().setMaxRecycledViews(0, 0);

        adapter = new Adapter(this, offeredCuisines, true);
        adapter.setClickListener(this);
        recyclerView2.setAdapter(adapter);

    }

    public void onItemClick(TextView view, int position) {

    }

    public void editCuisines(View view){
        FragmentManager fm = getSupportFragmentManager();
        PickCuisinesDialog pickCuisinesDialog = PickCuisinesDialog.newInstance("Some Title");
        pickCuisinesDialog.show(fm, "pick_cuisines_dialog");
    }

    public void editProduct(View view){
        Intent intent = new Intent(this, EditProduct.class);
        startActivity(intent);
    }

}