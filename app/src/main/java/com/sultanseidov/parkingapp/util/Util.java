package com.sultanseidov.parkingapp.util;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.sultanseidov.parkingapp.model.UserModel;
import com.sultanseidov.parkingapp.util.sharedPreference.SaveSharedPreference;

public class Util {

    public UserModel getUserModel(Context context) {
        Gson gson = new Gson();
        return gson.fromJson(SaveSharedPreference.getUser(context), UserModel.class);
    }


    public void setUserModel(Context context, UserModel userModel) {
        try {
            Gson gson = new Gson();
            SaveSharedPreference.setUser(context, gson.toJson(userModel).toString());
        } catch (Exception e) {
            Log.e("parking", "setUserModel Exception: " + e);
        }


    }

}
