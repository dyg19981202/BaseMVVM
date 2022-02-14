package cn.dfordog.basemvvm.ui.mine

import android.view.View
import cn.dfordog.basemvvm.R
import cn.dfordog.basemvvm.databinding.FragmentMineBinding
import cn.dfordog.basemvvm.ui.mine.viewmodel.MineViewModel
import cn.dfordog.common.base.BasicDFragment

/**
 * 我的
 */
class MineFragment : BasicDFragment<FragmentMineBinding,MineViewModel>() {

    override fun getLayoutID(): Int = R.layout.fragment_mine

    override fun getViewModel(): Class<MineViewModel> = MineViewModel::class.java

    override fun initView() {
    }

    override fun initData() {
        
    }

    override fun viewId(): View? = null
    override fun setStatusFontColor(): Boolean = false
}