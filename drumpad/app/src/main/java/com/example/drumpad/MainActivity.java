package com.example.drumpad;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
MediaPlayer m1,m2,m3,m4,m5,m6,m7,m8,m9,m10,m11,m12;
ImageButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.imageButton1);
        b2=findViewById(R.id.imageButton2);
        b3=findViewById(R.id.imageButton3);
        b4=findViewById(R.id.imageButton4);
        b5=findViewById(R.id.imageButton5);
        b6=findViewById(R.id.imageButton6);
        b7=findViewById(R.id.imageButton7);
        b8=findViewById(R.id.imageButton8);
        b9=findViewById(R.id.imageButton9);
        b10=findViewById(R.id.imageButton10);
        b11=findViewById(R.id.imageButton11);
        b12=findViewById(R.id.imageButton12);


        m1=MediaPlayer.create(this,R.raw.one);
        m2=MediaPlayer.create(this,R.raw.two);
        m3=MediaPlayer.create(this,R.raw.three);
        m4=MediaPlayer.create(this,R.raw.four);
        m5=MediaPlayer.create(this,R.raw.fv);
        m6=MediaPlayer.create(this,R.raw.sixth);
        m7=MediaPlayer.create(this,R.raw.seventh);
        m8=MediaPlayer.create(this,R.raw.eighth);
        m9=MediaPlayer.create(this,R.raw.one);
        m10=MediaPlayer.create(this,R.raw.two);
        m11=MediaPlayer.create(this,R.raw.three);
        m12=MediaPlayer.create(this,R.raw.four);



    }

    public void sound(View view)
    {
        switch (view.getId())
        {
            case R.id.imageButton1:
                m1.start();
                break;
            case R.id.imageButton2:
                m2.start();
                break;
            case R.id.imageButton3:
                m3.start();
                break;
            case R.id.imageButton4:
                m4.start();
                break;
            case R.id.imageButton5:
                m5.start();
                break;
            case R.id.imageButton6:
                m6.start();
                break;
            case R.id.imageButton7:
                m7.start();
                break;
            case R.id.imageButton8:
                m8.start();
                break;
            case R.id.imageButton9:
                m9.start();
                break;
            case R.id.imageButton10:
                m10.start();
                break;
            case R.id.imageButton11:
                m11.start();
                break;
            case R.id.imageButton12:
                m12.start();
                break;


        }

    }
}
