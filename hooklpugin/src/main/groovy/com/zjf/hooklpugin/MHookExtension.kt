package com.zjf.hooklpugin

/**
 * Create by zjf on 2022/9/28
 */
object MHookExtension {
  @JvmStatic var MHOOK_INTERFACE_PATH = "com.zjf.mhook.IMHook"
  @JvmStatic var MHOOK_INTERFACE_PATH_IMPL_ADAPTER = "com.zjf.hooklpugin.MHookClassAdapter"
  @JvmStatic var MHOOK_INTERFACE_PATH2 = "com.zjf.mhook.IDefaultNotHook"
  @JvmStatic var MHOOK_INTERFACE_PATH2_IMPL_ADAPTER = "com.zjf.mhook.DefaultNotHookAdapter"

  @JvmStatic var HOOK_CLASS = "com.zjf.mhook.MHook"
  @JvmStatic var HOOK_CLASS_PATH = "com/zjf/mhook/MHook"
  var hookInvoke = true
  val mHookSwitch : HashMap<String, Boolean> = HashMap()

}