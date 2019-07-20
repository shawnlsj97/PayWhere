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

/**
 * Adapter for our recyclerview on the search results page. Binds data to the layout as specified
 * in R.layout.recycler_item_layout.xml.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<StoreViewHolder> {
    /**
     * List of all stores in the particular mall.
     */
    ArrayList<Store> stores;

    /**
     * Constructor that creates instance of RecyclerAdapter class and assigns it a list of stores
     * to display.
     * @param stores List of stores in a particular mall based on user search query.
     */
    public RecyclerAdapter(ArrayList<Store> stores) {
        this.stores = stores;
    }

    /**
     * Creates viewholder that contains store details.
     * @param parent View that contains the recyclerview.
     * @param viewType To specify multiple types of views to be used (but we do not need it here).
     * @return
     */
    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item_layout, parent, false);
        return new StoreViewHolder(view);
    }

    /**
     * Binds data to the StoreViewHolder based on position in the list.
     * @param viewHolder From R.layout.recycler_item_layout.xml.
     * @param position Postiion in the list of stores.
     */
    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder viewHolder, int position) {
        viewHolder.setDetails(stores.get(position).getName(), stores.get(position).getAddress(), stores.get(position).getPayment());
    }

    /**
     * Get total number of stores.
     * @return Integer representing total number of stores.
     */
    @Override
    public int getItemCount() {
        return stores.size();
    }
}
