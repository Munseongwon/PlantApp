package com.example.plantuiapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantuiapp.ItemDetailActivity;
import com.example.plantuiapp.R;
import com.example.plantuiapp.model.Plant;

import java.util.List;

public class FeaturedPlantAdapter extends RecyclerView.Adapter<FeaturedPlantAdapter.ViewHolder> {

    private Context context;
    private List<Plant> featuredList;

    public FeaturedPlantAdapter(Context context, List<Plant> featuredList) {
        this.context = context;
        this.featuredList = featuredList;
    }

    @NonNull
    @Override
    public FeaturedPlantAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.featured_plant_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedPlantAdapter.ViewHolder holder, int position) {
        holder.plantImage.setImageResource(featuredList.get(position).getPlantImage());
        holder.plantName.setText(featuredList.get(position).getPlantName());
        holder.plantName.setText(featuredList.get(position).getPlantPrice());
        holder.plantName.setText(featuredList.get(position).getPlantName());
    }

    @Override
    public int getItemCount() {
        return featuredList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private ImageView plantImage;
        private TextView plantName,plantPrice,plantCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            plantImage = itemView.findViewById(R.id.featured_item_plant_picture);
            plantName = itemView.findViewById(R.id.featured_item_plant_title);
            plantPrice = itemView.findViewById(R.id.featured_item_plant_price);
            plantCountry = itemView.findViewById(R.id.featured_item_plant_country);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, ItemDetailActivity.class));
                }
            });




        }
    }
}
