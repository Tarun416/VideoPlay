package com.example.video;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rahul on 10/02/17.
 */

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.ViewHolder> {


    private Context context;
    private int[] trailerimagee;
    private OnTrailerClickListener onTrailerClickListener;

    public TrailerAdapter(Context context,int [] trailerimage,OnTrailerClickListener onTrailerClickListener) {
        this.context = context;
        this.trailerimagee=trailerimage;
        this.onTrailerClickListener=onTrailerClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.trailer_view, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.trailerimage.setImageResource(trailerimagee[position]);

    }

    @Override
    public int getItemCount() {
        return trailerimagee.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.trailerimage)
        ImageView trailerimage;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            trailerimage.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();

            if (position != RecyclerView.NO_POSITION) {

                switch (view.getId()) {
                    case R.id.trailerimage:
                        onTrailerClickListener.onItemClick(position);



                }
            }

        }
    }
}
