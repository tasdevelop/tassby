package com.gorich.admin.tastruckingsby;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Grishma on 16/5/16.
 */
public class TASService extends Service {
    public static String rslt="";

    int counter = 0;
    static final int UPDATE_INTERVAL = 10000;
    private Timer timer = new Timer();

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // We want this service to continue running until it is explicitly
        // stopped, so return sticky.
        // Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        doSomethingRepeatedly();
		/*
		 * try { new DoBackgroundTask().execute(new URL(
		 * "http://agusharyanto.net/android/dl/sylabus1.pdf"), new
		 * URL("http://agusharyanto.net/android/dl/sylabus2.pdf"), new
		 * URL("http://agusharyanto.net/android/dl/sylabus3.pdf"), new
		 * URL("http://agusharyanto.net/android/dl/hadiah.pdf")); } catch
		 * (MalformedURLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
        return START_STICKY;
    }

    private void doSomethingRepeatedly() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                Log.d("TheService Cek Data", String.valueOf(++counter));

                //GET SN DEVICE
                final String deviceId = Settings.System.getString(getContentResolver(), Settings.System.ANDROID_ID);
                //GET SN DEVICE

                //CEK KONEKSI (SAVE KE SERVER JIKA ADA KONEKSI)
                boolean connected = false;
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                        connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
                    //we are connected to a network
                    connected = true;


                    //CHECK NOTIF
                    try
                    {
                        rslt ="START";
                        Caller c=new Caller();
                        c.device= deviceId;
                        c.sCommand ="getnotif";
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

                        if (("blank".equals(rslt))) {
                            //Toast.makeText(this, "UPDATE KE SERVER",Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            startNotification(rslt);
                        }
                    }catch(Exception ex) {
                        //Toast.makeText(this, ex.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    //CHECK NOTIF
                }
                //CEK KONEKSI (SAVE KE SERVER JIKA ADA KONEKSI
            }
        }, 0, UPDATE_INTERVAL);
    }

    private void startNotification(String msg) {
        Log.i("NextActivity", "startNotification");

        // Sets an ID for the notification
//        int mNotificationId = 001;
        int mNotificationId = (int) ((new Date().getTime() / 1000L) % Integer.MAX_VALUE);

        Bitmap icon1 = BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher);

        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(
                getApplicationContext()).setAutoCancel(true)
                .setContentTitle("TAS notif")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(icon1).setContentText("TAS");

        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();
        bigText.bigText(msg);
        bigText.setBigContentTitle("TAS");
        bigText.setSummaryText("TAS notif");
        mBuilder.setStyle(bigText);
        mBuilder.setPriority(NotificationCompat.PRIORITY_MAX);

        // Create pending intent, mention the Activity which needs to be
        //triggered when user clicks on notification(StopScript.class in this case)

        PendingIntent contentIntent = PendingIntent.getActivity(this, mNotificationId,
                new Intent(this, MainActivity.class), PendingIntent.FLAG_ONE_SHOT);
//        PendingIntent.FLAG_UPDATE_CURRENT
        mBuilder.setAutoCancel(true);
        mBuilder.setContentIntent(contentIntent);
        mBuilder.setVibrate(new long[] { 1000, 1000, 1000, 1000, 1000 });
        mBuilder.setLights(Color.RED, 3000, 3000);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        mBuilder.setSound(alarmSound);
        mBuilder.setOnlyAlertOnce(true);

        // Gets an instance of the NotificationManager service
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Builds the notification and issues it.
        mNotifyMgr.notify(mNotificationId, mBuilder.build());


    }

    private int DownloadFile(URL url) {
        int file_size = 0;
        try {
            // ---simulate taking some time to download a file---
            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();
            file_size = urlConnection.getContentLength();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ---return an arbitrary number representing
        // the size of the file downloaded---
        return file_size;
    }

    private class DoBackgroundTask extends AsyncTask<URL, Integer, Long> {
        protected Long doInBackground(URL... urls) {
            int count = urls.length;
            long totalBytesDownloaded = 0;
            for (int i = 0; i < count; i++) {
                totalBytesDownloaded += DownloadFile(urls[i]);
                // ---calculate percentage downloaded and
                // report its progress---
                publishProgress((int) (((i + 1) / (float) count) * 100));
            }
            return totalBytesDownloaded;
        }

        protected void onProgressUpdate(Integer... progress) {
            Log.d("Downloading files", String.valueOf(progress[0])
                    + "% downloaded");
            Toast.makeText(getBaseContext(),
                    String.valueOf(progress[0]) + "% downloaded",
                    Toast.LENGTH_LONG).show();
        }

        protected void onPostExecute(Long result) {
            Toast.makeText(getBaseContext(), "Downloaded " + result + " bytes",
                    Toast.LENGTH_LONG).show();
            stopSelf();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
        Toast.makeText(this, "The Service Destroyed", Toast.LENGTH_LONG).show();
    }
}