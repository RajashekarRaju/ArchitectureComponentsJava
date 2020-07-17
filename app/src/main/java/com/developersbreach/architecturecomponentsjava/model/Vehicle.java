package com.developersbreach.architecturecomponentsjava.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Vehicle implements Parcelable {

    private int mVehicleImage;
    private String mVehicleName;

    public Vehicle(int vehicleImage, String vehicleName) {
        this.mVehicleImage = vehicleImage;
        this.mVehicleName = vehicleName;
    }

    public int getVehicleImage() {
        return mVehicleImage;
    }

    public String getVehicleName() {
        return mVehicleName;
    }

    public static final Creator<Vehicle> CREATOR = new Creator<Vehicle>() {
        @Override
        public Vehicle createFromParcel(Parcel in) {
            return new Vehicle(in);
        }

        @Override
        public Vehicle[] newArray(int size) {
            return new Vehicle[size];
        }
    };

    private Vehicle(Parcel in) {
        mVehicleImage = in.readInt();
        mVehicleName = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mVehicleImage);
        parcel.writeString(mVehicleName);
    }
}
