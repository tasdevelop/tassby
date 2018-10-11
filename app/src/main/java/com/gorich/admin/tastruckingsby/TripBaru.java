package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Date;

public class TripBaru extends AppCompatActivity {
    public static String rslt="";
    public static String dari="Tanjung Perak";

    protected TextView mTgl;
    protected AutoCompleteTextView mEMKL;
    protected AutoCompleteTextView mTujuanTarif;
    protected AutoCompleteTextView mNoPol;
    protected AutoCompleteTextView mDari;
    protected AutoCompleteTextView mSampai;
    protected AutoCompleteTextView mShipper;
    protected Spinner mJenisOrderan;
    protected Spinner mUkuranCont;
    protected EditText mGudang;


    String[] emkllist;
    String[] jenisorderanlist;
    String[] tujuantariflist;
    String[] nopollist;
    String[] darilist;
    String[] sampailist;
    String[] ukurancontlist;
    String[] statuscontlist;
    String[] nochasislist;
    String[] shipperlist;
    String[] jenisritaslist;
    String[] ritasidrlist;
    String[] ritasikelist;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_baru);

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        final String nUser = getIntent().getExtras().getString("user", "user");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");

        mTgl = (TextView) findViewById((R.id.txtTanggal));
        mEMKL = (AutoCompleteTextView) findViewById((R.id.spinnerEMKL));
        mTujuanTarif = (AutoCompleteTextView) findViewById((R.id.spinnerTujuanTarif));
        mNoPol = (AutoCompleteTextView) findViewById((R.id.spinnerNoPol));
        mDari = (AutoCompleteTextView) findViewById((R.id.spinnerDari));
        mShipper = (AutoCompleteTextView) findViewById((R.id.spinnershipper));
        mJenisOrderan = (Spinner) findViewById((R.id.spinnerJenisOrder));
        mUkuranCont = (Spinner) findViewById((R.id.spinnerCont));
        mGudang = (EditText) findViewById((R.id.txtgudang));


        //AMBIL TANGGAL HARI INI
        Date d = new Date();
        CharSequence s  = DateFormat.format("d MMMM yyyy ", d.getTime());
        mTgl.setText(s);
        //AMBIL TANGGAL HARI INI



        //region BIND COMBO EMKL
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcomboemkl";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            emkllist = gson.fromJson(rslt,   String[].class);
            mEMKL.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, emkllist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });
            mEMKL.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    mEMKL.showDropDown();
                    return false;
                }
            });
        } catch (Exception ex) {

        }
        //endregion
        //region BIND COMBO JENIS ORDERAN
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcombojenisorderan";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            jenisorderanlist = gson.fromJson(rslt,   String[].class);
            mJenisOrderan.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, jenisorderanlist) {
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
        //region BIND COMBO TUJUAN TARIF
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcombotujuantarif";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            tujuantariflist = gson.fromJson(rslt,   String[].class);
            mTujuanTarif.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tujuantariflist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });
            mTujuanTarif.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    mTujuanTarif.showDropDown();
                    return false;
                }
            });
        } catch (Exception ex) {

        }
        //endregion
        //region BIND COMBO NO POLISI
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcombonopol";
            c.user =nUser;
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            nopollist = gson.fromJson(rslt,   String[].class);
            mNoPol.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nopollist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });
            mNoPol.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    mNoPol.showDropDown();
                    return false;
                }
            });
        } catch (Exception ex) {

        }
        //endregion
        //region BIND COMBO DARI DAN SAMPAI
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcombokotastd";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            darilist = gson.fromJson(rslt,   String[].class);
            mDari.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, darilist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });
            mDari.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    mDari.showDropDown();
                    return false;
                }
            });
            mDari.setText(dari) ;

//            mSampai.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, darilist) {
//                @Override
//                public View getView(int position, View convertView, ViewGroup parent) {
//                    TextView textView = (TextView) super.getView(position, convertView, parent);
//
//                    View view = super.getView(position, convertView, parent);
//                    TextView text = (TextView) view.findViewById(android.R.id.text1);
//                    text.setTextColor(Color.BLACK);
//                    return view;
//                }
//            });
//            mSampai.setOnTouchListener(new View.OnTouchListener(){
//                @Override
//                public boolean onTouch(View v, MotionEvent event){
//                    mSampai.showDropDown();
//                    return false;
//                }
//            });
        } catch (Exception ex) {

        }
        //endregion
        //region BIND COMBO SHIPPER
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcomboshipper";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            shipperlist = gson.fromJson(rslt,   String[].class);
            mShipper.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, shipperlist) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    TextView textView = (TextView) super.getView(position, convertView, parent);

                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            });
            mShipper.setOnTouchListener(new View.OnTouchListener(){
                @Override
                public boolean onTouch(View v, MotionEvent event){
                    mShipper.showDropDown();
                    return false;
                }
            });
        } catch (Exception ex) {

        }
        //endregion
        //region BIND COMBO UKURAN CONTAINER
        try {
            rslt = "START";
            Caller c = new Caller();
            c.sCommand = "getcomboukurancont";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            ukurancontlist = gson.fromJson(rslt,   String[].class);
            mUkuranCont.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ukurancontlist) {
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
                    c.emkl= mEMKL.getText().toString();
                    c.jnsorder= mJenisOrderan.getSelectedItem().toString();
                    c.tujuantarif= mTujuanTarif.getText().toString();
                    c.dari= mDari.getText().toString();
                    c.sampai= mTujuanTarif.getText().toString();
                    c.ukurancontainer= mUkuranCont.getSelectedItem().toString();
                    c.nochasis= "";
                    c.statuscont= "FULL";
                    c.islongtrip= 0;
                    c.shipper =mShipper.getText().toString();
                    c.gudang=mGudang.getText().toString();
                    c.jnsritasi="";
                    c.ritasidr="";
                    c.ritasike="";

                    c.status= "START";
                    c.sCommand ="entrytrip";
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

                    mNoPol.setText("");
                    mEMKL.setText("");
                    mTujuanTarif.setText("");
                    mDari.setText(dari);
                    mSampai.setText("");
                    mShipper.setText("");
                    mGudang.setText("");

                }catch(Exception ex) {

                }
            }
        });


        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //BUKA FORM MAIN ACTIVITY
//                Intent myIntent = new Intent(TripBaru.this,MainMenu.class);
//                myIntent.putExtra("user",nUser.toString());
//                startActivity(myIntent);
//                //BUKA FORM MAIN ACTIVITY

                if (("1".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(TripBaru.this,MainMenuMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else if (("2".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(TripBaru.this,MainMenuNonMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(TripBaru.this,MainMenu.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
            }
        });
    }


    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        //Refresh your stuff here

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
