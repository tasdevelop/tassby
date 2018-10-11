package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    public static String rslt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        final String nUser = getIntent().getExtras().getString("user", "user");

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        Button bt_inputabsensi=(Button)findViewById(R.id.bt_absensi);
        bt_inputabsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,AbsensiBaru.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

        Button bt_inputtrip=(Button)findViewById(R.id.bt_inputtrip);
        bt_inputtrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,TripBaru.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
        Button bt_inputtripgantung=(Button)findViewById(R.id.bt_inputtripgantung);
        bt_inputtripgantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,TripBaruGantung.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
        Button bt_inputtripgantungsenin=(Button)findViewById(R.id.bt_inputtripgantungsenin);
        bt_inputtripgantungsenin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,ActivityTripBaruGantungSenin.class);
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
                Intent myIntent = new Intent(MainMenu.this,ListTrip.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
        Button bt_datatripgantung=(Button)findViewById(R.id.bt_datatripgantung);
        bt_datatripgantung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,ListTripGantung.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

        Button bt_dataabsensi=(Button)findViewById(R.id.bt_dataabsensi);
        bt_dataabsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,ListAbsensi.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

        Button bt_gantipass=(Button)findViewById(R.id.bt_gantipass);
        bt_gantipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,GantiPassword.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });


        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenu.this,MainActivity.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","3" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
    }
}
