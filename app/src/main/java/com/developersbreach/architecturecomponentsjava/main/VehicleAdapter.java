package com.developersbreach.architecturecomponentsjava.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.developersbreach.architecturecomponentsjava.R;
import com.developersbreach.architecturecomponentsjava.model.Vehicle;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.VehicleViewHolder> {

    private List<Vehicle> mVehicleList;
    private VehicleAdapterListener mListener;

    VehicleAdapter(List<Vehicle> vehicleList, VehicleAdapterListener listener) {
        this.mVehicleList = vehicleList;
        this.mListener = listener;
    }

    public interface VehicleAdapterListener {
        void onVehicleSelected(Vehicle vehicle, View view);
    }

    class VehicleViewHolder extends RecyclerView.ViewHolder {

        private ImageView mVehicleImageView;
        private TextView mVehicleNameTextView;

        VehicleViewHolder(@NonNull final View itemView) {
            super(itemView);
            mVehicleImageView = itemView.findViewById(R.id.vehicle_image_item_view);
            mVehicleNameTextView = itemView.findViewById(R.id.vehicle_name_text_item_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onVehicleSelected(mVehicleList.get(getAdapterPosition()), itemView);
                }
            });
        }
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_vehicle, parent, false);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        Vehicle vehicle = mVehicleList.get(position);
        holder.mVehicleImageView.setImageResource(vehicle.getVehicleImage());
        holder.mVehicleNameTextView.setText(vehicle.getVehicleName());
    }

    @Override
    public int getItemCount() {
        return mVehicleList.size();
    }
}
