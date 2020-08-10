package com.liminal.project32;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class Adapter2 extends RecyclerView.Adapter<Adapter2.ViewHolder> {

    private List<String> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Context c;

    public boolean vertical;


    // data is passed into the constructor
    Adapter2(Context context, List<String> data, boolean v) {
        vertical = v;
        c = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view;

        if(vertical) {
            view = mInflater.inflate(R.layout.vertical_item, parent, false);
        }else{
            view = mInflater.inflate(R.layout.horizontal_item, parent, false);
        }

        return new ViewHolder(view);

    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String animal = mData.get(position);
        holder.myTextView.setText(animal);

        if(PickCuisinesDialog.selected.contains(animal)){
            holder.myTextView.setTextColor(c.getResources().getColor(R.color.green));
        }

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView myTextView;

        ViewHolder(View itemView) {

            super(itemView);
            myTextView = itemView.findViewById(R.id.listItem);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(myTextView, getAdapterPosition());
        }

    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(TextView view, int position);
    }

}