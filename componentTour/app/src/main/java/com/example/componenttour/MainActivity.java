package com.example.componenttour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button bu;
EditText e1,e2;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu = findViewById(R.id.btn);
        e1 = findViewById(R.id.ed_1);
        e2 = findViewById(R.id.ed_2);
        textView = findViewById(R.id.tv_3);
    }
    public void add(View view){
        int i=Integer.parseInt(e1.getText().toString());
        int j=Integer.parseInt(e2.getText().toString());
        int k=i+j;
        textView.setText(" ANS IS" +k);
    }
}
