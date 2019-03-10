package com.example.android.projectname;

import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Spinner;
        import android.widget.Toast;

import java.util.regex.Pattern;

public class CompanyRegistrationForm extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_registration_form);


        Button StartButton = (Button) findViewById(R.id.CompanySubmit);

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText companyname = (EditText) findViewById(R.id.companyname);
                EditText email = (EditText) findViewById(R.id.EmailInput);

                if(!validate()){



                    companyname.setError( "Company Name is required!" );
                    email.setError( "Email is not valid!" );


                }else{
                    Intent i = new Intent(getApplicationContext(), ComapnyRegistrationFormSubmit.class);
                    startActivity(i);
                }
                //startActivity(new Intent(MainActivity.this, Submit.class));
            }
        });


        Spinner spinner1 = findViewById(R.id.LocationSpinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.numbers2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        Spinner spinner2 = findViewById(R.id.LocationSpinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.numbers2, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener(this);

        Spinner spinner3 = findViewById(R.id.LocationSpinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.numbers2, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(this);
    }

    private boolean isEmailValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    private Boolean validate(){
        Boolean result = false;

        EditText companyname = (EditText) findViewById(R.id.companyname);
        EditText email = (EditText) findViewById(R.id.EmailInput);


//        if(name.isEmpty() || password.isEmpty() || email.isEmpty() || age.isEmpty() || imagePath == null){
        if(companyname.getText().toString().isEmpty() || !isEmailValid(email.getText().toString())){
            Toast.makeText(this, "Please enter all the details correctly", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
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
