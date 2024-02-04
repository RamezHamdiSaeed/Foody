package com.example.foody.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foody.R;

public class SignIn extends AppCompatActivity {
    private EditText email,password;
    private ImageView googleSignIn;
    private Button signIn;
    private TextView switchAuth,guestNavigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        googleSignIn=findViewById(R.id.googleSignIn);
        signIn=findViewById(R.id.signInbtn);
        switchAuth=findViewById(R.id.switchAuth);
        guestNavigator=findViewById(R.id.guestNavigator);
        switchAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });


    }
}