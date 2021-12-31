package com.example.plantuiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.plantuiapp.R;
import com.example.plantuiapp.model.Group;
import com.example.plantuiapp.model.Plant;

import java.util.List;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private Context context;
    private List<Group> groupList;
    private List<Plant> featuredList;
    private List<Plant> recommendList;

    public GroupAdapter(Context context, List<Group> groupList, List<Plant> featuredList, List<Plant> recommendList) {
        this.context = context;
        this.groupList = groupList;
        this.featuredList = featuredList;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.groupTitle.setText(groupList.get(position).getGroupTitle());
        holder.groupButton.setText(groupList.get(position).getGroupButtonTitle());
        holder.setList(holder.recyclerView,position);
    }

    @Override
    public int getItemCount() {
        return groupList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView groupTitle;
        private AppCompatButton groupButton;
        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            groupTitle = itemView.findViewById(R.id.group_title);
            groupButton = itemView.findViewById(R.id.group_button);
            recyclerView = itemView.findViewById(R.id.group_RV);
        }
        public void setList(RecyclerView recyclerView , int position){
            switch(position){
                case 0:
                    setRecommendList(recyclerView);
                    break;
                case 1:
                    setFeaturedList(recyclerView);
                break;
            }
        }
    }

    private void setRecommendList(RecyclerView recyclerView) {
        RecommendPlantAdapter adapter = new RecommendPlantAdapter(context, recommendList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);

    }

    private void setFeaturedList(RecyclerView recyclerView){
        FeaturedPlantAdapter adapter = new FeaturedPlantAdapter(context, featuredList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
        recyclerView.setNestedScrollingEnabled(true);
    }
}
