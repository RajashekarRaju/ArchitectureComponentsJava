package com.developersbreach.architecturecomponentsjava.main;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developersbreach.architecturecomponentsjava.R;
import com.developersbreach.architecturecomponentsjava.model.Vehicle;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class VehiclesFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private VehicleAdapter mVehicleAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vehicles, container, false);
        mRecyclerView = view.findViewById(R.id.vehicle_recycler_view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        VehicleFragmentViewModel viewModel = ViewModelProviders.of(this).get(VehicleFragmentViewModel.class);
        viewModel.getVehicleData().observe(this, new Observer<List<Vehicle>>() {
            @Override
            public void onChanged(List<Vehicle> vehicleList) {
                mVehicleAdapter = new VehicleAdapter(getContext(), vehicleList, new VehicleListener());
                mRecyclerView.setAdapter(mVehicleAdapter);
            }
        });
    }

    private static class VehicleListener implements VehicleAdapter.VehicleAdapterListener {

        @Override
        public void onVehicleSelected(Vehicle vehicle, View view) {
            /*
             * Using Navigation object we find navigation controller with view then we will call
             * navigate with it's action name and pass argument to open correct item. You can change
             * this action name "actionVehiclesFragmentToVehicleDetailFragment" of your choice in
             * navigation.xml file and make both match properly.
             */
            Navigation.findNavController(view).navigate(VehiclesFragmentDirections.actionVehiclesFragmentToVehicleDetailFragment(vehicle));
        }
    }
}
