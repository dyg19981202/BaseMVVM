package cn.dfordog.common.utils

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowInsetsController
import cn.dfordog.common.utils.Constant.Companion.ANDROID
import cn.dfordog.common.utils.Constant.Companion.DIMEN
import cn.dfordog.common.utils.Constant.Companion.STATUS_BAR_HEIGHT

object WindowUtils {

    /**
     * 获取状态栏高度
     * @param context 上下文
     */
    fun getStatusBarHeight(context: Context): Int{
        var result = 0
        val resourceId = context.resources.getIdentifier(STATUS_BAR_HEIGHT, DIMEN, ANDROID)

        if(resourceId > 0){
            result = context.resources.getDimensionPixelOffset(resourceId)
        }

        return result
    }


    /**
     * 设置沉浸式状态栏
     */
    fun hideSystemUI(activity: Activity) {
        if(Build.VERSION.SDK_INT >= 21){
            val decorView = activity.window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            activity.window.statusBarColor = Color.TRANSPARENT
        }
    }

    /**
     * 设置顶部状态栏字体颜色
     */
    fun setAndroidNativeLightStatusBar(activity: Activity, dark: Boolean) {
        val decor = activity.window.decorView
        if (dark) {
            decor.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            decor.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
    }

    /**
     * 状态栏深色Icon
     */
     fun setStatusBarIconDarkColor(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window
                .decorView
                .windowInsetsController
                ?.setSystemBarsAppearance(
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
        } else {
            var vis = activity.window.decorView.systemUiVisibility
            vis = vis or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vis = vis or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
            activity.window.decorView.systemUiVisibility = vis
        }
    }

    /**
     * 状态栏亮色Icon
     */
    fun setStatusBarIconLightColor(activity: Activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            activity.window
                .decorView
                .windowInsetsController
                ?.setSystemBarsAppearance(
                    0,
                    WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                )
        } else {
            var vis = activity.window.decorView.systemUiVisibility
            vis = vis and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vis = vis and View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
            activity.window.decorView.systemUiVisibility = vis
        }
    }

}