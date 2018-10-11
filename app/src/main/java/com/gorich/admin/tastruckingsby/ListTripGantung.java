package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

public class ListTripGantung extends AppCompatActivity {
    public static String rslt="";
    private CustomListAdapterList mAdapter;
    ListView listv;
    TextView jlhtrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_trip_gantung);


        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        final String nUser = getIntent().getExtras().getString("user", "user");
        final String nMandor = getIntent().getExtras().getString("mandor", "mandor");
        listv=(ListView)findViewById(R.id.list);
        jlhtrip=(TextView)findViewById(R.id.txtjlhtrip);

        Button bt_cancel=(Button)findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //BUKA FORM MAIN ACTIVITY
//                Intent myIntent = new Intent(ListTrip.this,MainMenu.class);
//                myIntent.putExtra("user",nUser.toString());
//                startActivity(myIntent);
//                //BUKA FORM MAIN ACTIVITY
                if (("1".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTripGantung.this,MainMenuMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else if (("2".equals(nMandor.toString())))
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTripGantung.this,MainMenuNonMandor.class);
                    myIntent.putExtra("user",nUser.toString());
                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
                else
                {
                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTripGantung.this,MainMenu.class);
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
            c.sCommand = "getlistgantung";
            c.join();
            c.start();
            while (rslt == "START") {
                try {
                    Thread.sleep(10);

                } catch (Exception ex) {

                }
            }

            Gson gson = new Gson();
            Blog Blog = gson.fromJson(rslt, Blog.class);

            final List<Post> posts = Blog.getPosts();
            mAdapter = new CustomListAdapterList(this, posts);
            listv.setAdapter(mAdapter);

            jlhtrip.setText(String.valueOf(Blog.getCount()));

            listv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // TODO Auto-generated method stub

//                    String Slecteditem=  posts.get(position).getId().toString();
//                    Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

                    //BUKA FORM MAIN ACTIVITY
                    Intent myIntent = new Intent(ListTripGantung.this,DetailTripGantung.class);
                    myIntent.putExtra("user",mUser.toString());
                    myIntent.putExtra("nobukti",posts.get(position).getnobukti().toString());
                    myIntent.putExtra("emkl",posts.get(position).getemkl().toString());
                    myIntent.putExtra("tujuantarif",posts.get(position).gettujuantarif().toString());
                    myIntent.putExtra("nopol",posts.get(position).getnopol().toString());
                    myIntent.putExtra("dari",posts.get(position).getdari().toString());
                    myIntent.putExtra("sampai",posts.get(position).getsampai().toString());
                    myIntent.putExtra("jenisorderan",posts.get(position).getjenisorderan().toString());
                    myIntent.putExtra("ukurancont",posts.get(position).getukurancont().toString());
                    myIntent.putExtra("statuscont",posts.get(position).getstatuscont().toString());
                    myIntent.putExtra("nochasis",posts.get(position).getnochasis().toString());
                    myIntent.putExtra("mandor",nMandor.toString());

                    startActivity(myIntent);
                    //BUKA FORM MAIN ACTIVITY
                }
            });
        } catch (Exception ex) {

        }
        //AMBIL LIST TRACING
    }
}
