package com.example.jsonapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {
    private String name;
    @SerializedName("course_count")
    private int courseCount;
    private String email;
    @SerializedName("Video")
    private List<Video> mvideo;
    @SerializedName("Course")
    private course mcourse;


    public Student(String name, int course_count, String email, course Course,List<Video>video) {
        this.name = name;
        this.courseCount = course_count;
        this.email = email;
        mcourse=Course;
        mvideo=video;
    }
}
