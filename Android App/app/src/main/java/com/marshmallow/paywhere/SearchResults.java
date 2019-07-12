package com.marshmallow.paywhere;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.core.widget.ContentLoadingProgressBar;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
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

import java.util.Arrays;

public class SearchResults extends AppCompatActivity {

    private Toolbar toolBar;
    private SearchView searchView;
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter adapter;
    private ContentLoadingProgressBar pb;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        pb = findViewById(R.id.progress_bar);
        toolBar = findViewById(R.id.successToolbar);
        setSupportActionBar(toolBar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.stopListening();
                Intent searchActivity = new Intent(getApplicationContext(), SearchActivity.class);
                startActivity(searchActivity);
                finish();
            }
        });

        searchView = findViewById(R.id.successSearchView);
        Bundle bundle = getIntent().getExtras();
        String input = bundle.getString("input");
        searchView.setQuery(toTitleCase(input), false);
        searchView.clearFocus();

        final SearchView.SearchAutoComplete searchAutoComplete = searchView.findViewById(androidx.appcompat.R.id.search_src_text);
        ArrayAdapter suggestionAdapter = new ArrayAdapter(this, R.layout.suggestion_item, R.id.suggestion, getResources().getStringArray(R.array.search_suggestions));
        searchAutoComplete.setAdapter(suggestionAdapter);
        searchAutoComplete.setThreshold(1);
        searchAutoComplete.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) parent.getAdapter().getItem(position);
                searchView.setQuery(item, true);
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String[] validMalls = getResources().getStringArray(R.array.search_suggestions);
                if ((Arrays.asList(validMalls)).contains(toTitleCase(query))) {
                    adapter.stopListening();
                    Intent intent = new Intent(getApplicationContext(), SearchResults.class);
                    intent.putExtra("input", query);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    searchView.clearFocus();
                    return true;
                } else {
                    adapter.stopListening();
                    Intent errorIntent = new Intent(getApplicationContext(), ErrorResults.class);
                    errorIntent.putExtra("input", query);
                    startActivity(errorIntent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    return false;
                }
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        recyclerView = findViewById(R.id.successRecyclerView);
        recyclerView.setVisibility(View.INVISIBLE);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(),
                DividerItemDecoration.VERTICAL));

        firebaseSearch(input.toLowerCase());
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
        // search by mall
        final Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child(input);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
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
                recyclerView.setVisibility(View.VISIBLE);
                pb.setVisibility(View.GONE);
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

    public String toTitleCase(String input) {

        StringBuilder output = new StringBuilder();
        boolean convertNext = true;
        for (char ch : input.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            output.append(ch);
        }

        return output.toString();
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
