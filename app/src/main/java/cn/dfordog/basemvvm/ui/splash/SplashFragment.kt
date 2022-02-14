package cn.dfordog.basemvvm.ui.splash

import android.graphics.Color
import android.view.View
import android.widget.LinearLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import cn.dfordog.basemvvm.R
import cn.dfordog.basemvvm.databinding.SplashFragmentBinding
import cn.dfordog.basemvvm.ui.splash.viewmodel.SplashViewModel
import cn.dfordog.common.base.BasicDFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 启动页
 */
class SplashFragment : BasicDFragment<SplashFragmentBinding,SplashViewModel>() {

    private val type = 1

    override fun getLayoutID(): Int = R.layout.splash_fragment

    override fun getViewModel(): Class<SplashViewModel> = SplashViewModel::class.java

    override fun initView() {

        /*设置头部颜色*/
        requireActivity().findViewById<LinearLayout>(R.id.mainTopLL).setBackgroundColor(Color.WHITE)

        lifecycleScope.launch(Dispatchers.IO){
            delay(2000)
            lifecycleScope.launch(Dispatchers.Main){
                if(type == 0){
                    findNavController().navigate(R.id.action_splashFragment_to_oneKeyLoginFragment)
                }else{
                    findNavController().navigate(R.id.action_splashFragment_to_mainFragment)
                }
            }
        }
    }

    override fun initData() {
        
    }

    override fun viewId(): View? = null

    override fun setStatusFontColor(): Boolean = false

}