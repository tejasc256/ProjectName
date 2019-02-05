package com.example.android.projectname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        Button resetpass = (Button) findViewById(R.id.button_forgot_password);
        final String toastString = "Password reset link sent\nCheck your inbox";
        final String toastStringInvalid = "Please enter correct email address";
        final EditText emailaddress = (EditText) findViewById(R.id.editText_forgotpassword);

        resetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = emailaddress.getText().toString();
                if(isEmailValid(email)){
                    Toast.makeText(getApplicationContext(), toastString, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(ForgotPassword.this, Login.class);
                    startActivity(i);
                }
                else{
                    emailaddress.setError("Please enter a valid email");
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
}
