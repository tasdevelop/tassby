package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailTrip extends AppCompatActivity {
    public static String rslt="";

    protected TextView mNoBukti;
    protected TextView mEMKL;
    protected TextView mTujuanTarif;
    protected TextView mNoPol;
    protected TextView mDari;
    protected TextView mSampai;
    protected TextView mJenisOrderan;
    protected TextView mUkuranCont;
    protected TextView mStatusCont;
    protected TextView mNoChasis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_trip);

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        final String mUser = getIntent().getExtras().getString("user", "user");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");

        mNoBukti = (TextView) findViewById((R.id.txtTanggal));
        mEMKL = (TextView) findViewById((R.id.spinnerEMKL));
        mTujuanTarif = (TextView) findViewById((R.id.spinnerTujuanTarif));
        mNoPol = (TextView) findViewById((R.id.spinnerNoPol));
        mDari = (TextView) findViewById((R.id.spinnerDari));
        mSampai = (TextView) findViewById((R.id.spinnerSampai));
        mJenisOrderan = (TextView) findViewById((R.id.spinnerJenisOrder));
        mUkuranCont = (TextView) findViewById((R.id.spinnerCont));
        mStatusCont = (TextView) findViewById((R.id.spinnerFE));
        mNoChasis = (TextView) findViewById((R.id.spinnerNoChasis));

        mNoBukti.setText(getIntent().getExtras().getString("nobukti", "nobukti"));
        mEMKL.setText(getIntent().getExtras().getString("emkl", "emkl"));
        mTujuanTarif.setText(getIntent().getExtras().getString("tujuantarif", "tujuantarif"));
        mNoPol.setText(getIntent().getExtras().getString("nopol", "nopol"));
        mDari.setText(getIntent().getExtras().getString("dari", "dari"));
        mSampai.setText(getIntent().getExtras().getString("sampai", "sampai"));
        mJenisOrderan.setText(getIntent().getExtras().getString("jenisorderan", "jenisorderan"));
        mUkuranCont.setText(getIntent().getExtras().getString("ukurancont", "ukurancont"));
        mStatusCont.setText(getIntent().getExtras().getString("statuscont", "statuscont"));
        mNoChasis.setText(getIntent().getExtras().getString("nochasis", "nochasis"));

        final AlertDialog ad=new AlertDialog.Builder(this).create();
        Button bt_delete=(Button)findViewById(R.id.bt_delete);
        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try
                {
                    rslt="START";
                    Caller c=new Caller();
                    c.nobukti= mNoBukti.getText().toString();
                    c.status= "START";

                    c.sCommand ="hapustrip";
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

//                    AlertDialog.Builder builder = new AlertDialog.Builder(
//                            getApplicationContext());
//                    builder.setCancelable(true);
//                    builder.setTitle("Title");
//                    builder.setInverseBackgroundForced(true);
//                    builder.setMessage(rslt);
//                    builder.setPositiveButton("OK",
//                            new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//                                    dialog.dismiss();
//
//                                    //BUKA FORM MAIN ACTIVITY
//                                    Intent myIntent = new Intent(DetailTrip.this,ListTrip.class);
//                                    myIntent.putExtra("user",mUser.toString());
//                                    startActivity(myIntent);
//                                    //BUKA FORM MAIN ACTIVITY
//                                }
//                            });
//
//                    AlertDialog alert = builder.create();
//                    alert.show();


                    if (("berhasil".equals(rslt)))
                    {
                        //BUKA FORM MAIN ACTIVITY
                        Intent myIntent = new Intent(DetailTrip.this,ListTrip.class);
                        myIntent.putExtra("user",mUser.toString());
                        myIntent.putExtra("mandor",nMandor.toString());
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
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(DetailTrip.this,ListTrip.class);
                myIntent.putExtra("user",mUser.toString());
                myIntent.putExtra("mandor",nMandor.toString());
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });

    }
}
