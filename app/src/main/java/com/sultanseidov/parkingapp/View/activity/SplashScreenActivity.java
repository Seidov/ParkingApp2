package com.sultanseidov.parkingapp.View.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.sultanseidov.parkingapp.View.activity.RegisterActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    private Runnable runnable = () -> {
        if (!isFinishing()) {
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            finish();
        }
    };

    private Runnable runnable2 = () -> {
        if (!isFinishing()) {
            finish();
        }
    };

    @Override
    protected void onResume() {
        super.onResume();

        if (isNetworkAvailable()){
            handler.postDelayed(runnable,2000);
        }else {
            Toast.makeText(this, "Lütfen bağlantı ayarlarınızı kontrol edip tekrar deneyiniz.", Toast.LENGTH_LONG).show();
            handler.postDelayed(runnable2,5000);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    public boolean isNetworkAvailable() {
        // Get Connectivity Manager class object from Systems Service
        ConnectivityManager cm = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);

        // Get Network Info from connectivity Manager
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();

        // if no network is available networkInfo will be null
        // otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}