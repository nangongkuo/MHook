package com.zjf.hooklpugin

import com.android.build.api.transform.Context
import com.android.build.api.transform.TransformInput
import com.android.build.api.transform.TransformOutputProvider
import com.quinn.hunter.transform.HunterTransform
import org.gradle.api.Project

/**
 * Create by zjf on 2022/9/28
 */
class MHookTransform constructor(project: Project) : HunterTransform(project) {
  private var mHookException : MHookExtension? = null

  init {
    //这个类用来存储插件的提供给用户的配置信息
    mHookException = project.extensions.create("mHookExt", MHookExtension.javaClass)
    //我们需要给父类的bytecodeWeaver属性一个赋值，HookWeaver帮我们封装了对压缩文件等的访问，
    // 我们只需要提供一个ClassVisitor来决定如何对一个 class 文件访问就可以
    this.bytecodeWeaver = MHookWeaver(mHookException)
  }

  override fun transform(
    context: Context?,
    inputs: MutableCollection<TransformInput>?,
    referencedInputs: MutableCollection<TransformInput>?,
    outputProvider: TransformOutputProvider?,
    isIncremental: Boolean
  ) {
    this.bytecodeWeaver.setExtension(mHookException)
    super.transform(context, inputs, referencedInputs, outputProvider, isIncremental)
  }

}