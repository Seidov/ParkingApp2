package com.sultanseidov.parkingapp.view.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sultanseidov.parkingapp.model.ParkingLotItemModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HomeViewModel extends ViewModel {



    public MutableLiveData<List<ParkingLotItemModel>> parkingItemModelData = new MutableLiveData<List<ParkingLotItemModel>>();
    public MutableLiveData<Boolean> parkingItemModelDataLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> parkingItemModelDataLoading = new MutableLiveData<Boolean>();


    public void refreshParkingLotListModelData() {
        fetchParkingLotModelData();
    }

    private void fetchParkingLotModelData() {
        try {
            parkingItemModelDataLoading.setValue(true);
            Random rand = new Random();
            ParkingLotItemModel itemModel =new ParkingLotItemModel();
            List<ParkingLotItemModel> parkingLotItemModelList= new ArrayList<>();

            for (int i =0;i<16;i++){

                itemModel.setId(i);
                itemModel.setName("ParkingLot "+i);
                itemModel.setDistance(String.valueOf(i));
                itemModel.setFreeArea(String.valueOf(rand.nextInt(8)));
                itemModel.setHourlyRate(String.valueOf(rand.nextInt(8)+20));
                parkingLotItemModelList.add(itemModel);

            }
            parkingItemModelData.postValue(parkingLotItemModelList);
            parkingItemModelDataLoadError.postValue(false);
            parkingItemModelDataLoading.setValue(false);

        }catch (Exception e){
            parkingItemModelDataLoadError.postValue(true);

        }
    }
}
