package com.sultanseidov.parkingapp.util.sharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import static com.sultanseidov.parkingapp.util.sharedPreference.PreferencesUtility.LOGGED_IN_PREF;
import static com.sultanseidov.parkingapp.util.sharedPreference.PreferencesUtility.USERMODEL;

public class SaveSharedPreference {


    static SharedPreferences getPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }


    public static void setLoggedIn(Context context, boolean loggedIn) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putBoolean(LOGGED_IN_PREF, loggedIn);
        editor.apply();
    }


    public static boolean getLoggedStatus(Context context) {
        return getPreferences(context).getBoolean(LOGGED_IN_PREF, false);
    }


    public static void setUser(Context context, String user) {
        SharedPreferences.Editor editor = getPreferences(context).edit();
        editor.putString(USERMODEL, user);
        editor.apply();
    }


    public static String getUser(Context context) {
        return getPreferences(context).getString(USERMODEL,"s");
    }

}
