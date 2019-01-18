package org.pursuit.Notification_App_HW_LUCAS_EVELYN;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    public static final String SHARED_PREFS_KEY = "tolkien_call";
    public static final String STRING_KEY = "string key";
    public static final String BOOLEAN_KEY = "boolean key";
    private static final int NOTIFICATION_ID = 0;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";

    private SharedPreferences sharedPreferences;
    private TextView textViewTitle;
    private TextView textViewMessage;
    private ImageView imageView;
    private Button notificationButton;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        createNotificationChannel();
        findViewsById();

        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE);

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.equals(sharedPreferences.getString(STRING_KEY, "demon")) && sharedPreferences.getBoolean(BOOLEAN_KEY, false)) {
                    Toast.makeText(SecondActivity.this, "You already clicked this notification!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent notifyIntent = new Intent(getApplicationContext(), MainActivity.class);
                    notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, notifyIntent, 0);

                    NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), PRIMARY_CHANNEL_ID)
                            .setSmallIcon(R.drawable.ic_mountain)
                            .setContentTitle("Tolkien")
                            .setContentText("One App to rule them all.")
                            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                            .setContentIntent(pendingIntent)
                            .setAutoCancel(true);

                    NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                    notificationManagerCompat.notify(NOTIFICATION_ID, builder.build());

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(STRING_KEY, name);
                    editor.putBoolean(BOOLEAN_KEY, true);
                    editor.commit();
                }
            }

        });

    }

    private void findViewsById() {
        notificationButton = findViewById(R.id.button_notification);
        textViewTitle = findViewById(R.id.text_view_second_title);
        textViewMessage = findViewById(R.id.text_view_second_message);
        imageView = findViewById(R.id.image_view_second);
        Intent intent = getIntent();

        textViewTitle.setText(intent.getStringExtra("name"));
        name = intent.getStringExtra("name");
        textViewMessage.setText(intent.getStringExtra("message"));
        imageView.setImageResource(intent.getIntExtra("image", 0));
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "ChannelName";
            String description = "ChannelDescription";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(PRIMARY_CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
