package com.marshmallow.paywhere;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SearchResults extends AppCompatActivity {

    private Toolbar toolBar;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private FirebaseDatabase db;
    private FirebaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        toolBar = findViewById(R.id.successToolbar);
        setSupportActionBar(toolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(searchActivity);
                finish();
            }
        });

        searchView = findViewById(R.id.successSearchView);
        Bundle bundle = getIntent().getExtras();
        String input = bundle.getString("input");
        searchView.setQuery(input, false);
        searchView.clearFocus();

        db = FirebaseDatabase.getInstance();

        recyclerView = findViewById(R.id.successRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        firebaseSearch(input);

    }

    public static class StoreViewHolder extends RecyclerView.ViewHolder {

        View view;

        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public void setDetails(String name, String address, String payment) {
            TextView storeName = view.findViewById(R.id.storeName);
            TextView storeAddress = view.findViewById(R.id.storeAddress);
            ImageView storePayment = view.findViewById(R.id.storePayment);

            storeName.setText(name);
            storeAddress.setText(address);
            if (payment.contains("Dash")) {
                storePayment.setVisibility(View.VISIBLE);
            } else {
                storePayment.setVisibility(View.GONE);
            }
        }
    }

    private void firebaseSearch(final String input) {
        final Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child(input);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    FirebaseRecyclerOptions<Store> options = new FirebaseRecyclerOptions.Builder<Store>()
                            .setQuery(query, new SnapshotParser<Store>() {
                                @NonNull
                                @Override
                                public Store parseSnapshot(@NonNull DataSnapshot snapshot) {
                                    return new Store(snapshot.child("name").getValue().toString(),
                                            snapshot.child("payment").getValue().toString(),
                                            snapshot.child("address").getValue().toString());
                                }
                            })
                            .build();
                    adapter = new FirebaseRecyclerAdapter<Store, StoreViewHolder>(options) {
                        @Override
                        protected void onBindViewHolder(@NonNull StoreViewHolder viewHolder, int i, @NonNull Store s) {
                            viewHolder.setDetails(s.getName(), s.getAddress(), s.getPayment());
                        }

                        @NonNull
                        @Override
                        public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                            View view = LayoutInflater.from(parent.getContext())
                                    .inflate(R.layout.recycler_item_layout, parent, false);
                            return new StoreViewHolder(view);
                        }
                    };
                    adapter.startListening();
                    recyclerView.setAdapter(adapter);
                } else {
                    Intent errorIntent = new Intent(getApplicationContext(), ErrorResults.class);
                    errorIntent.putExtra("input", input);
                    startActivity(errorIntent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                throw databaseError.toException();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (adapter != null) adapter.stopListening();
    }
}
