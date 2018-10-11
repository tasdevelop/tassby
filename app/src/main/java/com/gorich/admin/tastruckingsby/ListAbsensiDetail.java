package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

public class ListAbsensiDetail extends AppCompatActivity {
    public static String rslt="";
    private CustomListAdapterListAbsensi mAdapterAbsensi;
    ListView listv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_absensi_detail);
        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        final String nUser = getIntent().getExtras().getString("user", "user");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");
        final String nNoBukti = getIntent().getExtras().getString("nobukti", "nobukti");
        listv=(ListView)findViewById(R.id.list);

        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (("1".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListAbsensiDetail.this,MainMenuMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else if (("2".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListAbsensiDetail.this,MainMenuNonMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListAbsensiDetail.this,MainMenu.class);
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

        final String mUser = getIntent().getExtras().getString("user", "user");
        final String mNoBukti = getIntent().getExtras().getString("nobukti", "nobukti");

        //AMBIL LIST TRACING
        try {
            rslt = "START";
            Caller c = new Caller();
            c.nobukti= mNoBukti.toString();
            c.sCommand = "getlistabsensidetail";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            Gson gson = new Gson();
            BlogAbsensi BlogAbsensi = gson.fromJson(rslt, BlogAbsensi.class);

            final List<PostAbsensi> postsabsensi = BlogAbsensi.getPostsabsensi();
            mAdapterAbsensi = new CustomListAdapterListAbsensi(this, postsabsensi);
            listv.setAdapter(mAdapterAbsensi);

            listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub

//                    String Slecteditem=  posts.get(position).getId().toString();
//                    Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

//                    //BUKA FORM MAIN ACTIVITY
//                    Intent myIntent = new Intent(AbsensiBaru.this,AbsensiBaruEntry.class);
//                    myIntent.putExtra("user",mUser.toString());
//                    myIntent.putExtra("nopol",postsabsensi.get(position).getnopol().toString());
//                    myIntent.putExtra("supir",postsabsensi.get(position).getsupir().toString());
//                    myIntent.putExtra("status",postsabsensi.get(position).getstatus().toString());
//                    myIntent.putExtra("keterangan",postsabsensi.get(position).getketerangan().toString());
//
//                    startActivity(myIntent);
//                    //BUKA FORM MAIN ACTIVITY
                }
            });
        } catch (Exception ex) {

        }
        //AMBIL LIST TRACING
    }
}
