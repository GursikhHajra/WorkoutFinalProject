package project.st991571169st991571540.gursikhpeter

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import project.st991571169st991571540.gursikhpeter.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        @Suppress("UNUSED_VARIABLE")
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        createNotificationChannel()
        scheduleNotification()
    }

    private fun scheduleNotification()
    {
        val intent = Intent(applicationContext, DietNotification::class.java)
        val title = "Diet Journal";
        val notificationlist = arrayOf(
            "Keep working at it, you're getting better everyday!",
            "Remember to log your daily meals",
            "Fact: A diet journal helps people live healthier",
            "Studies show a 'cheat meal' helps people keep on diets!",
            "Dont give up. Another day is another win",

        )
        val message = notificationlist.get((notificationlist.indices).shuffled().last())
        intent.putExtra(titleExtra,title)
        intent.putExtra(messageExtra,message)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            notificationId,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        val fiveminutes = 60000L * 5;
        alarmManager.setInexactRepeating(
            AlarmManager.RTC_WAKEUP,
            System.currentTimeMillis() + fiveminutes,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )


    }




    private fun createNotificationChannel()
    {
        val name = "Diet Notification Channel";
        val description = "The channel for diet journal notifications to use";
        val importance = NotificationManager.IMPORTANCE_DEFAULT;
        val channel = NotificationChannel(channelId,name, importance)
        channel.description = description;
        val notifmanager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notifmanager.createNotificationChannel(channel);
    }
}