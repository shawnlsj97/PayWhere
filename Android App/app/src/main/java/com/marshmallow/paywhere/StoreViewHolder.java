package com.marshmallow.paywhere;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * StoreViewHolder extends RecyclerView.ViewHolder.This is the class that adds details for each
 * individual food and beverage outlet.
 */
public class StoreViewHolder extends RecyclerView.ViewHolder {

    /**
     * Variable containing view that consists of layout of store details.
     */
    View view;

    /**
     * Constructor for StoreViewHolder.
     * @param itemView View consisting of layout of store details.
     */
    public StoreViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
    }

    /**
     * Sets the details of each store.
     * @param name Store name.
     * @param address Store address.
     * @param payment Mobile payment options available at the store.
     */
    public void setDetails(String name, String address, String payment, String image,
                           Context context) {
        CircleImageView storeImage = view.findViewById(R.id.storeImage);
        TextView storeName = view.findViewById(R.id.storeName);
        TextView storeAddress = view.findViewById(R.id.storeAddress);
        ImageView storePayment1 = view.findViewById(R.id.storePayment1);
        ImageView storePayment2 = view.findViewById(R.id.storePayment2);
        ImageView storePayment3 = view.findViewById(R.id.storePayment3);

        storeName.setText(name);
        storeAddress.setText(address);

        // initialise imageviews for mobile payment options (3 cases)
        String[] platforms = payment.split(",");
        int count = platforms.length;
        switch(count) {
            case 1:
                storePayment1.setVisibility(View.VISIBLE);
                storePayment2.setVisibility(View.GONE);
                storePayment3.setVisibility(View.GONE);

                if (payment.contains("Dash")) {
                    storePayment1.setImageResource(R.drawable.singteldash);
                } else if (payment.contains("GrabPay")) {
                    storePayment1.setImageResource(R.drawable.grabpay);
                } else if (payment.contains("NetsQR")) {
                    storePayment1.setImageResource(R.drawable.netsqr);
                } else {
                    // array contains empty string
                    storePayment1.setVisibility(View.GONE);
                }
                break;

            case 2:
                storePayment1.setVisibility(View.VISIBLE);
                storePayment2.setVisibility(View.VISIBLE);
                storePayment3.setVisibility(View.GONE);

                if (payment.contains("Dash")) {
                    storePayment1.setImageResource(R.drawable.singteldash);
                    if (payment.contains("GrabPay")) {
                        storePayment2.setImageResource(R.drawable.grabpay);
                    } else {
                        storePayment2.setImageResource(R.drawable.netsqr);
                    }
                } else {
                    storePayment1.setImageResource(R.drawable.grabpay);
                    storePayment2.setImageResource(R.drawable.netsqr);
                }
                break;

            case 3:
                storePayment1.setVisibility(View.VISIBLE);
                storePayment2.setVisibility(View.VISIBLE);
                storePayment3.setVisibility(View.VISIBLE);
                break;
        }

        // load image from url into circular image view using glide
        Glide.with(context)
                .asBitmap()
                .load(image)
                .into(storeImage);
    }
}