package com.gorich.admin.tastruckingsby;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LupaPassword extends AppCompatActivity {
    public static String rslt="";
    protected TextView mUserTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lupa_password);

        mUserTV = (TextView) findViewById((R.id.user));

        final AlertDialog ad=new AlertDialog.Builder(this).create();

        Button bt_proses=(Button)findViewById(R.id.bt_proses);
        bt_proses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try
                {
                    rslt="START";
                    Caller c=new Caller();
                    c.user= mUserTV.getText().toString();
                    c.status= "START";

                    c.sCommand ="lupapassword";
                    c.join();
                    c.start( );
                    while(rslt=="START")
                    {
                        try
                        {
                            Thread.sleep(10);

                        }catch(Exception ex)
                        {

                        }
                    }

                    ad.setTitle("INFO");
                    ad.setMessage(rslt);
                    ad.show();

                }catch(Exception ex) {

                }
            }
        });
    }
}

