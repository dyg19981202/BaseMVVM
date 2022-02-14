package cn.dfordog.basemvvm.ui.login

import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import cn.dfordog.basemvvm.R
import cn.dfordog.basemvvm.databinding.ActivityLoginBinding
import cn.dfordog.basemvvm.databinding.OneKeyLoginFragmentBinding
import cn.dfordog.basemvvm.ui.login.viewmodel.OneKeyLoginViewModel
import cn.dfordog.common.base.BasicDFragment
import cn.dfordog.common.utils.Constant.Companion.IS_READ_TIPS

/**
 * 一键登录
 */
class OneKeyLoginFragment : BasicDFragment<ActivityLoginBinding, OneKeyLoginViewModel>() {
    
    override fun getLayoutID(): Int = R.layout.activity_login

    override fun getViewModel(): Class<OneKeyLoginViewModel> = OneKeyLoginViewModel::class.java

    override fun initView() {
        /*设置选中按钮可点*/
        binding.im.isEnabled = true

        /*设置已读点击事件*/
        binding.im.setOnClickListener {
            binding.im.isSelected = !binding.im.isSelected
        }

        /*一键登录*/
        binding.oneKeyLoginTv.setOnClickListener {
            if(!binding.im.isSelected){
                Toast.makeText(requireContext(), IS_READ_TIPS, Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            /*跳转至首页*/
            findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
        }

    }

    override fun initData() {
        
    }

    override fun viewId(): View? = null

    override fun setStatusFontColor(): Boolean = true

}