package lincyu.homework4r;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BR_Notification extends BroadcastReceiver {

	static int id = 70000;

	@Override
	public void onReceive(Context context, Intent intent) {

		String name = intent.getStringExtra("KEY_NAME");

		Intent newintent = new Intent();
		newintent = intent;
		newintent.setClass(context, GreetingActivity.class);

		PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, newintent, PendingIntent.FLAG_CANCEL_CURRENT);

		Notification notify =  null;
		//notify.flags=Notification.FLAG_AUTO_CANCEL;

		notify = newNotification(context, pendingIntent,
				"(New) Broadcast is received.", name);

		NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);

		notificationManager.notify(id, notify);
	}

	@SuppressWarnings("deprecation")
	private Notification oldNotification(
			Context context, PendingIntent pi,
			String title, String msg) {

		Notification notify = new Notification(
				R.mipmap.ic_launcher, title,
				System.currentTimeMillis());
		return notify;
	}

	@SuppressLint("NewApi")
	private Notification newNotification(
			Context context, PendingIntent pi,
			String title, String msg) {

		Notification.Builder builder =
				new Notification.Builder(context);

		builder.setContentTitle("Hello");
		builder.setContentText(msg);
		builder.setSmallIcon(R.mipmap.ic_launcher);
		builder.setContentIntent(pi);
		builder.setTicker(msg);
		builder.setWhen(System.currentTimeMillis());
		Notification notify = builder.build();
		return notify;
	}
}
