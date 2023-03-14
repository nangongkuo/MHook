package com.zjf.mhook

import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import java.lang.reflect.Method

/**
 * Create by zhengjunfei on 2022/9/28
 */
object MHook {
  private var mIMHook : IMHook? = null

  fun setIMHook(mHook: IMHook?){
    this.mIMHook = mHook
  }
  fun mHookContentResolverQuery(
    contentResolver: ContentResolver?, uri: Uri?,
    projection: Array<String?>?, selection: String?,
    selectionArgs: Array<String?>?, sortOrder: String?
  ): Cursor? {
    return mIMHook?.mHookContentResolverQuery(contentResolver, uri, projection, selection, selectionArgs, sortOrder)
  }

  @JvmStatic
  fun mInvoke(method: Method?, `object`: Any?, vararg params: Any?): Any? {
    if (`object` is ContentResolver) {
      if ("query" == method!!.name && params.size == 5 && params[0] is Uri
        && (params[1] is Array<*> || params[1] == null)
        && (params[2] is String || params[2] == null)
        && (params[3] is Array<*> || params[3] == null)
        && (params[4] is String || params[4] == null)
      ) {
        return mHookContentResolverQuery(
          `object` as ContentResolver?,
          params[0] as Uri?,
          params[1] as Array<String?>?,
          params[2] as String?,
          params[3] as Array<String?>?,
          params[4] as String?
        )
      }
    }

    return null
  }





}