package com.example.foody.screens.auth;

import com.example.foody.dataSources.firebase.SignInCallback;
import com.example.foody.dataSources.firebase.SignUpCallback;
import com.example.foody.dataSources.firebase.UserAuthModel;

public interface IContract {
    public interface View {

        void showProgress();

        void hideProgress();

        void showToast(String string);
        void switchAuth();
        void navigate();
    }

    public interface Model {

        void signUp(UserAuthModel user, SignUpCallback callback);
        void signIn(UserAuthModel user, SignInCallback callback);

    }

    public interface Presenter {
        boolean validateUserInput(String email,String password,String confirmPassword);

        void onSignIn_UpClick(UserAuthModel user);

        void onSwitchAuthButtonClick();
        void onDestroy();
    }
}
