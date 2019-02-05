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


        Button ratingbutton= (Button) findViewById(R.id.RatingButton);

        ratingbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,TrainerReviewRating.class));
            }
        });


        Button EditProfileButton= (Button) findViewById(R.id.EditProfileButton);

        EditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this,EngineersRegistrationForm.class));
            }
        });

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
