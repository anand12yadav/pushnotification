package com.example.notificationpush;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;

public class App extends Application {
    public static final String FCM_CHANNEL_ID="FCM_CHANNEL_ID";


    //Comment this code if your os is below or 24 api
    @Override
    public void onCreate() {
        super.onCreate();
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.BASE){
            NotificationChannel fcmChannel=new NotificationChannel(FCM_CHANNEL_ID,"FCM_Channel", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.createNotificationChannel(fcmChannel);
        }

    }

}
