package com.zjf.mhook

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info

/**
 * Create by zhengjunfei on 2023/3/14
 */
class DefaultNotHookAdapter : IDefaultNotHook {
  override fun isHackEmulator(context: Context?): Boolean {
    return Build.PRODUCT.contains("sdk") || Build.HARDWARE.contains("goldfish")
  }

  override fun getHackAdvertisingIdInfo(context: Context?): Info? {
    return AdvertisingIdClient.getAdvertisingIdInfo(context)
  }

  override fun mHookPendingGetActivity(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent? {
    return PendingIntent.getActivity(context, requestCode, intent, getPendingIntentFlag(flags))
  }

  override fun mHookPendingGetActivity(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int,
    options: Bundle?
  ): PendingIntent? {
    return PendingIntent.getActivity(
      context, requestCode,
      intent!!, getPendingIntentFlag(flags), options
    )
  }

  override fun mHookPendingGetActivities(
    context: Context?,
    requestCode: Int,
    intents: Array<Intent?>?,
    flags: Int
  ): PendingIntent? {
    return PendingIntent.getActivities(context, requestCode, intents!!, getPendingIntentFlag(flags))
  }

  override fun mHookPendingGetActivities(
    context: Context?,
    requestCode: Int,
    intents: Array<Intent?>?,
    flags: Int,
    options: Bundle?
  ): PendingIntent? {
    return PendingIntent.getActivities(
      context, requestCode,
      intents!!, getPendingIntentFlag(flags), options
    )
  }

  override fun mHookPendingGetBroadcast(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent? {
    return PendingIntent.getBroadcast(context, requestCode, intent!!, getPendingIntentFlag(flags))
  }

  override fun mHookPendingGetService(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent? {
    return PendingIntent.getService(context, requestCode, intent!!, getPendingIntentFlag(flags))
  }

  override fun mHookPendingGetForegroundService(
    context: Context?,
    requestCode: Int,
    intent: Intent?,
    flags: Int
  ): PendingIntent? {
    return PendingIntent.getForegroundService(
      context, requestCode,
      intent!!, getPendingIntentFlag(flags)
    )
  }

  private fun getPendingIntentFlag(flag: Int): Int {
    return if (VERSION.SDK_INT > VERSION_CODES.R) {
      PendingIntent.FLAG_IMMUTABLE
    } else {
      flag
    }
  }
}