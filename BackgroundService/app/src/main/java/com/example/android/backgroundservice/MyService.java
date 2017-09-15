package com.example.android.backgroundservice;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by Sony on 15-09-2017.
 */

public class MyService extends Service {
    //creating a mediaplayer object


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        /*player = MediaPlayer.create(this,
                Settings.System.DEFAULT_RINGTONE_URI);
        //setting loop play to true
        //this will make the ringtone continuously playing
        player.setLooping(true);

        //staring the player
        player.start();*/

        Log.i("Service xyz","Service xyz");


        /*----------------------------Notification--------------------------------- */

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.sample)
                        .setContentTitle("Notifications Example")
                        .setContentText("This is a test notification");

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

        /*---------------------------------------------------------------------------*/




        /*-------------------------------------Restart Service-----------------*/

        Intent restartService = new Intent(getApplicationContext(),
                this.getClass());
        restartService.setPackage(getPackageName());
        PendingIntent restartServicePI = PendingIntent.getService(
                getApplicationContext(), 1, restartService,
                PendingIntent.FLAG_ONE_SHOT);

        //Restart the service once it has been killed android


        AlarmManager alarmService = (AlarmManager)getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        alarmService.set(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime() +100, restartServicePI);


    /*----------------------------------------------------------------------------*/

        //we have some options for service
        //start sticky means service will be explicity started and stopped
        return START_STICKY;
    }





    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed

    }
    @Override
    public void onTaskRemoved(Intent rootIntent) {
        // TODO Auto-generated method stub


    }
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();

        //start a separate thread and start listening to your network object
    }
}