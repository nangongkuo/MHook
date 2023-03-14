package com.zjf.hooklpugin

import android.text.TextUtils
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * Create by zjf on 2022/9/28
 */
class MHookClassAdapter constructor(var mClassVisitor: ClassVisitor?, var mHookExtension : MHookExtension?) : ClassVisitor(Opcodes.ASM6, mClassVisitor) {

  private var MHOOK_CLASS = ""

  private var mClassName : String? = null
  private var mSuperClassName : String? = null
  private var mNeedIntercept = false

  override fun visit(
    version: Int,
    access: Int,
    name: String?,
    signature: String?,
    superName: String?,
    interfaces: Array<out String>?
  ) {
    super.visit(version, access, name, signature, superName, interfaces)
    if(!TextUtils.isEmpty(name)){
      this.mClassName = name?.replace("/", ".")
    }
    if(!TextUtils.isEmpty(superName)){
      this.mSuperClassName = superName?.replace("/", ".")
    }

    // 自己需要的自定义类型的接口过滤掉，避免问题
    mNeedIntercept = false
    if(null != interfaces){
      for(itemFace : String? in interfaces!!){
        if(MHookExtension.MHOOK_INTERFACE_PATH == itemFace?.replace("/", ".") ||
          MHookExtension.MHOOK_INTERFACE_PATH2 == itemFace?.replace("/", ".")){
          mNeedIntercept = true
          break
        }
      }
    }

    if(MHookExtension.MHOOK_INTERFACE_PATH_IMPL_ADAPTER == mClassName || MHookExtension.MHOOK_INTERFACE_PATH_IMPL_ADAPTER == mSuperClassName
      || MHookExtension.MHOOK_INTERFACE_PATH2_IMPL_ADAPTER == mClassName || MHookExtension.MHOOK_INTERFACE_PATH2_IMPL_ADAPTER == mSuperClassName){
      mNeedIntercept = true
    }

    if(MHOOK_CLASS == mClassName){
      mNeedIntercept = true
    }
  }

  override fun visitMethod(
    access: Int,
    name: String?,
    descriptor: String?,
    signature: String?,
    exceptions: Array<out String>?
  ): MethodVisitor? {
    if(mNeedIntercept){
      return super.visitMethod(access, name, descriptor, signature, exceptions)
    }
    val methodVisitor = cv.visitMethod(access, name, descriptor, signature, exceptions)
    return if(null == methodVisitor) null else MHookMethodAdapter(mClassName, mSuperClassName, access, name, descriptor, methodVisitor, mHookExtension)
  }



}