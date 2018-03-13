package notification.itheima.com.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.send_notice:
                        Intent intent = new Intent(MainActivity.this,NotificationActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(MainActivity.this,0,intent,0);
                        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        NotificationCompat.Builder notification = new NotificationCompat.Builder(MainActivity.this)
                                .setContentTitle("This is content title")
                                .setContentText("This is content text")
                                .setWhen(System.currentTimeMillis())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                                .setContentIntent(pi)
                                .setSound(Uri.fromFile(new File("system/media/audio/ringtones/Lyra.ogg")))
                                .setVibrate(new long[]{0,1000,1000,1000})
                                .setLights(Color.GREEN,1000,1000)
//                                .setDefaults(NotificationCompat.DEFAULT_ALL)//默认效果
                                .setAutoCancel(true);
                        manager.notify(1,notification.build());
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
