package cn.dfordog.basemvvm

import android.annotation.SuppressLint
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import cn.dfordog.basemvvm.databinding.MainActivityBinding
import cn.dfordog.basemvvm.viewmodel.MainViewModel
import cn.dfordog.common.base.BasicDActivity
import com.google.android.material.badge.BadgeUtils
import com.google.android.material.badge.BadgeDrawable
import retrofit2.create


class MainActivity : BasicDActivity<MainActivityBinding, MainViewModel>() {
    
    override fun getLayoutID(): Int  = R.layout.main_activity

    override fun getViewModel(): Class<MainViewModel> = MainViewModel::class.java


    override fun initView() {
        setBottomIcon()
        /*查询导航控制器*/
        val navController = supportFragmentManager.findFragmentById(R.id.fragmentContainer)!!.findNavController()
        /**/
        binding.mainNav.setupWithNavController(navController)

        /*切换fragment时会走该监听*/
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            /*获取当前fragment的label*/
            Log.e(TAG,"${controller.currentDestination?.label}")
            when(controller.currentDestination?.label){
                "消息页" -> {
                    binding.mainNav.visibility = View.VISIBLE
                }
                "发现" -> {
                    binding.mainNav.visibility = View.VISIBLE
                }
                "我的" -> {
                    binding.mainNav.visibility = View.VISIBLE
                }
                "联系人" -> {
                    binding.mainNav.visibility = View.VISIBLE
                }
                else -> {
                    binding.mainNav.visibility = View.GONE
                }
            }
        }

    }

    override fun initData() {

    }

    /**
     * 设置底部导航图标
     */
    private fun setBottomIcon(){
        binding.mainNav.itemIconTintList = null
        binding.mainNav.setOnItemSelectedListener {
            setAllIconNoSelect()
            when(it.itemId){
                R.id.mainMsg -> {
                    it.setIcon(R.mipmap.icon_msg_select)
                    return@setOnItemSelectedListener true
                }
                R.id.mainFriend -> {
                    it.setIcon(R.mipmap.icon_msg_contacts_select)
                    return@setOnItemSelectedListener true
                }
                R.id.mainFind -> {
                    it.setIcon(R.mipmap.icon_find_select)
                    return@setOnItemSelectedListener true
                }
                R.id.mainMine -> {
                    it.setIcon(R.mipmap.icon_mine_select)
                    return@setOnItemSelectedListener  true
                }
            }
            return@setOnItemSelectedListener false
        }
    }

    /**
     * 将所有ICON全部设置为默认未选中
     */
    private fun setAllIconNoSelect(){
        val mainMsg = binding.mainNav.menu.findItem(R.id.mainMsg)
        val mainFriend = binding.mainNav.menu.findItem(R.id.mainFriend)
        val mainFind = binding.mainNav.menu.findItem(R.id.mainFind)
        val mainMine = binding.mainNav.menu.findItem(R.id.mainMine)

        mainMsg.setIcon(R.mipmap.icon_msg_no_select)
        mainFriend.setIcon(R.mipmap.icon_contacts_no_select)
        mainFind.setIcon(R.mipmap.icon_find_no_select)
        mainMine.setIcon(R.mipmap.icon_mine_no_select)
    }

    override fun viewId(): View = binding.mainTopLL
    override fun setStatusFontColor(): Boolean = false


}