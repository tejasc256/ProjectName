package com.example.android.projectname;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
//import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResults extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Spinner searchspinner = (Spinner) findViewById(R.id.spinner_search);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.advanced_search_options, R.layout.spinner_layout);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        searchspinner.setAdapter(adapter);

        TextView searchresult = (TextView) findViewById(R.id.textViewSearchResult1);
        Intent i = getIntent();
        String result = i.getStringExtra("searchstring");
        int pos = i.getIntExtra("position", 0);
        searchspinner.setSelection(pos, false);
//        result += pos;
        searchresult.setText(result);

        searchspinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(position == 1){
            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchResults.this);
            Intent prev = getIntent();
            final String prevresult = prev.getStringExtra("searchstring");
            View rview = getLayoutInflater().inflate(R.layout.andvanced_search_dialog_2, null);
            rBuilder.setTitle("Select Region");
            final Spinner rspinner = (Spinner) rview.findViewById(R.id.spinner_region);
            ArrayAdapter<String> radapter = new ArrayAdapter<String>(SearchResults.this, R.layout.spinner_layout,
                    getResources().getStringArray(R.array.region_options));
            radapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
            rspinner.setAdapter(radapter);
            rBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(rspinner.getSelectedItem().toString().isEmpty()){
                        String toastStringregionnegative = "Please select a region";
                        Toast.makeText(getApplicationContext(), toastStringregionnegative, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent i = getIntent();
                        i.putExtra("searchstring", prevresult);
                        i.putExtra("advsearchstring", rspinner.getSelectedItem().toString());
                        i.putExtra("position", 1);
                        startActivity(i);
                    }
                }
            });

            rBuilder.setView(rview);
            AlertDialog rDialog = rBuilder.create();
            rDialog.show();

        }

        else if(position == 2){

            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchResults.this);
            Intent prev = getIntent();
            final String prevresult = prev.getStringExtra("searchstring");
            View rview = getLayoutInflater().inflate(R.layout.advanced_search_dialog_1, null);
            final EditText editTextsalary = (EditText) rview.findViewById(R.id.adv_salary);

            rBuilder.setTitle("Enter Expected Salary")
                    .setPositiveButton("Search", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if(editTextsalary.getText().toString().isEmpty()){
                                editTextsalary.setError("Enter a valid number");
                            }
                            else{
                                Intent i = new Intent(SearchResults.this, SearchResults.class);
                                i.putExtra("searchstring", prevresult);
                                i.putExtra("advsearchstring", editTextsalary.getText().toString());
                                i.putExtra("position", 2);
                                startActivity(i);
                            }
                        }
                    });
            rBuilder.setView(rview);
            AlertDialog rDialog = rBuilder.create();
            rDialog.show();

        }

        else if(position == 3){

            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchResults.this);
            Intent prev = getIntent();
            final String prevresult = prev.getStringExtra("searchstring");
            View rview = getLayoutInflater().inflate(R.layout.andvanced_search_dialog_2, null);
            rBuilder.setTitle("Select Experience");
            final Spinner rspinner = (Spinner) rview.findViewById(R.id.spinner_region);
            ArrayAdapter<String> radapter = new ArrayAdapter<String>(SearchResults.this, R.layout.spinner_layout,
                    getResources().getStringArray(R.array.experience_options));
            radapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            rspinner.setAdapter(radapter);
            rBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(rspinner.getSelectedItem().toString().isEmpty()){
                        String toastStringregionnegative = "Please select an option";
                        Toast.makeText(getApplicationContext(), toastStringregionnegative, Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Intent i = new Intent(SearchResults.this, SearchResults.class);
                        i.putExtra("searchstring", prevresult);
                        i.putExtra("advsearchstring", rspinner.getSelectedItem().toString());
                        i.putExtra("position", 3);
                        startActivity(i);
                    }
                }
            });

            rBuilder.setView(rview);
            AlertDialog rDialog = rBuilder.create();
            rDialog.show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
