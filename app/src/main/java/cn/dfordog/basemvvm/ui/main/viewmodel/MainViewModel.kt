package cn.dfordog.basemvvm.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cn.dfordog.common.base.BasicDViewModel

class MainViewModel : BasicDViewModel() {

    private val str = "NewMainFragment"

    fun getTitle(): String = str
}