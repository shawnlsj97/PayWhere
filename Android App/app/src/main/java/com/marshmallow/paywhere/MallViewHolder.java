package com.marshmallow.paywhere;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MallViewHolder extends RecyclerView.ViewHolder {

    ConstraintLayout parentLayout;
    View view;
    Context context;

    public MallViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        context = itemView.getContext();
        parentLayout = itemView.findViewById(R.id.fav_parent_layout);
    }

    public void setDetails(String name) {
        TextView tv = view.findViewById(R.id.favourites_mallname);
        tv.setText(name);
    }
}
