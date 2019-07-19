package com.marshmallow.paywhere;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<StoreViewHolder> {

    ArrayList<Store> stores;

    public RecyclerAdapter(ArrayList<Store> stores) {
        this.stores = stores;
    }


    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_layout, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder viewHolder, int position) {
        viewHolder.setDetails(stores.get(position).getName(), stores.get(position).getAddress(), stores.get(position).getPayment());
    }

    @Override
    public int getItemCount() {
        return stores.size();
    }
}
