package com.example.android.projectname;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RatingBar;
        import android.widget.Spinner;
        import android.widget.Toast;

public class TrainerReviewRating extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_review_rating);

        Spinner spinner = findViewById(R.id.ReviewSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button StartButton = (Button) findViewById(R.id.ReviewSubmit);

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText review = (EditText) findViewById(R.id.review);
                RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
                if(review.getText().toString().isEmpty()){

                    review.setError( "Review is required!" );

                }else{
                    Intent i = new Intent(getApplicationContext(), TrainerReviewRatingSubmit.class);
                    startActivity(i);
                }
                //startActivity(new Intent(MainActivity.this, Submit.class));
            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

