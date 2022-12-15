package project.st991571169st991571540.gursikhpeter

import android.app.Notification
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat


const val notificationId = 1;
const val channelId = "dietchannel";
const val titleExtra = "titleExtra";
const val messageExtra = "messageExtra";


class DietNotification : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val notification: Notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.journal)
            .setContentTitle(intent.getStringExtra(titleExtra))
            .setContentText(intent.getStringExtra(messageExtra))
            .build()

        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(notificationId, notification)
    }
}