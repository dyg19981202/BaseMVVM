package cn.dfordog.basemvvm.ui.find

import android.view.View
import cn.dfordog.basemvvm.R
import cn.dfordog.basemvvm.databinding.FragmentFindBinding
import cn.dfordog.basemvvm.ui.find.viewmodel.FindViewModel
import cn.dfordog.common.base.BasicDFragment

class FindFragment : BasicDFragment<FragmentFindBinding,FindViewModel>() {

    override fun getLayoutID(): Int = R.layout.fragment_find

    override fun getViewModel(): Class<FindViewModel> = FindViewModel::class.java

    override fun initView() {
        
    }

    override fun initData() {
        
    }

    override fun viewId(): View? = null
    override fun setStatusFontColor(): Boolean = false
}