package cn.dfordog.basemvvm

import android.app.Application
import cn.dfordog.common.utils.RetrofitUtil
import retrofit2.Retrofit

class App : Application() {

    lateinit var retrofit: Retrofit

    override fun onCreate() {
        super.onCreate()
        retrofit = RetrofitUtil.initNetWork()
    }
}