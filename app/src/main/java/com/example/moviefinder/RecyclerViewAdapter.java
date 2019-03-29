package com.example.moviefinder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private String[] mImageData;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;

        public ViewHolder(View view) {
            super(view);

            mImageView = (ImageView) view;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int listItemId = R.layout.movie_poster_view;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(listItemId, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        String imgUrl = String.valueOf(R.string.image_prefix) + mImageData[i];
        Picasso.get().load(imgUrl).into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        if (mImageData != null) {
            return mImageData.length;
        } else {
            return 0;
        }
    }
}
