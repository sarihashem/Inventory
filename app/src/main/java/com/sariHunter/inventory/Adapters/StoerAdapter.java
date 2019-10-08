package com.sariHunter.inventory.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sariHunter.inventory.Classes.Store;
import com.sariHunter.inventory.R;
import com.sariHunter.inventory.StoreDetails;

import java.util.List;

public class StoerAdapter extends RecyclerView.Adapter<StoerAdapter.StoreViewHolder> {

    List<Store> stores ;
    Context c;

    public StoerAdapter(List<Store> stores, Context c) {
        this.stores = stores;
        this.c = c;
    }

    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new StoreViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.store_veiw,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int i) {

        Store store = stores.get(i);

        holder.storeName.setText(store.getName());
        holder.totalValue.setText(String.valueOf(store.getValue()));
        //holder.img.setImageBitmap(new Bitmap().);
        //TODO: set circular image for store from url;
        holder.details.setOnClickListener((v -> {

            // go to store Details and show every detail about store;
            Intent intent = new Intent(c, StoreDetails.class);
            intent.putExtra("storeID", store.getId());

            c.startActivity(intent);

        }));




    }

    @Override
    public int getItemCount() {
        return 0;
    }


    static class StoreViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        ImageButton details;
        TextView storeName,date,totalValue;



        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.storeImg);
            details = itemView.findViewById(R.id.showDetails);
            storeName = itemView.findViewById(R.id.store_name);
            totalValue = itemView.findViewById(R.id.value);
            date = itemView.findViewById(R.id.dateCreated);
        }
    }

}

