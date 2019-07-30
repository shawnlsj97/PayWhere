package com.marshmallow.paywhere;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import static android.content.Context.MODE_PRIVATE;

public class FavouritesAdapter extends RecyclerView.Adapter<MallViewHolder> {

    ArrayList<String> malls;
    Context context;
    Activity activity;

    public FavouritesAdapter(ArrayList<String> malls, Context context, Activity activity) {
        this.malls = malls;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.favourites_item_layout, parent, false);
        return new MallViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MallViewHolder holder, final int position) {
        holder.setDetails(malls.get(position));
        final String name_string = malls.get(position);
        final ToggleButton fav_btn = holder.view.findViewById(R.id.favourites_btn);
        fav_btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Remove mall from favourites
                SharedPreferences pref = context.getSharedPreferences("fav",
                        MODE_PRIVATE);
                Set<String> malls_set = pref.getStringSet("malls", new TreeSet<String>());
                malls_set.remove(toTitleCase(name_string));
                pref.edit().putStringSet("malls", malls_set).apply();
                // Display Toast to inform user
                Toast.makeText(context, "Removed " + toTitleCase(name_string) + " " +
                        "from " +
                        "favourites!", Toast.LENGTH_SHORT).show();
                malls.remove(toTitleCase(name_string));
                notifyDataSetChanged();
                fav_btn.setChecked(true);
            }
        });

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SearchResults.class);
                intent.putExtra("input", name_string);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return malls.size();
    }

    /**
     * Converts input query to title case.
     * @param input Input string from user.
     * @return String that is converted from user input to title case.
     */
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
}
