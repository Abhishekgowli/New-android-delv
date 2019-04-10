package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    Button btnadd,btndel;
    EditText etadd,etdel;
    ArrayList<Exampleitem>examplelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genratefakedata();
        configiuration();

        //find the button by id
        btnadd=findViewById(R.id.buttonadd);
        btndel=findViewById(R.id.buttondelete);
        //find the edit text by id

        etadd=findViewById(R.id.edittextadd);
        etdel=findViewById(R.id.edittextdelete);

        //set on click linsiser
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(null))
                {
                    etadd.setError("empty input");
                }
                else
                {
                int position = Integer.parseInt(etadd.getText().toString());
                addcard(position);
                }


            }
        });


        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(etdel.getText().toString());



                if( TextUtils.isEmpty(position.leng))
                {
                    etadd.setError("empty input");
                }
                else
                {

                    deleteCard(position);

                }

            }
        });

    }
    public void genratefakedata()
    {
        examplelist=new ArrayList<>();

        examplelist.add(new Exampleitem(R.drawable.node,"clicked at studio"));
        examplelist.add(new Exampleitem(R.drawable.twor,"clicked at italy"));
        examplelist.add(new Exampleitem(R.drawable.threer,"clicked at Rome"));
        examplelist.add(new Exampleitem(R.drawable.fourr,"clicked at greece"));
        examplelist.add(new Exampleitem(R.drawable.fiver,"clicked at santroini"));
        examplelist.add(new Exampleitem(R.drawable.sixr,"clicked at india"));
    }

    public void configiuration()

    {
        //config
        recyclerView=findViewById(R.id.recyclerview);
        //performnce
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        adapter=new EampleAdapter(examplelist);


        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void addcard(int position)
    {
        examplelist.add(position, new Exampleitem(R.drawable.node,  "new card added"));
        //adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(position);
    }
    public void deleteCard(int position){
        examplelist.remove(position);
        adapter.notifyItemRemoved(position);
    }




}
