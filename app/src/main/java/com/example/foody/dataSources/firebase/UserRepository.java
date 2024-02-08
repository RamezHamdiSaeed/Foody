package com.example.foody.dataSources.firebase;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserRepository {
    private FirebaseAuth mAuth;
    private static UserRepository instance = null;

    private UserRepository() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public void signUp(String email, String password, SignUpCallback callback) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success
                            callback.onSignUpComplete(true);
                            Log.i("TAG", "firebase repository onComplete: true");
                        } else {
                            // Sign up failed
                            Log.e("TAG", "onComplete: Sign up failed", task.getException());
                            callback.onSignUpComplete(false);
                        }
                    }
                });
    }

    public void signIn(String email, String password, SignInCallback callback) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success
                            callback.onSignInComplete(true);
                            Log.i("TAG", "firebase repository onComplete: Sign in success");
                        } else {
                            // Sign in failed
                            Log.e("TAG", "onComplete: Sign in failed", task.getException());
                            callback.onSignInComplete(false);
                        }
                    }
                });
    }
}
