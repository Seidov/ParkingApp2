package com.sultanseidov.parkingapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.sultanseidov.parkingapp.R;
import com.sultanseidov.parkingapp.model.ParkingLotItemModel;
import com.sultanseidov.parkingapp.model.ParkinkLotModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotListAdapter extends RecyclerView.Adapter<ParkingLotListAdapter.MyViewHolder> {
    List<ParkingLotItemModel> modelList = new ArrayList<>();


    public ParkingLotListAdapter(List<ParkingLotItemModel> modelList) {
        this.modelList = modelList;
    }

    public void updateParkingLotList(List<ParkingLotItemModel> parkinkLotModels){
        modelList.clear();
        modelList.addAll(parkinkLotModels);
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parkinglot, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MyViewHolder holder, int position) {

        holder.textViewName.setText(modelList.get(position).getName());

        holder.textHourlyRate.setText(modelList.get(position).getHourlyRate());

        holder.textDistance.setText(modelList.get(position).getDistance());

        holder.textFreeArea.setText(modelList.get(position).getFreeArea());

        holder.itemView.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_parkingLotDetailsFragment);
        });

    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textHourlyRate;
        TextView textDistance;
        TextView textFreeArea;

        public MyViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewName);

            textHourlyRate=itemView.findViewById(R.id.textHourlyRate);

            textDistance=itemView.findViewById(R.id.textDistance);

            textFreeArea=itemView.findViewById(R.id.textFreeArea);

        }
    }
}
