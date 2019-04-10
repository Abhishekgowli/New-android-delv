package com.example.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;
    TextView textView,textview2;
    RequestQueue requestQueue;
//    https://api.openweathermap.org/data/2.5/weather?q=Mysuru&appid=37bc0d54466ae717c378ede71314805a
    String baseURL="https://api.openweathermap.org/data/2.5/weather?q=";
    String API="&appid=37bc0d54466ae717c378ede71314805a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textView);
        textview2=findViewById(R.id.textView2);
        requestQueue=VollySingleton.getInstance(this).getrequestqueue();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myURL=baseURL+editText.getText().toString() +API;
//                Log.i("url","url"+myURL);

                JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, myURL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("weather");

                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject weather=jsonArray.getJSONObject(i);
                                String myweather=weather.getString("main");
                                textview2.setText(myweather);
                                String id=weather.getString("id");
                                String main=weather.getString("main");
//                                textView.append(id+","+main);



                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(request);



            }
        });
    }
}
