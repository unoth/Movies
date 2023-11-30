package com.unoth.movies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TrailersAdapter extends RecyclerView.Adapter<TrailersAdapter.TrailersViewHolder> {
    private List<Trailer> trailers = new ArrayList<>();

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
        notifyDataSetChanged();
    }

    static class TrailersViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewTrailerName;

        public TrailersViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTrailerName = itemView.findViewById(R.id.textViewTrailerName);
        }
    }

    @NonNull
    @Override
    public TrailersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.trailer_item,
                parent,
                false
        );
        return new TrailersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailersViewHolder holder, int position) {
        Trailer trailer = trailers.get(position);
        holder.textViewTrailerName.setText(trailer.getName());
    }

    @Override
    public int getItemCount() {
        return trailers.size();
    }
}
