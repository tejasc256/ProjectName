package com.example.android.projectname;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.regex.Pattern;

public class Feedback extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);





        Button mButton = (Button) findViewById(R.id.feedback);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText name = (EditText) findViewById(R.id.editText);
                String names = name.getText().toString();
                EditText email = (EditText) findViewById(R.id.editText2);
                String emails = email.getText().toString();
                EditText feed = (EditText) findViewById(R.id.editText3);
                String feeds = feed.getText().toString();

                if(names.isEmpty()){
                    name.setError("Enter a name");
                }
                else{
                    if(isEmailValid(emails)){
                        if(feeds.isEmpty()){
                            feed.setError("Enter your feedback");
                        }
                        else{
                            startActivity(new Intent(Feedback.this, Certificate.class));
                        }
                    }
                    else{
                        email.setError("Enter Valid E mail");
                    }

                }

            }
        });
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


};

