package com.example.android.projectname;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.projectname.R;

public class Dashboard extends AppCompatActivity {

    TextView page1,page2;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        page1 = (TextView)findViewById(R.id.page1);
        page2 = (TextView)findViewById(R.id.page2);
        viewPager = (ViewPager)findViewById(R.id.fragment_container);
        pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerViewAdapter);

        page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(0);
            }
        });

        page2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(1);
            }
        });


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onPageSelected(int i) {

                onChangeTab(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

//
//
//        Button btn2 = (Button) findViewById(R.id.JobsButton);
//
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent2 = new Intent(Dashboard.this, SearchActivity.class);
//                startActivity(myIntent2);
//            }
//        });
//
//        Button btn3 = (Button) findViewById(R.id.AboutUsButton);
//
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent3 = new Intent(Dashboard.this, About_Us.class);
//                startActivity(myIntent3);
//            }
//        });
//
//        Button btn4 = (Button) findViewById(R.id.FaqButton);
//
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent4 = new Intent(Dashboard.this, FAQ.class);
//                startActivity(myIntent4);
//            }
//        });
//
//        Button btn5 = (Button) findViewById(R.id.RatingButton);
//
//        btn5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent4 = new Intent(Dashboard.this, TrainerReviewRating.class);
//                startActivity(myIntent4);
//            }
//        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void onChangeTab(int position) {

        if (position == 0)
        {
            page1.setTextSize(25);
            page1.setTextColor(getColor(R.color.bright_color));

            page2.setTextSize(20);
            page2.setTextColor(getColor(R.color.light_color));
        }

        if (position == 1)
        {
            page1.setTextSize(20);
            page1.setTextColor(getColor(R.color.light_color));

            page2.setTextSize(25);
            page2.setTextColor(getColor(R.color.bright_color));
        }
    }
}