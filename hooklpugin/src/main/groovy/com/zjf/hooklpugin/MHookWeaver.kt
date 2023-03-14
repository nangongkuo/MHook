package com.zjf.hooklpugin

import com.quinn.hunter.transform.asm.BaseWeaver
import org.objectweb.asm.ClassVisitor
import org.objectweb.asm.ClassWriter

/**
 * Create by zjf on 2022/9/28
 */
class MHookWeaver constructor(var mHookExtensions : MHookExtension?) : BaseWeaver() {

  /**
   * @param fullQualifiedClassName class的全限定名
   * 是否要访问这个 class 文件
   */
  override fun isWeavableClass(fullQualifiedClassName: String?): Boolean {
    return super.isWeavableClass(fullQualifiedClassName)
  }

  override fun wrapClassWriter(classWriter: ClassWriter?): ClassVisitor {
    return MHookClassAdapter(classWriter, mHookExtensions)
  }

}