package com.example.foody.screens.auth.model;

import com.example.foody.dataSources.firebase.SignInCallback;
import com.example.foody.dataSources.firebase.SignUpCallback;
import com.example.foody.dataSources.firebase.UserAuthModel;
import com.example.foody.dataSources.firebase.UserRepository;
import com.example.foody.screens.auth.IContract;

public class AuthModel implements IContract.Model {


    @Override
    public void signUp(UserAuthModel user, SignUpCallback callback) {
        UserRepository.getInstance().signUp(user.getEmail(),user.getPassword(),callback);
    }

    @Override
    public void signIn(UserAuthModel user, SignInCallback callback) {
        UserRepository.getInstance().signIn(user.getEmail(),user.getPassword(),callback);
    }

}
