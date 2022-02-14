package cn.dfordog.common.base

import cn.dfordog.common.utils.RetrofitUtil

open class BaseDRepository<T>(serviceApi: Class<T>) {

    protected val service = RetrofitUtil.initNetWork().create(serviceApi::class.java)
}