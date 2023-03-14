package com.zjf.mhook

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import java.io.IOException

/**
 * Create by zhengjunfei on 2023/3/14
 */
interface IDefaultNotHook {

  fun isHackEmulator(context: Context?): Boolean

  @Throws(
    IOException::class,
    IllegalStateException::class,
    GooglePlayServicesNotAvailableException::class,
    GooglePlayServicesRepairableException::class
  ) fun getHackAdvertisingIdInfo(context: Context?): AdvertisingIdClient.Info?

  fun mHookPendingGetActivity(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent?

  fun mHookPendingGetActivity(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int,
    options: Bundle?
  ): PendingIntent?

  fun mHookPendingGetActivities(
    context: Context?,
    requestCode: Int,
    intents: Array<Intent?>?,
    flags: Int
  ): PendingIntent?

  fun mHookPendingGetActivities(
    context: Context?,
    requestCode: Int,
    intents: Array<Intent?>?,
    flags: Int,
    options: Bundle?
  ): PendingIntent?

  //PendingIntent mHookPendingGetActivitiesAsUser(Context context, int requestCode, Intent[] intents, int flags, Bundle options, UserHandle user);
  fun mHookPendingGetBroadcast(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent?

  //PendingIntent mHookPendingGetBroadcastAsUser(Context context, int requestCode, Intent intent, int flags, UserHandle userHandle);
  fun mHookPendingGetService(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent?

  fun mHookPendingGetForegroundService(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent?


}