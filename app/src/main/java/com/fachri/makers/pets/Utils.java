package com.fachri.makers.pets;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by fachrifebrian on 2/2/17.
 */

public class Utils {

    public static void showNotification(Context context, String title, String description) {
//        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE);
        Uri soundUri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/bell");

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_add_pet)
                        .setContentTitle(title)
                        .setContentText(description)
                        .setVibrate(new long[]{0, 100, 200, 300})
                        .setSound(soundUri, RingtoneManager.TYPE_NOTIFICATION);
//                        .setSound(soundUri);

        Intent notificationIntent = new Intent(context, CatalogActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

    public static String isGender(Context context, int selection) {
        String mGender;
        if (selection == PetContract.PetEntry.GENDER_MALE) {
            mGender = context.getString(R.string.gender_male);
        } else if (selection == PetContract.PetEntry.GENDER_FEMALE) {
            mGender = context.getString(R.string.gender_female);
        } else {
            mGender = context.getString(R.string.gender_unknown);
        }
        return mGender;
    }
}
