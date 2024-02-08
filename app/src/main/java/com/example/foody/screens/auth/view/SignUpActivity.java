package com.example.foody.screens.auth.view;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foody.R;
import com.example.foody.dataSources.firebase.UserAuthModel;
import com.example.foody.screens.auth.IContract;
import com.example.foody.screens.auth.model.AuthModel;
import com.example.foody.screens.auth.presenter.SignUpPresenter;
import com.example.foody.screens.main.MainActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignUpActivity extends AppCompatActivity implements IContract.View {
    private IContract.Presenter presenter;
    private EditText email,password,confirmPassword;
    private ImageView googleSignIn;
    private TextView switchAuth;
    private Button signBtn;
    private FirebaseAuth mAuth;
    private GoogleSignInClient googleSignInClient;
    private ProgressBar progressBar;
    private final ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if (result.getResultCode() == RESULT_OK) {
                Task<GoogleSignInAccount> accountTask = GoogleSignIn.getSignedInAccountFromIntent(result.getData());
                try {
                    GoogleSignInAccount signInAccount = accountTask.getResult(ApiException.class);
                    AuthCredential authCredential = GoogleAuthProvider.getCredential(signInAccount.getIdToken(), null);
                    mAuth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                mAuth = FirebaseAuth.getInstance();
                                Toast.makeText(SignUpActivity.this, "Signed in successfully!", Toast.LENGTH_SHORT).show();
                                Intent intentTwoMainActivity = new Intent(SignUpActivity.this, MainActivity.class);
                                startActivity(intentTwoMainActivity);
                                finish();

                            } else {
                                Toast.makeText(SignUpActivity.this, "Failed to sign in: " + task.getException(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter=new SignUpPresenter(this,new AuthModel());
        setContentView(R.layout.activity_sign_up);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        googleSignIn=findViewById(R.id.googleSignIn);
        switchAuth=findViewById(R.id.switchAuth);
        signBtn=findViewById(R.id.signbtn);
       // mAuth = FirebaseAuth.getInstance();
        progressBar=findViewById(R.id.progressBar);
        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                progressBar.setVisibility(View.VISIBLE);
//
//                String emailString,passwordString;
//                emailString=email.getText().toString();
//                passwordString=password.getText().toString();
//                if(TextUtils.isEmpty(emailString)){
//                    Toast.makeText(SignUpActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(passwordString) && (passwordString.equals(confirmPassword))){
//                    Toast.makeText(SignUpActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                    return;
//                }

                presenter.onSignIn_UpClick(new UserAuthModel(email.getText().toString(), password.getText().toString(), confirmPassword.getText().toString()));
//                mAuth.createUserWithEmailAndPassword(emailString, passwordString)
//                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    progressBar.setVisibility(View.GONE);
//                                    Toast.makeText(SignUpActivity.this, "Account Created.",
//                                            Toast.LENGTH_SHORT).show();
//
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });



            }
        });
        switchAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
//                        startActivity(intent);
                presenter.onSwitchAuthButtonClick();
            }
        });
        //sign in with google
        FirebaseApp.initializeApp(this);
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(SignUpActivity.this, options);

        mAuth = FirebaseAuth.getInstance();

        googleSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = googleSignInClient.getSignInIntent();
                activityResultLauncher.launch(intent);

            }
        });

    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);


    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showToast(String message) {
        Toast.makeText(SignUpActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void switchAuth() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigate() {
        Intent intent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}