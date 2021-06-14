package com.example.vs_restapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {

    private List<Video> allVideos;
    private Context context;

    public VideoAdapter(Context ctx, List<Video> videos) {
        this.allVideos = videos;
        this.context = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_view,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(allVideos.get(position).getTitle());
        String link = allVideos.get(position).getImageUrl();
        link = link.substring(0, 4) + "s" + link.substring(4, link.length());
        Picasso.get().load(link).into(holder.videoImage);
//        Glide.with(context).load(allVideos.get(position).getImageUrl()).into(holder.videoImage);
    }

    @Override
    public int getItemCount() {
        return allVideos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView videoImage;
        TextView title;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            videoImage = itemView.findViewById(R.id.videoThumbnail);
            title = itemView.findViewById(R.id.videoTitle);
            view = itemView;
        }
    }
}
