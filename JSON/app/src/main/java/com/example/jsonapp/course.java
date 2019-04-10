package com.example.jsonapp;

import com.google.gson.annotations.SerializedName;

public class course {
    @SerializedName("name")
    private String mname;
    @SerializedName("descrption")
    private String Mdescrpition;

    public course(String mname, String mdescrpition) {
        this.mname = mname;
        Mdescrpition = mdescrpition;
    }
}
