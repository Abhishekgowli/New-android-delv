package com.example.quickchange;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
RelativeLayout relativeLayout;
RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout=findViewById(R.id.rl);
        radioGroup=findViewById(R.id.rg);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.rbtnr:
                        relativeLayout.setBackgroundColor(Color.parseColor("#E71C23"));
                        break;
                    case R.id.rbtng:
                        relativeLayout.setBackgroundColor(Color.parseColor("#019031"));
                        break;
                    case R.id.rbtnb:
                        relativeLayout.setBackgroundColor(Color.parseColor("#0A79DF"));
                        break;

                }
            }
        });
    }
}
