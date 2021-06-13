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
import androidx.navigation.Navigation;

import com.sultanseidov.parkingapp.R;
import com.sultanseidov.parkingapp.util.Util;

import org.jetbrains.annotations.NotNull;


public class SignInFragment extends Fragment {
    static View view;
    Util util;
    private TextView textViewSignUp;
    private TextView textViewSignIn;
    private TextView textViewUserName;
    private TextView textViewUserPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        initUIComponent();

        return view;
    }

    private void initUIComponent() {
        textViewSignUp = view.findViewById(R.id.textViewSignUp);
        textViewSignIn = view.findViewById(R.id.textViewSignIn);
        textViewUserName = view.findViewById(R.id.textViewUserName);
        textViewUserPassword = view.findViewById(R.id.textViewUserPassword);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        textViewSignIn.setOnClickListener(v -> {

            /*
            if (checkAllPageFields(textViewUserName,textViewUserPassword)){

                try {

                    User user=util.getUserModel(view.getContext());
                    if (user!=null){

                        if (user.getUserName().toString().equals(textViewUserName.toString()) &&
                                user.getPassword().toString().equals(textViewUserPassword.toString())){

                            Toast.makeText(view.getContext(), "Giris basarili", Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(view.getContext(), "Kayıtlı kullanıcı bulunamadı!", Toast.LENGTH_SHORT).show();
                    }

                    SaveSharedPreference.setLoggedIn(view.getContext(), true);

                }catch (Exception e){
                    Toast.makeText(view.getContext(), ""+e, Toast.LENGTH_SHORT).show();
                }
            }

             */

            Toast.makeText(view.getContext(), "Giris basarili", Toast.LENGTH_SHORT).show();


        });
        textViewSignUp.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.action_signInFragment_to_signUpFragment);

        });
    }

    private boolean checkAllPageFields(TextView textViewUserName, TextView textViewUserPassword) {
        boolean valid = true;

        if (textViewUserName.getText().toString().isEmpty()) {
            textViewUserName.setError("empty");
            valid = false;
        }

        if (textViewUserPassword.getText().toString().isEmpty()) {
            textViewUserPassword.setError("empty");
            valid = false;
        }


        return valid;
    }
}