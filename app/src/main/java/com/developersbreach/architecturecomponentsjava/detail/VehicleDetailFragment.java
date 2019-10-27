package com.developersbreach.architecturecomponentsjava.detail;


import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developersbreach.architecturecomponentsjava.R;
import com.developersbreach.architecturecomponentsjava.model.Vehicle;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class VehicleDetailFragment extends Fragment {


    public VehicleDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vehicle_detail, container, false);

        final ImageView vehicleImageView = view.findViewById(R.id.detail_vehicle_image_view);
        final TextView vehicleNameTextView = view.findViewById(R.id.detail_vehicle_name_text_view);

        Application application = Objects.requireNonNull(getActivity()).getApplication();
        Vehicle vehicle = VehicleDetailFragmentArgs.fromBundle(Objects.requireNonNull(getArguments())).getDetailFragmentArgs();
        DetailFragmentViewModelFactory factory = new  DetailFragmentViewModelFactory(application, vehicle);
        DetailFragmentViewModel viewModel = ViewModelProviders.of(this, factory).get(DetailFragmentViewModel.class);

        viewModel.getSelectedVehicle().observe(this, new Observer<Vehicle>() {
            @Override
            public void onChanged(Vehicle vehicle) {
                vehicleImageView.setImageResource(vehicle.getVehicleImage());
                vehicleNameTextView.setText(vehicle.getVehicleName());
            }
        });

        return view;
    }

}
