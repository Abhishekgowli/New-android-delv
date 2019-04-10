package com.example.twodice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView red,blue;
private Button button;
private Random rrandom=new Random();
private Random brandom=new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        blue=findViewById(R.id.imgblue);
        red=findViewById(R.id.imgred);
        button=findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reddice();
                bluedice();

            }
        });
    }
    private void  reddice(){
        int r=rrandom.nextInt(6)+1;
        switch (r){
            case 1:
                red.setImageResource(R.drawable.reddice1);
                break;
            case 2:
                red.setImageResource(R.drawable.reddice2);
                break;
            case 3:
                red.setImageResource(R.drawable.reddice3);
                break;
            case 4:
                red.setImageResource(R.drawable.reddice4);
                break;
            case 5:
                red.setImageResource(R.drawable.reddice5);
                break;
            case 6:
                red.setImageResource(R.drawable.reddice6);

        }

    }

    private  void bluedice() {
        int b=brandom.nextInt(6)+1;
        switch (b)
        {
            case 1:
                blue.setImageResource(R.drawable.dice1);
                break;
            case 2:
                blue.setImageResource(R.drawable.dice2);
                break;
            case 3:
                blue.setImageResource(R.drawable.dice3);
                break;
            case 4:
                blue.setImageResource(R.drawable.dice4);
                break;
            case 5:
                blue.setImageResource(R.drawable.dice5);
                break;
            case 6:
                blue.setImageResource(R.drawable.dice6);
                break;
        }
    }

}
