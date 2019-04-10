package com.example.truthdare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
private ImageView imageView;
private Button button;
private Random random=new Random();
private  int lastdirection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.button);
    }

    public  void truth (View view)
    {
        int newdirection= random.nextInt(3600);
        float pivotx=imageView.getWidth()/2;
        float pivoty=imageView.getHeight()/2;


        Animation rotate=new RotateAnimation(lastdirection,newdirection,pivotx,pivoty);
        rotate.setDuration(2000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                button.setEnabled(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                button.setEnabled(true);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        lastdirection=newdirection;
        imageView.startAnimation(rotate);
   }
}
