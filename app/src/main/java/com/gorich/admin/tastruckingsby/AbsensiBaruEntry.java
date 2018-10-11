package com.gorich.admin.tastruckingsby;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.gson.Gson;

import java.util.Calendar;
import java.util.Date;

public class AbsensiBaruEntry extends AppCompatActivity {
    public static String rslt="";

    protected TextView mTgl;
    protected TextView mNoPol;
    protected TextView mSupirAwal;
    protected TextView mStatusAwal;

    protected Spinner mSupir;
    protected Spinner mStatus;
    protected EditText mKet;
    protected EditText mJam;

    String[] supirlist;
    String[] statuslist;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi_baru_entry);

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        final String nUser = getIntent().getExtras().getString("user", "user");
        final String nNoPol = getIntent().getExtras().getString("nopol", "nopol");
        final String nSupir = getIntent().getExtras().getString("supir", "supir");
        final String nStatus = getIntent().getExtras().getString("status", "status");
        final String nKet = getIntent().getExtras().getString("keterangan", "keterangan");
        final String nJam = getIntent().getExtras().getString("jam", "jam");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");

        mTgl = (TextView) findViewById((R.id.txtTanggal));
        mNoPol = (TextView) findViewById((R.id.spinnerNoPol));
        mSupirAwal = (TextView) findViewById((R.id.txtsupir));
        mStatusAwal = (TextView) findViewById((R.id.txtstatus));
        mSupir = (Spinner) findViewById((R.id.spinnersupir));
        mStatus = (Spinner) findViewById((R.id.spinnerstatus));
        mKet = (EditText) findViewById((R.id.txtketerangan));
        mJam = (EditText) findViewById((R.id.txtJam));

        mJam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(AbsensiBaruEntry.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        mJam.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        //AMBIL TANGGAL HARI INI
        Date d = new Date();
        CharSequence s  = DateFormat.format("d MMMM yyyy ", d.getTime());
        mTgl.setText(s);
        //AMBIL TANGGAL HARI INI

        mNoPol.setText(nNoPol);
        mSupirAwal.setText(nSupir);
        mStatusAwal.setText(nStatus);
//        setSpinText (mSupir,nSupir);
//        setSpinText (mStatus,nStatus);
        mKet.setText(nKet);
        mJam.setText(nJam);

        //region BIND COMBO SUPIR
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcombosupir";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            supirlist = gson.fromJson(rslt,   String[].class);
            mSupir.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, supirlist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });
        } catch (Exception ex) {

        }
        //endregion
        //region BIND COMBO STATUS ABSEN
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcombostatustrado";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            statuslist = gson.fromJson(rslt,   String[].class);
            mStatus.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, statuslist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });

        } catch (Exception ex) {

        }
        //endregion

        final AlertDialog ad=new AlertDialog.Builder(this).create();
        Button bt_save=(Button)findViewById(R.id.bt_save);
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                try
                {
                    rslt="START";
                    Caller c=new Caller();
                    c.user= nUser.toString();
                    c.nopol= mNoPol.getText().toString();
                    c.supir= mSupir.getSelectedItem().toString();
                    c.statustrado= mStatus.getSelectedItem().toString();
                    c.ket= mKet.getText().toString();
                    c.jam=mJam.getText().toString();

                    c.status= "START";
                    c.sCommand ="entryabsensi";
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


//                    ad.setTitle("INFO");
//                    ad.setMessage(rslt);
//                    ad.show();

                    if (("berhasil".equals(rslt)))
                    {
                        //BUKA FORM MAIN ACTIVITY
                        Intent myIntent = new Intent(AbsensiBaruEntry.this,AbsensiBaru.class);
                        myIntent.putExtra("user",nUser.toString());
                        startActivity(myIntent);
                        //BUKA FORM MAIN ACTIVITY
                    }
                    else
                    {
                        ad.setTitle("INFO");
                        ad.setMessage(rslt);
                        ad.show();
                    }

                }catch(Exception ex) {

                }
            }
        });


        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //BUKA FORM MAIN ACTIVITY
//                Intent myIntent = new Intent(AbsensiBaruEntry.this,MainMenu.class);
//                myIntent.putExtra("user",nUser.toString());
//                startActivity(myIntent);
//                //BUKA FORM MAIN ACTIVITY

                if (("1".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(AbsensiBaruEntry.this,MainMenuMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else if (("2".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(AbsensiBaruEntry.this,MainMenuNonMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(AbsensiBaruEntry.this,MainMenu.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
            }
        });
    }


    public void setSpinText(Spinner spin, String text)
    {
        for(int i= 0; i < spin.getAdapter().getCount(); i++)
        {
            if(spin.getAdapter().getItem(i).toString().contains(text))
            {
                spin.setSelection(i);
            }
        }

    }
}