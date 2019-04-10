package com.example.vollyapi;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VollySingleton {
    private  static VollySingleton minstance;
    private RequestQueue mrequestqueue;

    public VollySingleton(Context context) {
        mrequestqueue= Volley.newRequestQueue(context.getApplicationContext());
    }
    public static synchronized VollySingleton getInstance(Context context)
    {
        if (minstance==null)
        {
            minstance=new VollySingleton(context);
        }
        return minstance;

    }
    public RequestQueue getrequestqueue()
    {
        return mrequestqueue;
    }

}
