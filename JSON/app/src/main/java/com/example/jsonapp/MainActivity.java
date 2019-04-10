package com.example.jsonapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson=new Gson();
//        Student student=new Student("abhi",5,"abhi@gamail.com");

//        String json="{\"course_count\":5,\"email\":\"abhi@gamail.com\",\"name\":\"abhi\"}";
//        Student student=gson.fromJson(json,Student.class);


//        String json=gson.toJson(student);

        List<Video>videos=new ArrayList<>();
       videos.add(new Video("intro",5));
       videos.add(new Video("exe",8));
       videos.add(new Video("instal",12));

//
//        course Course=new course("java","bootcamp");
//        Student student=new Student("abhi",2,"gowleabhi@gmail.com",Course,videos);
//        String json=gson.toJson(student);

//        Log.d("text",json);



        String json="{\"course_count\":2,\"email\":\"gowleabhi@gmail.com\",\"Course\":{\"descrption\":\"bootcamp\",\"name\":\"java\"},\"Video\":[{\"duration\":5,\"name\":\"intro\"},{\"duration\":8,\"name\":\"exe\"},{\"duration\":12,\"name\":\"instal\"}],\"name\":\"abhi\"}";
        Student student=gson.fromJson(json,Student.class);
        Log.d("text",student.toString());



    }
}
