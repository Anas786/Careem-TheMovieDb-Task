package com.example.anas.careemmoviedb.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.anas.careemmoviedb.Model.MovieCardDataModel;
import com.example.anas.careemmoviedb.MovieDetail;
import com.example.anas.careemmoviedb.R;

import java.util.ArrayList;
import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Created by Anas on 15-May-18.
 */

public class MovieRecyclerViewAdapter extends RecyclerView
        .Adapter<MovieRecyclerViewAdapter
        .DataObjectHolder>{

    private ArrayList<MovieCardDataModel> mDataset;
    private static MovieRecyclerViewAdapter.MyClickListener myClickListener;
    private Activity activity;

    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements View
            .OnClickListener {
        TextView tvPopularity,tvMovieName;
        ImageView imPoster;

        public DataObjectHolder(View itemView) {
            super(itemView);
            tvPopularity = itemView.findViewById(R.id.popularity);
            tvMovieName = itemView.findViewById(R.id.movie_name);
            imPoster = itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(MovieRecyclerViewAdapter.MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    public MovieRecyclerViewAdapter(ArrayList<MovieCardDataModel> myDataset, Activity activity) {
        mDataset = myDataset;
        this.activity = activity;
    }

    @Override
    public MovieRecyclerViewAdapter.DataObjectHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie_card_layout, parent, false);

        MovieRecyclerViewAdapter.DataObjectHolder dataObjectHolder = new MovieRecyclerViewAdapter.DataObjectHolder(view);
        return dataObjectHolder;
    }

    @Override
    public void onBindViewHolder(MovieRecyclerViewAdapter.DataObjectHolder holder, int position) {
        holder.tvPopularity.setText(getPopularityString(mDataset.get(position).getPopularity()));
        holder.tvMovieName.setText(mDataset.get(position).getMovieName());
        if(mDataset.get(position).getImagePath() != null){
            if (!mDataset.get(position).getImagePath().isEmpty()) {
                Glide.with(activity)
                        .load(activity.getString(R.string.image_url)+mDataset.get(position).getImagePath())
                        .apply(RequestOptions.centerCropTransform())
                        .transition(withCrossFade())
                        .into(holder.imPoster);
            }else {
                holder.imPoster.setImageResource(R.drawable.ic_launcher_background);
            }
        }else {
            holder.imPoster.setImageResource(R.drawable.ic_launcher_background);
        }
    }

    private String getPopularityString(float popularity) {
        java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat("#.#");
        return decimalFormat.format(popularity);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }



    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }

}
