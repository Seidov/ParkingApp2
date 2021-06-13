package com.sultanseidov.parkingapp.util;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.sultanseidov.parkingapp.model.User;
import com.sultanseidov.parkingapp.sharedPreference.SaveSharedPreference;

public class Util {

    public User getUserModel(Context context) {
        Gson gson = new Gson();
        return gson.fromJson(SaveSharedPreference.getUser(context), User.class);
    }


    public void setUserModel(Context context, User userModel) {
        try {
            Gson gson = new Gson();
            SaveSharedPreference.setUser(context, gson.toJson(userModel));
        } catch (Exception e) {
            Log.e("parking", "setUserModel Exception: " + e);
        }


    }

}
