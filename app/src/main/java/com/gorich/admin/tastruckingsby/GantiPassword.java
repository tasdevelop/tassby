package com.gorich.admin.tastruckingsby;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GantiPassword extends AppCompatActivity {
    public static String rslt="";

    protected TextView mPasswordTV;
    protected TextView mPasswordBaruTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganti_password);

        final String nUser = getIntent().getExtras().getString("user", "user");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");

        final AlertDialog ad=new AlertDialog.Builder(this).create();

        mPasswordTV = (TextView) findViewById((R.id.pass));
        mPasswordBaruTV = (TextView) findViewById((R.id.passbaru));

        Button bt_gantipass=(Button)findViewById(R.id.bt_gantipass);
        bt_gantipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try
                {
                    rslt="START";
                    Caller c=new Caller();
                    c.user= nUser.toString();
                    c.password= mPasswordTV.getText().toString();
                    c.passwordbaru= mPasswordBaruTV.getText().toString();
                    c.status= "START";

                    c.sCommand ="gantipassword";
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