package com.example.android.projectname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        TextView searchresult = (TextView) findViewById(R.id.textViewSearchResult);
        Intent i = getIntent();
        String result = i.getStringExtra("searchstring");
        searchresult.setText(result);
    }
}
