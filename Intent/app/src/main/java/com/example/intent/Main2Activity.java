package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button button1;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=findViewById(R.id.textView);
        String myval=getIntent().getStringExtra("name");
        textView.setText(myval);

    }
    public void screentwo(View view)
    {
        Intent intent=new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent);
    }

}
