package com.alaythiaproductions.viewpager2kenburns;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder> {

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    private List<TravelLocation> travelLocations;

    public List<TravelLocation> getTravelLocations() {
        return travelLocations;
    }

    public void setTravelLocations(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_location, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
        holder.setLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView locationKenBurnsView;
        private TextView titleTextView, locationTextView, starRatingTextView;

        public TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);

            locationKenBurnsView = itemView.findViewById(R.id.location_kenburnsview);
            titleTextView = itemView.findViewById(R.id.title_textview);
            locationTextView = itemView.findViewById(R.id.location_textview);
            starRatingTextView = itemView.findViewById(R.id.star_rating_textview);
        }

        void setLocationData(TravelLocation travelLocation) {
            Picasso.get().load(travelLocation.getImageUrl()).into(locationKenBurnsView);
            titleTextView.setText(travelLocation.getTitle());
            locationTextView.setText(travelLocation.getLocation());
            starRatingTextView.setText(String.valueOf(travelLocation.getStarRating()));
        }
    }
}
