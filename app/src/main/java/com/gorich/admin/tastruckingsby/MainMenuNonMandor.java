package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuNonMandor extends AppCompatActivity {
    public static String rslt="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu_non_mandor);

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
                Intent myIntent = new Intent(MainMenuNonMandor.this,AbsensiBaru.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","2" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });


        Button bt_dataabsensi=(Button)findViewById(R.id.bt_dataabsensi);
        bt_dataabsensi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuNonMandor.this,ListAbsensi.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","2" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

        Button bt_gantipass=(Button)findViewById(R.id.bt_gantipass);
        bt_gantipass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuNonMandor.this,GantiPassword.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","2" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });


        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainMenuNonMandor.this,MainActivity.class);
                myIntent.putExtra("user",nUser.toString());
                myIntent.putExtra("mandor","2" );
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
    }
}
