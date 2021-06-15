package com.sultanseidov.parkingapp.view.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sultanseidov.parkingapp.R;
import com.sultanseidov.parkingapp.model.ParkingLotItemModel;
import com.sultanseidov.parkingapp.view.activity.RegisterActivity;
import com.sultanseidov.parkingapp.util.sharedPreference.SaveSharedPreference;
import com.sultanseidov.parkingapp.view.adapter.ParkingLotListAdapter;
import com.sultanseidov.parkingapp.view.viewModel.HomeViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    View view;
    LinearLayout linearLogout;
    HomeViewModel viewModel;
    TextView textErrorMessage;
    ProgressBar progressBar;
    RecyclerView rcvParkingLotList;
    ParkingLotListAdapter adapter = new ParkingLotListAdapter(new ArrayList<>());

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home, container, false);
        initUIComponent();
        viewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        return view;
    }

    private void initUIComponent() {
        textErrorMessage=view.findViewById(R.id.errorMessage);
        linearLogout=view.findViewById(R.id.linearLogout);
        progressBar=view.findViewById(R.id.progressBar);
        rcvParkingLotList=view.findViewById(R.id.rcvParkingLotList);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initParkingLotRecyclerView();
        viewModel.refreshParkingLotListModelData();
        observerParkingLotListViewModel();

        linearLogout.setOnClickListener(v ->{
            SaveSharedPreference.setLoggedIn(requireContext(),false);
            Intent intent = new Intent(getActivity(), RegisterActivity.class);
            startActivity(intent);
            requireActivity().finish();
        } );

    }

    private void observerParkingLotListViewModel() {

        viewModel.parkingItemModelData.observe(requireActivity(), (List<ParkingLotItemModel> parkingLotItemModel) -> {

            if (parkingLotItemModel != null) {

                adapter.updateParkingLotList(parkingLotItemModel);
            }
        });

        viewModel.parkingItemModelDataLoadError.observe(requireActivity(), isError -> {
            if (isError != null) {
                textErrorMessage.setVisibility(isError ? View.VISIBLE : View.GONE);

                if (isError) {

                    rcvParkingLotList.setVisibility(View.GONE);

                } else {

                    rcvParkingLotList.setVisibility(View.VISIBLE);

                }


            }

        });

        viewModel.parkingItemModelDataLoading.observe(requireActivity(), isLoading -> {
            if (isLoading != null) {
                if (isLoading) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);


                }

            }
        });

    }

    private void initParkingLotRecyclerView() {
        rcvParkingLotList.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rcvParkingLotList.setAdapter(adapter);
    }
}