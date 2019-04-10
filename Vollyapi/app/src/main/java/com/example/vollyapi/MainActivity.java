package com.example.vollyapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.textview);
        button=findViewById(R.id.button);
//        requestQueue= Volley.newRequestQueue(this);
        requestQueue=VollySingleton.getInstance(this).getrequestqueue();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendapirequest();
            }
        });
    }


    private void  sendapirequest()
    {
        String url="https://api.myjson.com/bins/dz40k";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray=response.getJSONArray("students");

                    for (int i=0;i<jsonArray.length();i++)
                    {
                        JSONObject student=jsonArray.getJSONObject(i);
                        String name=student.getString("name");
                        int coursecount=student.getInt("course_count");
                        String email=student.getString("email");

                        textView.append(name+","+String.valueOf(coursecount+","+email+"\n"));
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

}
