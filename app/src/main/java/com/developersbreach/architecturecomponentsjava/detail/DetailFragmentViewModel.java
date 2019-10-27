package com.developersbreach.architecturecomponentsjava.detail;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.developersbreach.architecturecomponentsjava.model.Vehicle;

class DetailFragmentViewModel extends AndroidViewModel {

    private MutableLiveData<Vehicle> selectedVehicle = new MutableLiveData<>();

    DetailFragmentViewModel(@NonNull Application application, Vehicle vehicle) {
        super(application);
        selectedVehicle.postValue(vehicle);
    }

    MutableLiveData<Vehicle> getSelectedVehicle() {
        return selectedVehicle;
    }
}
