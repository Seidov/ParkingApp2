package com.sultanseidov.parkingapp.view.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sultanseidov.parkingapp.R;

import org.jetbrains.annotations.NotNull;

public class ParkingLotDetailsFragment extends Fragment implements OnMapReadyCallback {
    View view;
    LinearLayout linearBack;
    private GoogleMap mMap;
    LocationManager locationManager;
    LocationListener locationListener;
    Bitmap markerMyLocation;
    Bitmap markerParkingLotLocation;
    int height = 100;
    int width = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.fragment_parking_lot_details, container, false);
        initUIComponent();
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        return view;
    }

    private void initUIComponent() {
        linearBack=view.findViewById(R.id.linearBack);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        BitmapDrawable bitmapdraw = (BitmapDrawable)getResources().getDrawable(R.drawable.car_park);
        Bitmap b = bitmapdraw.getBitmap();
        markerParkingLotLocation = Bitmap.createScaledBitmap(b, width, height, false);


        BitmapDrawable bitmapdraw2 = (BitmapDrawable)getResources().getDrawable(R.drawable.location);
        Bitmap b2 = bitmapdraw2.getBitmap();
        markerMyLocation = Bitmap.createScaledBitmap(b2, width, height, false);


        linearBack.setOnClickListener(v ->{
            Navigation.findNavController(view).navigate(R.id.action_parkingLotDetailsFragment_pop);
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        locationManager = (LocationManager) requireActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {

                mMap.clear();


                LatLng besiktasCultureCenter = new LatLng(41.0494366541401, 29.004910174581582);
                MarkerOptions markerParkingLotLacation = new MarkerOptions().position(besiktasCultureCenter).title("besiktasCultureCenter");
                markerParkingLotLacation.icon(BitmapDescriptorFactory.fromBitmap(markerParkingLotLocation));
                mMap.addMarker(markerParkingLotLacation);


                MarkerOptions markerMyLocation = new MarkerOptions().position(new LatLng(location.getLatitude(),location.getLongitude())).title("Your Location");
                markerMyLocation.icon(BitmapDescriptorFactory.fromBitmap(ParkingLotDetailsFragment.this.markerMyLocation));
                googleMap.addMarker(markerMyLocation);




            }
        };

        if (ContextCompat.checkSelfPermission(requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),new String[] {Manifest.permission.ACCESS_FINE_LOCATION},1);
        } else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,2,locationListener);

            Location lastLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastLocation != null) {
                LatLng lastUserLocation = new LatLng(lastLocation.getLatitude(),lastLocation.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(lastUserLocation,15));
            }

            LatLng besiktasCultureCenter = new LatLng(41.0494366541401, 29.004910174581582);
            MarkerOptions markerParkingLotLacation = new MarkerOptions().position(besiktasCultureCenter).title("Besiktas Parking Garage");
            markerParkingLotLacation.icon(BitmapDescriptorFactory.fromBitmap(markerParkingLotLocation));
            mMap.addMarker(markerParkingLotLacation);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(besiktasCultureCenter,15));


        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 ) {
            if (requestCode == 1) {
                if (ContextCompat.checkSelfPermission(requireActivity(),Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,locationListener);
                }
            }
        }

    }
}