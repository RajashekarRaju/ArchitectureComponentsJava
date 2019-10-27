package com.developersbreach.architecturecomponentsjava.main;

import android.content.Context;
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

    private Context mContext;
    private List<Vehicle> mVehicleList;
    private VehicleAdapterListener mListener;

    /**
     * Constructor for our adapter class
     */
    VehicleAdapter(Context context, List<Vehicle> vehicleList, VehicleAdapterListener listener) {
        this.mContext = context;
        this.mVehicleList = vehicleList;
        this.mListener = listener;
    }

    /**
     * The interface that receives onClick listener.
     */
    public interface VehicleAdapterListener {
        void onVehicleSelected(Vehicle vehicle, View view);
    }

    /**
     * Children views for vehicle data
     */
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

    /**
     * Called when RecyclerView needs a new {@link VehicleViewHolder} of the given type to represent
     * an item.
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_vehicle, parent, false);
        return new VehicleViewHolder(view);
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link VehicleViewHolder#itemView} to reflect the item at the given
     * position.
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder holder, int position) {
        Vehicle vehicle = mVehicleList.get(position);
        holder.mVehicleImageView.setImageResource(vehicle.getVehicleImage());
        holder.mVehicleNameTextView.setText(vehicle.getVehicleName());
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return mVehicleList.size();
    }
}
