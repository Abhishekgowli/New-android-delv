package com.example.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class EampleAdapter extends RecyclerView.Adapter<EampleAdapter.ExampleViewHolder>
{
    //6.2
    private ArrayList<Exampleitem> mExamplelist;
    //1
    public static class ExampleViewHolder extends RecyclerView.ViewHolder
    {
        public ImageView imageView;
        public TextView textView;


        //2
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            //4
            imageView=itemView.findViewById(R.id.imageView);
            textView=itemView.findViewById(R.id.textView);

        }
    }
    //6.1
    public EampleAdapter(ArrayList<Exampleitem>examplelist){

        mExamplelist=examplelist;

    }

    //3
    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //5
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem,parent,false);
        ExampleViewHolder exampleViewHolder=new ExampleViewHolder(view);
        return exampleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder exampleViewHolder, int i) {
        //7
        Exampleitem currentitem=mExamplelist.get(i);
        exampleViewHolder.imageView.setImageResource(currentitem.getmImageResource());
        exampleViewHolder.textView.setText(currentitem.getmText());


    }

    @Override
    public int getItemCount() {
        return mExamplelist.size();
    }





}
