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
open interface IMHook {

  fun getMHookMac(wifiInfo: WifiInfo?): String?

  fun getMHookDeviceId(telephonyManager: TelephonyManager?): String?
  fun getMHookDeviceId(telephonyManager: TelephonyManager?, i : Int): String?

  fun getMHookSubscriberId(telephonyManager: TelephonyManager?): String?
  fun getMHookSubscriberId(telephonyManager: TelephonyManager?, i : Int): String?

  fun getMHookImei(telephonyManager: TelephonyManager?): String?
  fun getMHookImei(telephonyManager: TelephonyManager?, i: Int): String?

  fun getMHookMeid(telephonyManager: TelephonyManager?): String?
  fun getMHookMeid(telephonyManager: TelephonyManager?, i: Int): String?


  fun mHookContentResolverQuery(
    contentResolver: ContentResolver?,
    uri: Uri?,
    projection: Array<String?>?,
    selection: String?,
    selectionArgs: Array<String?>?,
    sortOrder: String?
  ): Cursor?

  fun getMHookLineNumber(telephonyManager: TelephonyManager?): String?
  fun getMHookLineNumber(telephonyManager: TelephonyManager?, i: Int): String?

  fun getMHookSimSerialNumber(telephonyManager: TelephonyManager?): String?
  fun getMHookSimSerialNumber(telephonyManager: TelephonyManager?, i: Int): String?

  fun getMHookSecureString(contentResolver: ContentResolver?, type: String?): String?
  fun getMHookString(contentResolver: ContentResolver?, type: String?): String?

  fun getMHookHardwareAddress(networkInterface: NetworkInterface?): ByteArray?

  fun getMHookBluetoothAddress(bluetoothAdapter: BluetoothAdapter?): String?

  fun openMHookContactPhotoInputStream(
    cr: ContentResolver?,
    contactUri: Uri?,
    preferHighres: Boolean
  ): InputStream?

  fun getMHookRunningAppProcesses(am: ActivityManager?): List<RunningAppProcessInfo?>?

  fun mHookLogE(tag: String?, msg: String?): Int

  fun getMHookInstalledApp(pm: PackageManager?, value: Int): List<PackageInfo?>?

  fun getMHookPackageInfo(pm: PackageManager?, name: String?, value: Int): PackageInfo?


}