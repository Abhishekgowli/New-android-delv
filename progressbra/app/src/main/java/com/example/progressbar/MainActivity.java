package com.example.progressbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
ProgressBar progressBar,progresshorizantal;
Button start,end,upload;
int progess=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        progresshorizantal=findViewById(R.id.progress_horizontal);
        start=findViewById(R.id.start);
        end=findViewById(R.id.end);
        upload=findViewById(R.id.upload);
        progressBar.setVisibility(View.GONE);
    }
    public void start(View view)
    {
        progressBar.setVisibility(View.VISIBLE);

    }
    public void end(View view)
    {
        progressBar.setVisibility(View.GONE);

    }
    public void upload(View view)
    {
  fakeupload(progess);
    }
    public void fakeupload(final int progess)
    {
        progresshorizantal.setProgress(progess);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fakeupload(progess+ 10);

            }

        });
        thread.start();
    }
}
