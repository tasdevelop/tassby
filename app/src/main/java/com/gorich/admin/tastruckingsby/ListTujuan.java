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

public class ListTujuan extends AppCompatActivity {

    public static String rslt="";
    private CustomListAdapterTujuan mAdapterTujuanList;
    ListView listv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tujuan);

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        final String nUser = getIntent().getExtras().getString("user", "user");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");
        listv=(ListView)findViewById(R.id.list);

        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (("1".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTujuan.this,MainMenuMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else if (("2".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTujuan.this,MainMenuNonMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTujuan.this,MainMenu.class);
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
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");
        //AMBIL LIST TRACING
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

            Gson gson = new Gson();
            BlogTujuanList BlogTujuanList = gson.fromJson(rslt, BlogTujuanList.class);

            final List<PostTujuanList> poststujuan = BlogTujuanList.getPoststujuan();
            mAdapterTujuanList = new CustomListAdapterTujuan(this, poststujuan);
            listv.setAdapter(mAdapterTujuanList);

            listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub

//                    String Slecteditem=  posts.get(position).getId().toString();
//                    Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTujuan.this,TripBaru.class);
//                    myIntent.putExtra("user",mUser.toString());
//                    myIntent.putExtra("nobukti",postsabsensi.get(position).getfntrans().toString());
//                    myIntent.putExtra("mandor",nMandor.toString());

                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
            });
        } catch (Exception ex) {

        }
        //AMBIL LIST TRACING
    }
}
