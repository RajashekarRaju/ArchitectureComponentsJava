package com.developersbreach.architecturecomponentsjava.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.developersbreach.architecturecomponentsjava.R;
import com.developersbreach.architecturecomponentsjava.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleFragmentViewModel extends ViewModel {

    private MutableLiveData<List<Vehicle>> mVehicleData;

    // Get vehicle list of data return type MutableLiveData
    MutableLiveData<List<Vehicle>> getVehicleData() {
        mVehicleData = new MutableLiveData<>();
        loadAllVehicles();
        return mVehicleData;
    }

    /*
     * Hardcoded vehicle data which shows in our list.
     *
     * We can use AsyncTask to load this data in background but since this is not heavy process
     * loading from database or internet.
     */
    private void loadAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(R.drawable.ic_airport_shuttle, "Airport Shuttle"));
        vehicleList.add(new Vehicle(R.drawable.ic_bike, "Bicycle"));
        vehicleList.add(new Vehicle(R.drawable.ic_boat, "Boat"));
        vehicleList.add(new Vehicle(R.drawable.ic_bus, "Bus"));
        vehicleList.add(new Vehicle(R.drawable.ic_car, "Car"));
        vehicleList.add(new Vehicle(R.drawable.ic_child_friendly, "Child Friendly"));
        vehicleList.add(new Vehicle(R.drawable.ic_flight, "Aeroplane"));
        vehicleList.add(new Vehicle(R.drawable.ic_local_shipping, "Local Shipping"));
        vehicleList.add(new Vehicle(R.drawable.ic_local_taxi, "Local Taxi"));
        vehicleList.add(new Vehicle(R.drawable.ic_motorcycle, "Motorcycle"));
        vehicleList.add(new Vehicle(R.drawable.ic_railway, "Railway"));
        vehicleList.add(new Vehicle(R.drawable.ic_subway, "Subway"));
        mVehicleData.postValue(vehicleList);
    }
}
