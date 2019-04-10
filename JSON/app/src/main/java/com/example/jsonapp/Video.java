package com.example.jsonapp;

import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("name")
    private String mname;
    @SerializedName("duration")
    private int mduration;

    public Video(String mname, int mduration) {
        this.mname = mname;
        this.mduration = mduration;
    }
}

