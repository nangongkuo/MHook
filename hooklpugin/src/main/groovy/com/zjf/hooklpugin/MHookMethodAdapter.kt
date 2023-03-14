package com.zjf.hooklpugin

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes
import org.objectweb.asm.commons.LocalVariablesSorter

/**
 * Create by zjf on 2022/9/28
 */
class MHookMethodAdapter(
  var mClassName : String?,
  var mSuperClassName : String?,
  var mAccess: Int,
  var mName: String?,
  var mDescriptor: String?,
  var mMethodVisitor: MethodVisitor?,
  var mHookExtension : MHookExtension?
) : LocalVariablesSorter(Opcodes.ASM5, mAccess, mDescriptor, mMethodVisitor), Opcodes {

  override fun visitLdcInsn(value: Any?) {
    var adress = "";
    // 因为华为里面反射访问了 TelephonyManager，所以需要过滤
    if ("android.telephony.MSimTelephonyManager" == value) {
      // 这里，为了抛出 ClassNotFoundException
      adress = "test.test.MSimTelephonyManager"
    }
    // 通过adb shell命令来获取 hook
    if ("cat /sys/class/net/wlan0/address " == value) {
      // 直接打印unknown
      adress = "echo unknown "
    }
    super.visitLdcInsn(adress)
  }

  override fun visitMethodInsn(
    opcode: Int,
    owner: String?,
    methodName: String?,
    desc: String?,
    isInterface: Boolean
  ) {
    if (isHook("getMacAddress") && "android/net/wifi/WifiInfo" == owner && "getMacAddress" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookMac", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getMeid2") && "android/telephony/TelephonyManager" == owner && "getMeid" == methodName && "(I)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookMeid", "(L$owner;I)Ljava/lang/String;", false)
      return
    }
    if (isHook("getMeid") && "android/telephony/TelephonyManager" == owner && "getMeid" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookMeid", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getDeviceId2") && "android/telephony/TelephonyManager" == owner && "getDeviceId" == methodName && "(I)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookDeviceId", "(L$owner;I)Ljava/lang/String;", false)
      return
    }
    if (isHook("getDeviceId") && "android/telephony/TelephonyManager" == owner && "getDeviceId" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookDeviceId", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getSubscriberId2") && "android/telephony/TelephonyManager" == owner && "getSubscriberId" == methodName && "(I)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookSubscriberId", "(L$owner;I)Ljava/lang/String;", false)
      return
    }
    if (isHook("getSubscriberId") && "android/telephony/TelephonyManager" == owner && "getSubscriberId" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookSubscriberId", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getImei2") && "android/telephony/TelephonyManager" == owner && "getImei" == methodName && "(I)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookImei", "(L$owner;I)Ljava/lang/String;", false)
      return
    }
    if (isHook("getImei") && "android/telephony/TelephonyManager" == owner && "getImei" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookImei", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getSimSerialNumber2") && "android/telephony/TelephonyManager" == owner && "getSimSerialNumber" == methodName && "(I)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookSimSerialNumber", "(L$owner;I)Ljava/lang/String;", false)
      return
    }
    if (isHook("getSimSerialNumber") && "android/telephony/TelephonyManager" == owner && "getSimSerialNumber" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookSimSerialNumber", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getLineNumber2") && "android/telephony/TelephonyManager" == owner && "getMHookLineNumber" == methodName && "(I)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookLineNumber", "(L$owner;I)Ljava/lang/String;", false)
      return
    }
    if (isHook("getLineNumber") && "android/telephony/TelephonyManager" == owner && "getMHookLineNumber" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookLineNumber", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    //java.net.NetworkInterface.getHardwareAddress
    if (isHook("getHardwareAddress") && "java/net/NetworkInterface" == owner && "getHardwareAddress" == methodName && "()[B" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookHardwareAddress", "(L$owner;)[B", false)
      return
    }
    //android.bluetooth.BluetoothAdapter.getAddress
    if (isHook("getAddress") && "android/bluetooth/BluetoothAdapter" == owner && "getAddress" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookBluetoothAddress", "(L$owner;)Ljava/lang/String;", false)
      return
    }
    if (isHook("getSecureString") && "android/provider/Settings\$Secure" == owner && "getString" == methodName && "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookSecureString", desc, false)
      return
    }
    if (isHook("getString") && "android/provider/Settings\$System" == owner && "getString" == methodName && "(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookString", desc, false)
      return
    }
    //methodVisitor.visitMethodInsn(INVOKESTATIC, "com/quvideo/mobile/platform/machook/MacHook", "getMHookInetHostAddress", "(Ljava/lang/String;)Ljava/lang/String;", false);
    if (isHook("getHostAddress") && "java/net/InetAddress" == owner && "getHostAddress" == methodName && "()Ljava/lang/String;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookInetHostAddress", "(L$owner;)Ljava/lang/String;", false)
      return
    }

    if (isHook("getRunningAppProcesses") && "android/app/ActivityManager" == owner && "getRunningAppProcesses" == methodName && "()Ljava/util/List;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookRunningAppProcesses", "(L$owner;)Ljava/util/List;", false)
      return
    }
    if (isHook("isEmulator") && "com/google/firebase/crashlytics/internal/common/CommonUtils" == owner && "isEmulator" == methodName && "(Landroid/content/Context;)Z" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "isMHookEmulator", desc, false)
      return
    }
    //methodVisitor.visitMethodInsn(INVOKESTATIC, "com/quvideo/mobile/platform/machook/MacHook", "getMHookInetHostAddress", "(Ljava/lang/String;)Ljava/lang/String;", false);
    if (isHook("query") && "android/content/ContentResolver" == owner && "query" == methodName && "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "contentMHookResolverQuery", "(L$owner;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", false)
      return
    }
    //methodVisitor.visitMethodInsn(INVOKESTATIC, "android/provider/ContactsContract$Contacts", "openContactPhotoInputStream", "(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;", false);
    if (isHook("openContactPhotoInputStream") && "android/provider/ContactsContract\$Contacts" == owner && "openContactPhotoInputStream" == methodName && "(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "openMHookContactPhotoInputStream", "(Landroid/content/ContentResolver;Landroid/net/Uri;)Ljava/io/InputStream;", false)
      return
    }
    //"android/provider/ContactsContract$Contacts", "openContactPhotoInputStream", "(Landroid/content/ContentResolver;Landroid/net/Uri;Z)Ljava/io/InputStream;"
    if (isHook("openContactPhotoInputStream2") && "android/provider/ContactsContract\$Contacts" == owner && "openContactPhotoInputStream" == methodName && "(Landroid/content/ContentResolver;Landroid/net/Uri;Z)Ljava/io/InputStream;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "openMHookContactPhotoInputStream", "(Landroid/content/ContentResolver;Landroid/net/Uri;Z)Ljava/io/InputStream;", false)
      return
    }
    if (isHook("getAdvertisingIdInfo") && "com/google/android/gms/ads/identifier/AdvertisingIdClient" == owner && "getAdvertisingIdInfo" == methodName && "(Landroid/content/Context;)Lcom/google/android/gms/ads/identifier/AdvertisingIdClient\$Info;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookAdvertisingIdInfo", desc, false)
      return
    }
    if (isHook("logE") && "android/util/Log" == owner && "e" == methodName && "(Ljava/lang/String;Ljava/lang/String;)I" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookLogE", desc, false)
      return
    }
    if (isHook("pendingGetActivity") && "android/app/PendingIntent" == owner && "getActivity" == methodName) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookPendingGetActivity", desc, false)
      return
    }
    if (isHook("pendingGetActivities") && "android/app/PendingIntent" == owner && "getActivities" == methodName) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookPendingGetActivities", desc, false)
      return
    }
    if (isHook("pendingGetBroadcast") && "android/app/PendingIntent" == owner && "getBroadcast" == methodName) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookPendingGetBroadcast", desc, false)
      return
    }
    if (isHook("pendingGetService") && "android/app/PendingIntent" == owner && "getService" == methodName) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookPendingGetService", desc, false)
      return
    }
    if (isHook("pendingGetForegroundService") && "android/app/PendingIntent" == owner && "getForegroundService" == methodName) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookPendingGetForegroundService", desc, false)
      return
    }
    if (isHook("getInstalledPackages") && "android/content/pm/PackageManager" == owner && "getInstalledPackages" == methodName && "(I)Ljava/util/List;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookInstalledApp", "(L$owner;I)Ljava/util/List;", false)
      return
    }
    if (isHook("getPackageInfo") && "android/content/pm/PackageManager" == owner && "getPackageInfo" == methodName && "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;" == desc) {
      mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "getMHookPackageInfo", "(L$owner;Ljava/lang/String;I)Landroid/content/pm/PackageInfo;", false)
      return
    }

    if (mHookExtension?.hookInvoke == true) {
      // hook 反射方法
      // methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/reflect/Method", "invoke", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false);
      if (opcode == Opcodes.INVOKEVIRTUAL && "java/lang/reflect/Method" == owner && "invoke" == methodName && "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;" == desc) {
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, MHookExtension.HOOK_CLASS_PATH, "mHookInvoke", "(L$owner;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", false)
        return
      }
    }
    super.visitMethodInsn(opcode, owner, methodName, desc, isInterface)
  }

  private fun isHook(key: String): Boolean {
    return mHookExtension?.mHookSwitch?.get(key) ?: false
  }


}