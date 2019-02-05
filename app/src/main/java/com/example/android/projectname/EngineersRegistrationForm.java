package com.example.android.projectname;

import android.app.DatePickerDialog;
        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.Calendar;
        import java.util.regex.Pattern;

public class EngineersRegistrationForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_engineers_registration_form);

        final Button StartButton = findViewById(R.id.SubmitButton);

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText name = findViewById(R.id.NameInput);
                EditText experience = findViewById(R.id.JobExperienceInput);
                EditText contact = findViewById(R.id.ContactInput);

                if(name.getText().toString().isEmpty() && contact.getText().toString().isEmpty() && experience.getText().toString().isEmpty() && isValidMobile(contact.getText().toString())){

                    if(name.getText().toString().isEmpty())
                    {
                        name.setError( "First name is required!" );
                    }

                    if(contact.getText().toString().isEmpty())
                    {
                        contact.setError( "Contact is required!" );
                    }

                    if(experience.getText().toString().isEmpty())
                    {
                        experience.setError( "Contact is required!" );

                    }

                    if(isValidMobile(contact.getText().toString()))
                    {
                        contact.setError("Invalid Contact");
                    }
                }else{
                    Intent i = new Intent(getApplicationContext(), Dashboard.class);
                    startActivity(i);
                }
            }
        });


        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Spinner spinnercity = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adaptercity = ArrayAdapter.createFromResource(this, R.array.numbers2, android.R.layout.simple_spinner_item);
        adaptercity.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercity.setAdapter(adaptercity);
        spinnercity.setOnItemSelectedListener(this);

        Spinner spinnerbranch = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapterbranch = ArrayAdapter.createFromResource(this, R.array.numbers3, android.R.layout.simple_spinner_item);
        adapterbranch.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerbranch.setAdapter(adapterbranch);
        spinnerbranch.setOnItemSelectedListener(this);

        mDisplayDate = findViewById(R.id.tvDate);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        EngineersRegistrationForm.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
            }
        };

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private boolean isValidMobile(String phone) {
        boolean check;
        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            if(phone.length() != 10) {
                // if(phone.length() != 10) {
                check = false;
                //contact.setError("Not Valid Number");
            } else {
                check = true;
            }
        } else {
            check=false;
        }
        return !check;
    }

}