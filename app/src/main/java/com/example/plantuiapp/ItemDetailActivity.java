package com.example.plantuiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;

import com.example.plantuiapp.adapter.ItemDetailAdapter;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;

import java.util.ArrayList;
import java.util.List;

public class ItemDetailActivity extends AppCompatActivity {

    ImageButton backbtn;
    List<Integer> imgList = new ArrayList<>();
    ViewPager viewPager;
    WormDotsIndicator dotsIndicator;
    ItemDetailAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusbar();
        setContentView(R.layout.activity_item_detail);

        backbtn = findViewById(R.id.back_button);
        viewPager = findViewById(R.id.view_pager);
        dotsIndicator = findViewById(R.id.dots_layout);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        imgList.add(R.drawable.detail_home_picture);
        imgList.add(R.drawable.detail_home_picture);
        imgList.add(R.drawable.detail_home_picture);
        imgList.add(R.drawable.detail_home_picture);

        adapter = new ItemDetailAdapter(getApplicationContext(),imgList,getLayoutInflater());
        viewPager.setAdapter(adapter);
        dotsIndicator.setViewPager(viewPager);
        adapter.notifyDataSetChanged();
    }

    private void hideStatusbar() {
        if(Build.VERSION.SDK_INT>=19){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().getDecorView().setSystemUiVisibility(3328);
        }
        else{
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        }
    }
