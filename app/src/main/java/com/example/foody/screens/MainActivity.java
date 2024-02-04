package com.example.foody.screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.foody.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseUser user;
    private Button logOut;

    private TextView userMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth=FirebaseAuth.getInstance();
        logOut=findViewById(R.id.logoutBtn);
        userMail=findViewById(R.id.userMail);
        user= auth.getCurrentUser();
        if(user==null){
            Intent intent = new Intent(MainActivity.this, SignIn.class);
            startActivity(intent);
        }
        else{
            userMail.setText(user.getEmail());
        }
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MainActivity.this, SignIn.class);
                startActivity(intent);

            }
        });
    }
}