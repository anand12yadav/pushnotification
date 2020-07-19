package com.example.notificationpush;

import android.app.Notification;
import android.app.NotificationManager;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import static com.example.notificationpush.App.FCM_CHANNEL_ID;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.i("Notification","New Token " +s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.i("Notification","Message received");
        if(remoteMessage.getNotification()!=null){
            String title=remoteMessage.getNotification().getTitle();
            String body=remoteMessage.getNotification().getBody();

            Notification notification=new NotificationCompat.Builder(this,FCM_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_arrow_drop)
                    .setContentTitle(title)
                    .setContentText(body)
                    .build();

            NotificationManager manager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            manager.notify(1002,notification);

        }
        if(remoteMessage.getData().size() >=0){
            Log.d("data","message received data "+remoteMessage.getData().toString());
        }
    }
}
