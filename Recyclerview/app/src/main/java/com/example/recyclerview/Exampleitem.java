package com.example.recyclerview;

public class Exampleitem {
    private  int  mImageResource;
    private  String mText;
    public Exampleitem(int imageresource,String text)
    {
        mImageResource=imageresource;
        mText=text;
    }


    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
