package com.sultanseidov.parkingapp.View.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sultanseidov.parkingapp.R;
import com.sultanseidov.parkingapp.model.User;
import com.sultanseidov.parkingapp.sharedPreference.SaveSharedPreference;
import com.sultanseidov.parkingapp.util.Util;

import org.jetbrains.annotations.NotNull;

public class SignUpFragment extends Fragment {

    View view;
    TextView textViewUserName;

    TextView textViewUserEmail;
    TextView textViewUserPhoneNumber;
    TextView textViewUserPassord;
    TextView textViewVehileNumber;
    TextView textViewVehicleType;

    TextView textViewSignUp;
    Util util;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        initUIComponent();
        return view;
    }

    private void initUIComponent() {


        textViewUserEmail = view.findViewById(R.id.textViewNewUserEmail);
        textViewUserPhoneNumber = view.findViewById(R.id.textViewUserPhoneNumber);
        textViewUserPassord = view.findViewById(R.id.textViewUserPassord);
        textViewVehileNumber = view.findViewById(R.id.textViewVehileNumber);
        textViewVehicleType = view.findViewById(R.id.textViewVehicleType);

        textViewSignUp = view.findViewById(R.id.textViewSignUp);


    }

    private boolean checkAllPageFields() {
        boolean valid = true;


        if (textViewUserEmail.getText().toString().isEmpty()) {
            textViewUserEmail.setError("empty");
            valid = false;
        }
        if (textViewUserPassord.getText().toString().isEmpty()) {
            textViewUserPassord.setError("empty");
            valid = false;
        }
        if (textViewUserPhoneNumber.getText().toString().isEmpty()) {
            textViewUserPhoneNumber.setError("empty");
            valid = false;
        }
        if (textViewVehileNumber.getText().toString().isEmpty()) {
            textViewVehileNumber.setError("empty");
            valid = false;
        }
        if (textViewVehicleType.getText().toString().isEmpty()) {
            textViewVehicleType.setError("empty");
            valid = false;
        }


        return valid;
    }


    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        textViewSignUp.setOnClickListener(v -> {

            /*
            if (checkAllPageFields()) {
                User userModel = new User();
                userModel.setUserName(textViewUserEmail.getText().toString());
                userModel.setUserEmail(textViewUserEmail.getText().toString());
                userModel.setPassword(textViewUserPassord.getText().toString());
                userModel.setUserPhoneNumber(textViewUserPhoneNumber.getText().toString());
                userModel.setUserVehicleNumber(textViewVehileNumber.getText().toString());
                userModel.setUserVehicleType(textViewVehicleType.getText().toString());
                util.setUserModel(view.getContext(), userModel);
                SaveSharedPreference.setLoggedIn(view.getContext(), true);
                Toast.makeText(view.getContext(), "Yeni kullanici basariylakaydedildi", Toast.LENGTH_SHORT).show();

            }

             */

            Toast.makeText(view.getContext(), "Yeni kullanici basariylakaydedildi", Toast.LENGTH_SHORT).show();


        });
    }
}