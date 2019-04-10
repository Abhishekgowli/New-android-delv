package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button B;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText.findViewById(R.id.editText);

    }
    public void screenone(View view)
    {
        String s=editText.getText().toString();
        if(s.length()==0)
        {
            editText.setError("No Input");
        }
        else
        {
            Intent intent=new Intent(MainActivity.this,Main2Activity.class);
            intent.putExtra("name",s);

                    startActivity(intent);
        }


    }
}


