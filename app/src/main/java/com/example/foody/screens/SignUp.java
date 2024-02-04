package com.example.foody.screens;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foody.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    private EditText email,password,confirmPassword;
    private ImageView googleSignIn;
    private TextView switchAuth;
    private Button signBtn;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        googleSignIn=findViewById(R.id.googleSignIn);
        switchAuth=findViewById(R.id.switchAuth);
        signBtn=findViewById(R.id.signbtn);
        mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);

                String emailString,passwordString;
                emailString=email.getText().toString();
                passwordString=password.getText().toString();
                if(TextUtils.isEmpty(emailString)){
                    Toast.makeText(SignUp.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(passwordString) && (passwordString.equals(confirmPassword))){
                    Toast.makeText(SignUp.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(emailString, passwordString)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(SignUp.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(SignUp.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                switchAuth.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(SignUp.this, SignIn.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }
}