package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuMandor extends AppCompatActivity {
    public static String rslt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_mandor);


        final String nUser = getIntent().getExtras().getString("user", "user");

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON


        Button bt_inputtrip=(Button)findViewById(R.id.bt_inputtrip);
        bt_inputtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,TripBaru.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","1" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
        Button bt_inputtripgantung=(Button)findViewById(R.id.bt_inputtripgantung);
        bt_inputtripgantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,TripBaruGantung.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","1" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
        Button bt_inputtripgantungsenin=(Button)findViewById(R.id.bt_inputtripgantungsenin);
        bt_inputtripgantungsenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,ActivityTripBaruGantungSenin.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

        Button bt_datatrip=(Button)findViewById(R.id.bt_datatrip);
        bt_datatrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,ListTrip.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","1" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
        Button bt_datatripgantung=(Button)findViewById(R.id.bt_datatripgantung);
        bt_datatripgantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,ListTripGantung.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","1" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

        Button bt_gantipass=(Button)findViewById(R.id.bt_gantipass);
        bt_gantipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,GantiPassword.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","1" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });


        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuMandor.this,MainActivity.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","1" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
    }
}

