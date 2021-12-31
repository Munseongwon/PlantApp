package com.example.plantuiapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.plantuiapp.R;

import java.util.List;

public class ItemDetailAdapter extends PagerAdapter {
    Context context;
    List<Integer> imgList;
    ImageView imageView;
    LayoutInflater inflater;

    public ItemDetailAdapter(Context context, List<Integer> imgList, LayoutInflater inflater) {
        this.context = context;
        this.imgList = imgList;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return imgList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_image, container,false);

        imageView = view.findViewById(R.id.slide_img);
        Integer images = imgList.get(position);
        imageView.setBackgroundResource(images);
        container.addView(view);
         return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public int getItemPosition(@NonNull Object object){
        return super.getItemPosition(object);
    }
}
