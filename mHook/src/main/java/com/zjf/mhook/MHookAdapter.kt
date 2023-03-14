package com.zjf.mhook

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo
import android.bluetooth.BluetoothAdapter
import android.content.ContentResolver
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.net.wifi.WifiInfo
import android.telephony.TelephonyManager
import java.io.InputStream
import java.net.NetworkInterface

/**
 * Create by zjf on 2022/9/28
 */
class MHookAdapter : IMHook {
  override fun getMHookMac(wifiInfo: WifiInfo?): String? {
    return null
  }

  override fun getMHookDeviceId(telephonyManager: TelephonyManager?): String? {
    return null
  }

  override fun getMHookDeviceId(telephonyManager: TelephonyManager?, i: Int): String? {
    return null
  }

  override fun getMHookSubscriberId(telephonyManager: TelephonyManager?): String? {
    return null
  }

  override fun getMHookSubscriberId(telephonyManager: TelephonyManager?, i: Int): String? {
    return null
  }

  override fun getMHookImei(telephonyManager: TelephonyManager?): String? {
    return null
  }

  override fun getMHookImei(telephonyManager: TelephonyManager?, i: Int): String? {
    return null
  }

  override fun getMHookMeid(telephonyManager: TelephonyManager?): String? {
    return null
  }

  override fun getMHookMeid(telephonyManager: TelephonyManager?, i: Int): String? {
    return null
  }

  override fun mHookContentResolverQuery(
    contentResolver: ContentResolver?,
    uri: Uri?,
    projection: Array<String?>?,
    selection: String?,
    selectionArgs: Array<String?>?,
    sortOrder: String?
  ): Cursor? {
    return null
  }

  override fun getMHookLineNumber(telephonyManager: TelephonyManager?): String? {
    return null
  }

  override fun getMHookLineNumber(telephonyManager: TelephonyManager?, i: Int): String? {
    return null
  }

  override fun getMHookSimSerialNumber(telephonyManager: TelephonyManager?): String? {
    return null
  }

  override fun getMHookSimSerialNumber(telephonyManager: TelephonyManager?, i: Int): String? {
    return null
  }

  override fun getMHookSecureString(contentResolver: ContentResolver?, type: String?): String? {
    return null
  }

  override fun getMHookString(contentResolver: ContentResolver?, type: String?): String? {
    return null
  }

  override fun getMHookHardwareAddress(networkInterface: NetworkInterface?): ByteArray? {
    return null
  }

  override fun getMHookBluetoothAddress(bluetoothAdapter: BluetoothAdapter?): String? {
    return null
  }

  override fun openMHookContactPhotoInputStream(
    cr: ContentResolver?,
    contactUri: Uri?,
    preferHighres: Boolean
  ): InputStream? {
    return null
  }

  override fun getMHookRunningAppProcesses(am: ActivityManager?): List<RunningAppProcessInfo?>? {
    return null
  }

  override fun mHookLogE(tag: String?, msg: String?): Int {
    return 0
  }

  override fun getMHookInstalledApp(pm: PackageManager?, value: Int): List<PackageInfo?>? {
    return emptyList<PackageInfo>()
  }

  override fun getMHookPackageInfo(pm: PackageManager?, name: String?, value: Int): PackageInfo? {
    return null
  }

}