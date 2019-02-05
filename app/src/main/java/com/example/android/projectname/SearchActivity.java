package com.example.android.projectname;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.IpSecManager;
import android.net.http.SslCertificate;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button searchbutton = (Button) findViewById(R.id.button_search);
        searchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchitem = (EditText) findViewById(R.id.editText_search);
                String searchstring = searchitem.getText().toString();

                if(searchstring.isEmpty()){
                    searchitem.setError("Enter search term");
                }
                else {
                    Intent intent = new Intent(SearchActivity.this, SearchResults.class);
                    intent.putExtra("searchstring", searchstring);
                    startActivity(intent);
                }
            }
        });


//        Spinner searchspinner = (Spinner) findViewById(R.id.spinner_search);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.advanced_search_options, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        searchspinner.setAdapter(adapter);
//        searchspinner.setOnItemSelectedListener(this);

    }

//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//        if(position == 1){
//            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchActivity.this);
//            View rview = getLayoutInflater().inflate(R.layout.andvanced_search_dialog_2, null);
//            rBuilder.setTitle("Select Region");
//            final Spinner rspinner = (Spinner) rview.findViewById(R.id.spinner_region);
//            ArrayAdapter<String> radapter = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_spinner_item,
//                    getResources().getStringArray(R.array.region_options));
//            radapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            rspinner.setAdapter(radapter);
//            rBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if(rspinner.getSelectedItem().toString().isEmpty()){
//                        String toastStringregionnegative = "Please select a region";
//                        Toast.makeText(getApplicationContext(), toastStringregionnegative, Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Intent i = new Intent(SearchActivity.this, SearchResults.class);
//                        i.putExtra("searchstring", rspinner.getSelectedItem().toString());
//                        startActivity(i);
//                    }
//                }
//            });
//
//            rBuilder.setView(rview);
//            AlertDialog rDialog = rBuilder.create();
//            rDialog.show();
//
//        }
//
//        else if(position == 2){
//
//            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchActivity.this);
//            View rview = getLayoutInflater().inflate(R.layout.andvanced_search_dialog_2, null);
//            rBuilder.setTitle("Select Branch");
//            final Spinner rspinner = (Spinner) rview.findViewById(R.id.spinner_region);
//            ArrayAdapter<String> radapter = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_spinner_item,
//                    getResources().getStringArray(R.array.branch_options));
//            radapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            rspinner.setAdapter(radapter);
//            rBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if(rspinner.getSelectedItem().toString().isEmpty()){
//                        String toastStringregionnegative = "Please select a region";
//                        Toast.makeText(getApplicationContext(), toastStringregionnegative, Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Intent i = new Intent(SearchActivity.this, SearchResults.class);
//                        i.putExtra("searchstring", rspinner.getSelectedItem().toString());
//                        startActivity(i);
//                    }
//                }
//            });
//
//            rBuilder.setView(rview);
//            AlertDialog rDialog = rBuilder.create();
//            rDialog.show();
//
//        }
//
//        else if(position == 3){
//
//            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchActivity.this);
//            View rview = getLayoutInflater().inflate(R.layout.advanced_search_dialog_1, null);
//            final EditText editTextsalary = (EditText) rview.findViewById(R.id.adv_salary);
//
//            rBuilder.setTitle("Enter Expected Salary")
//                    .setPositiveButton("Search", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            if(editTextsalary.getText().toString().isEmpty()){
//                                editTextsalary.setError("Enter a valid number");
//                            }
//                            else{
//                                Intent i = new Intent(SearchActivity.this, SearchResults.class);
//                                i.putExtra("searchstring", editTextsalary.getText().toString());
//                                startActivity(i);
//                            }
//                        }
//                    });
//                            rBuilder.setView(rview);
//                            AlertDialog rDialog = rBuilder.create();
//                            rDialog.show();
//
//        }
//
//        else if(position == 4){
//
//            AlertDialog.Builder rBuilder = new AlertDialog.Builder(SearchActivity.this);
//            View rview = getLayoutInflater().inflate(R.layout.andvanced_search_dialog_2, null);
//            rBuilder.setTitle("Select Experience");
//            final Spinner rspinner = (Spinner) rview.findViewById(R.id.spinner_region);
//            ArrayAdapter<String> radapter = new ArrayAdapter<String>(SearchActivity.this, android.R.layout.simple_spinner_item,
//                    getResources().getStringArray(R.array.experience_options));
//            radapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//            rspinner.setAdapter(radapter);
//            rBuilder.setPositiveButton("Search", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    if(rspinner.getSelectedItem().toString().isEmpty()){
//                        String toastStringregionnegative = "Please select an option";
//                        Toast.makeText(getApplicationContext(), toastStringregionnegative, Toast.LENGTH_SHORT).show();
//                    }
//                    else{
//                        Intent i = new Intent(SearchActivity.this, SearchResults.class);
//                        i.putExtra("searchstring", rspinner.getSelectedItem().toString());
//                        startActivity(i);
//                    }
//                }
//            });
//
//            rBuilder.setView(rview);
//            AlertDialog rDialog = rBuilder.create();
//            rDialog.show();
//        }
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }
}
