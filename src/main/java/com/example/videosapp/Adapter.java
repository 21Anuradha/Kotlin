package com.example.videosapp;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videosapp.databinding.ReelDgBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.VideoHolder>{
    Context context;
    ArrayList<model> modelArrayList= new ArrayList<>();
    boolean isPlaying=false;

    public Adapter(Context context, ArrayList<model> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.reel_dg, parent,false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, int position) {
        holder.binding.videoView1.setVideoPath(modelArrayList.get(position).getVideoUrl());
        holder.binding.name.setText(modelArrayList.get(position).getName());
        holder.binding.profileImage.setImageResource(modelArrayList.get(position).getProfile());
        holder.binding.videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying=true;
            }
        });
        holder.binding.videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                isPlaying=true;
            }
        });
        holder.binding.videoView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPlaying){
                    holder.binding.videoView1.pause();
                    isPlaying=false;
                }else {
                    holder.binding.videoView1.resume();
                    isPlaying=true;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class VideoHolder extends RecyclerView. ViewHolder{

        ReelDgBinding binding;

        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            binding = ReelDgBinding.bind(itemView);
        }
    }
}
