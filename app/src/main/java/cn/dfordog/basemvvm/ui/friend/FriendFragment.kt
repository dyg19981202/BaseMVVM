package cn.dfordog.basemvvm.ui.friend

import android.view.View
import android.widget.ImageView
import cn.dfordog.basemvvm.R
import cn.dfordog.basemvvm.databinding.FragmentFriendBinding
import cn.dfordog.basemvvm.ui.friend.viewmodel.FriendViewModel
import cn.dfordog.common.base.BasicDFragment

/**
 * 联系人
 */
class FriendFragment : BasicDFragment<FragmentFriendBinding,FriendViewModel>() {

    override fun getLayoutID(): Int = R.layout.fragment_friend

    override fun getViewModel(): Class<FriendViewModel> = FriendViewModel::class.java

    override fun initView() {
        /*将返回按钮进行隐藏*/
        binding.friendHead.findViewById<ImageView>(R.id.headTopBack).visibility = View.GONE
    }

    override fun initData() {
        
    }

    override fun viewId(): View? = null

    override fun setStatusFontColor(): Boolean = false
}