package cn.dfordog.basemvvm.ui.main

import android.view.View
import android.widget.LinearLayout
import cn.dfordog.basemvvm.R
import cn.dfordog.basemvvm.databinding.MainFragmentBinding
import cn.dfordog.basemvvm.ui.main.viewmodel.MainViewModel
import cn.dfordog.common.base.BaseDUserInfoBean
import cn.dfordog.common.base.BasicDFragment
import cn.dfordog.common.utils.LoginUtil
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * 消息页面
 */
class MainFragment : BasicDFragment<MainFragmentBinding, MainViewModel>() {

    override fun getLayoutID(): Int = R.layout.main_fragment

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java

    override fun initView() {
        /*隐藏底部导航栏*/
        requireActivity().findViewById<BottomNavigationView>(R.id.mainNav).visibility = View.VISIBLE

        /*设置头部颜色*/
        requireActivity().findViewById<LinearLayout>(R.id.mainTopLL).setBackgroundColor(resources.getColor(R.color.main_color))

    }

    override fun initData() {
        binding.message.text = viewModel.getTitle()
    }

    override fun viewId(): View = binding.mainFTopLL
    override fun setStatusFontColor(): Boolean = false

}