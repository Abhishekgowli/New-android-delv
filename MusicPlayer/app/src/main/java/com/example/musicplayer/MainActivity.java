package com.example.musicplayer;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    public  void playMe(View view)
    {
        mediaPlayer.start();
    }
    public  void pauseMe(View view)
    {
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer=MediaPlayer.create(this,R.raw.testaudio);

        //get contex from Audio services
        audioManager= (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int mymaxvoloum=audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int mycurrentvoloum=audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);


        //set conterx to the voloum rockers
        final SeekBar voloumrocker=findViewById(R.id.seekBar);
        voloumrocker.setMax(mymaxvoloum);
        voloumrocker.setProgress(mycurrentvoloum);

        //set a listliner to the seekbar voloum raockers
        voloumrocker.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        final SeekBar timeline=findViewById(R.id.timeline);
        timeline.setMax(mediaPlayer.getDuration());


        timeline.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                mediaPlayer.seekTo(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeline.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 1000);




    }
}
