package com.example.foody.screens.auth.view;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
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
import com.example.foody.dataSources.firebase.UserAuthModel;
import com.example.foody.screens.auth.IContract;
import com.example.foody.screens.auth.model.AuthModel;
import com.example.foody.screens.auth.presenter.AuthPresenter;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

public class SignInActivity extends AppCompatActivity  implements IContract.View {
    private IContract.Presenter presenter;
    private EditText email,password;
    private ImageView googleSignIn;
    private Button signBtn;
    private TextView switchAuth,guestNavigator;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private GoogleSignInClient googleSignInClient;
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
                                Toast.makeText(SignInActivity.this, "Signed in successfully!", Toast.LENGTH_SHORT).show();
                                Intent intentTwoMainActivity = new Intent(SignInActivity.this, MainActivity.class);
                                startActivity(intentTwoMainActivity);
                                finish();

                            } else {
                                Toast.makeText(SignInActivity.this, "Failed to sign in: " + task.getException(), Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_sign_in);
        presenter=new AuthPresenter(this,new AuthModel());

        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        googleSignIn=findViewById(R.id.googleSignIn);
        signBtn =findViewById(R.id.signInbtn);
        switchAuth=findViewById(R.id.switchAuth);
        guestNavigator=findViewById(R.id.guestNavigator);
        progressBar=findViewById(R.id.progressBar2);
        mAuth = FirebaseAuth.getInstance();

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSingIn_UpClick(new UserAuthModel(email.getText().toString(), password.getText().toString(), password.getText().toString()));

//                progressBar.setVisibility(View.VISIBLE);
//
//                String emailString,passwordString;
//                emailString=email.getText().toString();
//                passwordString=password.getText().toString();
//                if(TextUtils.isEmpty(emailString)){
//                    progressBar.setVisibility(View.GONE);
//
//                    Toast.makeText(SignInActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if(TextUtils.isEmpty(passwordString)){
//                    Toast.makeText(SignInActivity.this, "Enter Password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                mAuth.signInWithEmailAndPassword(emailString, passwordString)
//                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    Toast.makeText(SignInActivity.this, "Signed in successfully.",
//                                            Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
//
//                                } else {
//                                    // If sign in fails, display a message to the user.
//
//                                    Toast.makeText(SignInActivity.this, "Authentication failed.",
//                                            Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });////
            }
        });

        switchAuth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
//                startActivity(intent);
                presenter.onSwitchAuthButtonClick();

            }
        });

        //sign in with google
        FirebaseApp.initializeApp(this);
        GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.client_id))
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(SignInActivity.this, options);

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
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
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
        Toast.makeText(SignInActivity.this, message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void switchAuth() {
        Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivity(intent);

    }

    @Override
    public void navigate() {
        Intent intent = new Intent(SignInActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}