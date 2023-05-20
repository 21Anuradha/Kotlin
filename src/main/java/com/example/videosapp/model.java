package com.example.videosapp;

import android.graphics.ColorSpace;

public class model {
    String videoUrl;
    int profile;
    String name;

    public model(String videoUrl, int profile, String name){
        this.videoUrl = videoUrl;
        this.profile=profile;
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(int profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
