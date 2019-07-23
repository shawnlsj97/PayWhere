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
        ImageView storePayment4 = view.findViewById(R.id.storePayment4);
        ImageView storePayment5 = view.findViewById(R.id.storePayment5);
        ImageView storePayment6 = view.findViewById(R.id.storePayment6);

        storeName.setText(name);
        storeAddress.setText(address);

        // initialise imageviews for mobile payment options (3 cases)
        String[] platforms = payment.split(",");
        int count = platforms.length;
        switch(count) {
            case 1:
                storePayment1.setVisibility(View.VISIBLE);
                storePayment2.setVisibility(View.INVISIBLE);
                storePayment3.setVisibility(View.INVISIBLE);
                storePayment4.setVisibility(View.INVISIBLE);
                storePayment5.setVisibility(View.INVISIBLE);
                storePayment6.setVisibility(View.INVISIBLE);

                if (payment.contains("Dash")) {
                    storePayment1.setImageResource(R.drawable.dash_circle);
                } else if (payment.contains("GrabPay")) {
                    storePayment1.setImageResource(R.drawable.grabpay_circle);
                } else if (payment.contains("NetsQR")) {
                    storePayment2.setVisibility(View.VISIBLE);
                    storePayment3.setVisibility(View.VISIBLE);
                    storePayment4.setVisibility(View.VISIBLE);

                    storePayment1.setImageResource(R.drawable.uob_circle);
                    storePayment2.setImageResource(R.drawable.ocbc_circle);
                    storePayment3.setImageResource(R.drawable.paylah_circle);
                    storePayment4.setImageResource(R.drawable.netspay_circle);
                } else {
                    // array contains empty string
                    storePayment1.setVisibility(View.INVISIBLE);
                }
                break;

            case 2:
                storePayment1.setVisibility(View.VISIBLE);
                storePayment2.setVisibility(View.VISIBLE);
                storePayment3.setVisibility(View.INVISIBLE);
                storePayment4.setVisibility(View.INVISIBLE);
                storePayment5.setVisibility(View.INVISIBLE);
                storePayment6.setVisibility(View.INVISIBLE);

                if (payment.contains("Dash")) {
                    storePayment2.setImageResource(R.drawable.dash_circle);
                    if (payment.contains("GrabPay")) {
                        storePayment1.setImageResource(R.drawable.grabpay_circle);
                    } else {
                        storePayment3.setVisibility(View.VISIBLE);
                        storePayment4.setVisibility(View.VISIBLE);
                        storePayment5.setVisibility(View.VISIBLE);

                        storePayment1.setImageResource(R.drawable.uob_circle);
                        storePayment2.setImageResource(R.drawable.ocbc_circle);
                        storePayment3.setImageResource(R.drawable.paylah_circle);
                        storePayment4.setImageResource(R.drawable.netspay_circle);
                        storePayment5.setImageResource(R.drawable.dash_circle);
                    }
                } else {
                    storePayment3.setVisibility(View.VISIBLE);
                    storePayment4.setVisibility(View.VISIBLE);
                    storePayment5.setVisibility(View.VISIBLE);

                    storePayment1.setImageResource(R.drawable.uob_circle);
                    storePayment2.setImageResource(R.drawable.ocbc_circle);
                    storePayment3.setImageResource(R.drawable.paylah_circle);
                    storePayment4.setImageResource(R.drawable.netspay_circle);
                    storePayment5.setImageResource(R.drawable.grabpay_circle);
                }
                break;

            case 3:
                storePayment1.setVisibility(View.VISIBLE);
                storePayment2.setVisibility(View.VISIBLE);
                storePayment3.setVisibility(View.VISIBLE);
                storePayment4.setVisibility(View.VISIBLE);
                storePayment5.setVisibility(View.VISIBLE);
                storePayment6.setVisibility(View.VISIBLE);
                break;
        }

        // load image from url into circular image view using glide
        Glide.with(context)
                .asBitmap()
                .load(image)
                .into(storeImage);
    }
}