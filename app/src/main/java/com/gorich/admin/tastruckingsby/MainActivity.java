package com.gorich.admin.tastruckingsby;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static String rslt="";
    protected TextView mUserTV;
    protected TextView mPasswordTV;
    protected CheckBox mRememberMe;

    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TAMPIL ICON
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //TAMPIL ICON

        mUserTV = (TextView) findViewById((R.id.user));
        mPasswordTV = (TextView) findViewById((R.id.pass));
        mRememberMe = (CheckBox) findViewById((R.id.chkremember));
        final AlertDialog ad=new AlertDialog.Builder(this).create();

        //Cek Preferences
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        startService(new Intent(getBaseContext(), TASService.class));

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            mUserTV.setText(loginPreferences.getString("username", ""));
            mPasswordTV.setText(loginPreferences.getString("password", ""));
            mRememberMe.setChecked(true);
        }
        //Cek Preferences

        Button bt_login=(Button)findViewById(R.id.bt_login);
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try
                {
                    //GET SN DEVICE
                    final String deviceId = Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID);
                    //GET SN DEVICE

                    rslt="START";
                    Caller c=new Caller();
                    c.user= mUserTV.getText().toString();
                    c.password= mPasswordTV.getText().toString();
                    c.status= "START";
                    c.device= deviceId;

                    c.sCommand ="login";
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

                    if (("1".equals(rslt)))
                    {
                        //BUKA FORM MAIN ACTIVITY
                        Intent myIntent = new Intent(MainActivity.this,MainMenuMandor.class);
                        myIntent.putExtra("user",mUserTV.getText().toString() );
                        startActivity(myIntent);
                        //BUKA FORM MAIN ACTIVITY

                        //SIMPAN DI PREFERENCES
                        if (mRememberMe.isChecked()) {
                            loginPrefsEditor.putBoolean("saveLogin", true);
                            loginPrefsEditor.putString("username", mUserTV.getText().toString());
                            loginPrefsEditor.putString("password", mPasswordTV.getText().toString());
                            loginPrefsEditor.commit();
                        } else {
                            loginPrefsEditor.clear();
                            loginPrefsEditor.commit();
                        }
                        //SIMPAN DI PREFERENCES
                    }
                    else if (("2".equals(rslt)))
                    {
                        //BUKA FORM MAIN ACTIVITY
                        Intent myIntent = new Intent(MainActivity.this,MainMenuNonMandor.class);
                        myIntent.putExtra("user",mUserTV.getText().toString() );
                        startActivity(myIntent);
                        //BUKA FORM MAIN ACTIVITY

                        //SIMPAN DI PREFERENCES
                        if (mRememberMe.isChecked()) {
                            loginPrefsEditor.putBoolean("saveLogin", true);
                            loginPrefsEditor.putString("username", mUserTV.getText().toString());
                            loginPrefsEditor.putString("password", mPasswordTV.getText().toString());
                            loginPrefsEditor.commit();
                        } else {
                            loginPrefsEditor.clear();
                            loginPrefsEditor.commit();
                        }
                        //SIMPAN DI PREFERENCES
                    }
                    else if (("3".equals(rslt)))
                    {
                        //BUKA FORM MAIN ACTIVITY
                        Intent myIntent = new Intent(MainActivity.this,MainMenu.class);
                        myIntent.putExtra("user",mUserTV.getText().toString() );
                        startActivity(myIntent);
                        //BUKA FORM MAIN ACTIVITY

                        //SIMPAN DI PREFERENCES
                        if (mRememberMe.isChecked()) {
                            loginPrefsEditor.putBoolean("saveLogin", true);
                            loginPrefsEditor.putString("username", mUserTV.getText().toString());
                            loginPrefsEditor.putString("password", mPasswordTV.getText().toString());
                            loginPrefsEditor.commit();
                        } else {
                            loginPrefsEditor.clear();
                            loginPrefsEditor.commit();
                        }
                        //SIMPAN DI PREFERENCES
                    }
                    else
                    {
                        ad.setTitle("INFO");
                        ad.setMessage(rslt + " - User/Password salah!");
                        ad.show();
                    }

                }catch(Exception ex) {

                }
            }
        });

        Button bt_exit=(Button)findViewById(R.id.bt_exit);
        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        Button bt_lupapassword=(Button)findViewById(R.id.bt_lupapassword);
        bt_lupapassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //BUKA FORM MAIN ACTIVITY
                Intent myIntent = new Intent(MainActivity.this,LupaPassword.class);
                myIntent.putExtra("user","");
                startActivity(myIntent);
                //BUKA FORM MAIN ACTIVITY
            }
        });
    }
}
