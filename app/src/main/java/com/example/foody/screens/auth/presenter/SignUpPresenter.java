package com.example.foody.screens.auth.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.example.foody.dataSources.firebase.SignUpCallback;
import com.example.foody.dataSources.firebase.UserAuthModel;
import com.example.foody.screens.auth.IContract;

public class SignUpPresenter implements IContract.Presenter {

    private IContract.Model model;
    private IContract.View view;
    public SignUpPresenter(IContract.View view, IContract.Model model){
        this.view=view;
        this.model=model;
    }
    @Override
    public boolean validateUserInput(String email, String password, String confirmPassword) {
        view.showProgress();

        if (TextUtils.isEmpty(email)) {
            view.showToast("Enter Email");
            return false;
        }

        if (TextUtils.isEmpty(password)) {
            view.showToast("Enter Password");
            Log.i("validator", "validateUserInput: " + email + " " + password + " " + confirmPassword);
            return false;
        }

        if (!password.equals(confirmPassword)) {
            view.showToast("Passwords do not match");
            Log.i("validator", "validateUserInput: " + email + " " + password + " " + confirmPassword);
            return false;
        }

        return true;
    }


    @Override
    public void onSignIn_UpClick(UserAuthModel user) {
       if(validateUserInput(user.getEmail(),user.getPassword(), user.getConfirmPassword())){
           Log.i("TAG", "onSingIn_UpClick: ");
           model.signUp(user, new SignUpCallback() {
               @Override
               public void onSignUpComplete(boolean isSuccessful) {
                   if(isSuccessful){
                       view.hideProgress();
                       view.showToast("Account Created.");
                       view.navigate();


                   }
                   else{
                       view.showToast("Authentication failed.");

                   }
               }
           });
       }

    }

    @Override
    public void onSwitchAuthButtonClick() {
        view.switchAuth();
    }

    @Override
    public void onDestroy() {
        view = null;

    }
}
