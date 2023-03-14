package com.zjf.hooklpugin

import com.android.build.gradle.AppExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.util.Collections

/**
 * Create by zjf on 2022/9/28
 */
class MHookPlugin : Plugin<Project> {
  override fun apply(project: Project) {
    val appExtension = project.properties["android"] as AppExtension
    appExtension.registerTransform(MHookTransform(project), Collections.EMPTY_LIST)
  }
}