package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.Formatter;

public class MainActivity extends AppCompatActivity {
Button euro,dollar,ansdollar,candollar,yen,rubel,bitcoin,dinar,pound;
EditText editText;
TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        euro=findViewById(R.id.euro);
        dollar=findViewById(R.id.dollar);
        ansdollar=findViewById(R.id.ansdollar);
        candollar=findViewById(R.id.candollar);
        yen=findViewById(R.id.yen);
        rubel=findViewById(R.id.rubel);
        bitcoin=findViewById(R.id.bitcoin);
        dinar=findViewById(R.id.quithdin);
        editText=findViewById(R.id.editText);
        pound=findViewById(R.id.pound);
        textView=findViewById(R.id.textView);
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z=editText.getText().toString();
                if(TextUtils.isEmpty(z)){
                    editText.setError("Empty user Input");
                }
                else
                {
                    double n,k;
                    n= Double.parseDouble(z);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    k=n*0.013;

                    DecimalFormat numberFormate=new DecimalFormat("#0.00");
                    textView.setText(""+numberFormate.format(k));

                }
            }
        });

        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d=editText.getText().toString();
                if(TextUtils.isEmpty(d))
                {
                    editText.setError("Empty user Input");
                }
                else
                {
                    double i,j;
                    i=Double.parseDouble(d);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    j=i*0.014;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(j));
                }
            }
        });
        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p=editText.getText().toString();
                if(TextUtils.isEmpty(p))
                {
                    editText.setError("Empty User Input");
                }
                else
                {
                    double m,l;
                    m=Double.parseDouble(p);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    l=m*0.011;
                    DecimalFormat format=new DecimalFormat("#0.00");
                    textView.setText(""+format.format(l));

                }
            }
        });
        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String y=editText.getText().toString();
                if(TextUtils.isEmpty(y))
                {
                    editText.setError("Empty user Input");

                }
                else
                {
                    double p,o;
                    p=Double.parseDouble(y);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    o=p*1.60;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(o));
                }
            }
        });
        dinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d=editText.getText().toString();
                if(TextUtils.isEmpty(d))
                {
                    editText.setError("Empty user Input");
                }
                else
                {
                    double q,w;
                    q=Double.parseDouble(d);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    w=q*0.0044;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(w));

                }
            }
        });
        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b=editText.getText().toString();
                if(TextUtils.isEmpty(b))
                {
                    editText.setError("Empty User Input");
                }
                else
                {
                    double a,s;
                    a=Double.parseDouble(b);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    s=a*0.0000037;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(s));
                }
            }
        });
        rubel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r=editText.getText().toString();
                if(TextUtils.isEmpty(r))
                {
                    editText.setError("Empty User Input");

                }
                else
                {
                    double t,c;
                    t=Double.parseDouble(r);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    c=t*0.94;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(c));


                }
            }
        });
        ansdollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ans=editText.getText().toString();
                if(TextUtils.isEmpty(ans))
                {
                    editText.setError("Empty User Input");
                }
                else
                {
                    double g,h;
                    g=Double.parseDouble(ans);
                    textView.setText(null);
                    Formatter formatter=new Formatter();

                    h=g*0.020;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(h));
                }
            }
        });
        candollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String can=editText.getText().toString();
                if(TextUtils.isEmpty(can))
                {
                    editText.setError("Empty User Input");
                }
                else
                {
                    double x1,x2;
                    x1=Double.parseDouble(can);
                    textView.setText(null);
                    Formatter formatter=new Formatter();
                    x2=x1*0.019;
                    DecimalFormat decimalFormat=new DecimalFormat("#0.00");
                    textView.setText(""+decimalFormat.format(x2));

                }
            }
        });



    }
}
