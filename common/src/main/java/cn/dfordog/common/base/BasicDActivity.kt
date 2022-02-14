package cn.dfordog.common.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.dfordog.common.utils.WindowUtils
import cn.dfordog.common.utils.WindowUtils.getStatusBarHeight

abstract class BasicDActivity<VB:ViewDataBinding,VM: ViewModel> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var TAG: String
    protected val viewModel: VM by lazy {
        ViewModelProvider(this)[getViewModel()]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        TAG = javaClass.name
        binding = DataBindingUtil.setContentView(this,getLayoutID())
        hideSystemUI()
        setMarginToStatusBar()
        if(setStatusFontColor()){
            WindowUtils.setStatusBarIconDarkColor(this)
        }else{
            WindowUtils.setStatusBarIconLightColor(this)
        }
        WindowUtils.setAndroidNativeLightStatusBar(this, setStatusFontColor())
        initView()
        initData()
    }

    /**
     * 获取需要进行绑定的布局ID
     */
    protected abstract fun getLayoutID(): Int

    /**
     * 获取需要初始化的ViewModel
     */
    protected abstract fun getViewModel(): Class<VM>

    /**
     * 初始化视图
     */
    protected abstract fun initView()

    /**
     * 初始化数据
     */
    protected abstract fun initData()

    /**
     * 设置沉浸式状态栏
     */
    private fun hideSystemUI() {
        if(Build.VERSION.SDK_INT >= 21){
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    /**
     * 将状态栏高度给需要的视图设置上边距
     */
    private fun setMarginToStatusBar(){
        if(viewId() != null){
            //计算状态栏高度
            val statusBarHeight = getStatusBarHeight(this)
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            viewId()?.layoutParams?.height = statusBarHeight
            viewId()?.layoutParams?.width = ViewGroup.LayoutParams.MATCH_PARENT
        }
    }

    /**
     * 需要设置上边距的视图
     */
    protected abstract fun viewId(): View?

    /**
     * 需要给状态栏字体设置的颜色
     * true 黑色
     * false 白色
     */
    protected abstract fun setStatusFontColor(): Boolean

}