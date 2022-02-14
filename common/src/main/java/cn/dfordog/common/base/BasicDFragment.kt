package cn.dfordog.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import cn.dfordog.common.utils.WindowUtils
import cn.dfordog.common.utils.WindowUtils.getStatusBarHeight
import cn.dfordog.common.utils.WindowUtils.hideSystemUI

abstract class BasicDFragment<VB:ViewDataBinding,VM: ViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected val viewModel: VM by lazy {
        ViewModelProvider(this)[getViewModel()]
    }
    protected lateinit var TAG: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater,getLayoutID(),container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*初始化TAG*/
        TAG = javaClass.name
        /*沉浸式状态栏*/
        hideSystemUI(requireActivity())
        /*设置状态栏字体颜色*/
        if(setStatusFontColor()){
            WindowUtils.setStatusBarIconDarkColor(requireActivity())
        }else{
            WindowUtils.setStatusBarIconLightColor(requireActivity())
        }
        /*初始化视图*/
        initView()
        /*初始化数据*/
        initData()
        /*设置状态栏高度*/
        setMarginToStatusBar()
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
     * 将状态栏高度给需要的视图设置上边距
     */
    private fun setMarginToStatusBar(){
        if(viewId() != null){
            //计算状态栏高度
            val statusBarHeight = getStatusBarHeight(requireContext())
            requireActivity().window.decorView.systemUiVisibility =
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
    abstract fun setStatusFontColor(): Boolean

}