package com.example.slqstudentrecord;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    databasehelper mydb;
    EditText edittextid,edittextname,edittextemail,editTextcc;
    Button buttonadd,buttongetdata,buttonupdate,buttondelete,buttonviewall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb=new databasehelper(this);

        edittextid=findViewById(R.id.editText_id);
        edittextname=findViewById(R.id.editText_name);
        edittextemail=findViewById(R.id.editText_email);
        editTextcc=findViewById(R.id.editText_CC);

        buttonadd=findViewById(R.id.button_add);
        buttondelete=findViewById(R.id.button_delete);
        buttonupdate=findViewById(R.id.button_update);
        buttongetdata=findViewById(R.id.button_view);
        buttonviewall=findViewById(R.id.button_viewAll);

        AddData();
        getData();
        viewall();
        updatedata();
        deletedata();




    }


    public void AddData()
    {
        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInsereted=mydb.Insertdata(edittextname.getText().toString(),edittextemail.getText().toString(),editTextcc.getText().toString());
                if(isInsereted==true)
                {
                    Toast.makeText(MainActivity.this,"Data Inserted!",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Somthing Went Worng",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public  void getData()
    {
        buttongetdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edittextid.getText().toString();

                if (id.equals(String.valueOf(""))){
                    edittextid.setError("Enter ID");
                    return;
                }

                Cursor cursor = mydb.getdata(id);
                String data = null;

                if (cursor.moveToNext()){
                    data = "ID: "+ cursor.getString(0) +"\n"+
                            "Name: "+ cursor.getString(1) +"\n"+
                            "Email: "+ cursor.getString(2) +"\n"+
                            "Course Count: "+ cursor.getString(3) +"\n";
                }
                showmessage("Data: ", data);

            }
        });

    }


    public void viewall()
    {
        buttonviewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor=mydb.getalldata();


                //small test
                if (cursor.getCount()==0)
                {
                    showmessage("Error ","nothing found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();


                while (cursor.moveToNext())
                {
                    buffer.append("ID: "+cursor.getString(0)+"\n");
                    buffer.append("NAME "+cursor.getString(1)+"\n");
                    buffer.append("EMAIL "+cursor.getString(2)+"\n");
                    buffer.append("COURSECOUNT "+cursor.getString(3)+"\n\n");
                }
                showmessage("All Data", buffer.toString());
            }
        });

    }

    public void updatedata()
    {
        buttonupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean isupdate=mydb.updatedata(edittextid.getText().toString(),
                        edittextname.getText().toString(),
                        edittextemail.getText().toString(),
                        editTextcc.getText().toString());

                if (isupdate==true)
                {
                    Toast.makeText(MainActivity.this,"Update sucessful",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"oops",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void deletedata()
    {
        buttondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deleterow=mydb.deletedata(edittextid.getText().toString());
                if (deleterow>0)
                {
                    Toast.makeText(MainActivity.this,"Deleted succesfullly",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"OOPS",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void showmessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
