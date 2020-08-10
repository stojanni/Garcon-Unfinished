package com.liminal.project32;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class PickCuisinesDialog extends DialogFragment implements Adapter.ItemClickListener {

    Adapter adapter;

    static public ArrayList<String> selected = new ArrayList<String>();
    ArrayList<String> cuisines;


    public PickCuisinesDialog() {
        // Empty constructor is required for DialogFragment
        // Make sure not to add arguments to the constructor
        // Use `newInstance` instead as shown below
    }

    public static PickCuisinesDialog newInstance(String title) {

        PickCuisinesDialog frag = new PickCuisinesDialog();

        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);

        return frag;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return inflater.inflate(R.layout.pick_cuisines_dialog, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        // data to populate the RecyclerView with
        cuisines = new ArrayList<>();

        cuisines.add(getResources().getString(R.string.grill));
        cuisines.add(getResources().getString(R.string.chicken));
        cuisines.add(getResources().getString(R.string.chinese));
        cuisines.add(getResources().getString(R.string.icecream));
        cuisines.add(getResources().getString(R.string.freshJuices));
        cuisines.add(getResources().getString(R.string.smoothies));
        cuisines.add(getResources().getString(R.string.fasting));
        cuisines.add(getResources().getString(R.string.desserts));
        cuisines.add(getResources().getString(R.string.seafood));
        cuisines.add(getResources().getString(R.string.salads));
        cuisines.add(getResources().getString(R.string.waffles));
        cuisines.add(getResources().getString(R.string.crepes));
        cuisines.add(getResources().getString(R.string.vegan));
        cuisines.add(getResources().getString(R.string.italian));
        cuisines.add(getResources().getString(R.string.pasta));
        cuisines.add(getResources().getString(R.string.coffees));
        cuisines.add(getResources().getString(R.string.pizzas));
        cuisines.add(getResources().getString(R.string.burgers));
        cuisines.add(getResources().getString(R.string.cooked));
        cuisines.add(getResources().getString(R.string.eastern));
        cuisines.add(getResources().getString(R.string.falafel));
        cuisines.add(getResources().getString(R.string.bakery));
        cuisines.add(getResources().getString(R.string.mexican));
        cuisines.add(getResources().getString(R.string.appetizers));
        cuisines.add(getResources().getString(R.string.indian));
        cuisines.add(getResources().getString(R.string.beers));
        cuisines.add(getResources().getString(R.string.beverages));
        cuisines.add(getResources().getString(R.string.wines));
        cuisines.add(getResources().getString(R.string.drinks));

        // set up the RecyclerView
        RecyclerView recyclerView = getView().findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration itemDecor = new DividerItemDecoration(getContext(), 1);
        itemDecor.setDrawable(getContext().getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(itemDecor);

        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 0);

        adapter = new Adapter(getContext(), cuisines, true);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "Enter Name");
        getDialog().setTitle(title);

    }

    public void onItemClick(TextView view, int position) {

        String selectedCuisine = adapter.getItem(position);

        if(!selected.contains(view.getText().toString())) {
            view.setTextColor(getResources().getColor(R.color.pink));
            selected.add(selectedCuisine);
        }else{
            view.setTextColor(getResources().getColor(R.color.blue));
            selected.remove(selectedCuisine);
        }

    }

}