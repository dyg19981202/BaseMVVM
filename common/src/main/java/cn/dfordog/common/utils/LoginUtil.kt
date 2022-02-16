package cn.dfordog.common.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import cn.dfordog.common.base.BaseDUserInfoBean
import cn.dfordog.common.utils.Constant.Companion.SAVE_USER_INFO_TO_SP
import cn.dfordog.common.utils.Constant.Companion.SAVE_USER_TOKEN_TO_SP

/**
 * 登录工具类
 */
class LoginUtil() {

    constructor(userBean: BaseDUserInfoBean,context: Context) : this() {
        this.userBean = userBean
        this.context = context
        saveUserToken()
    }
    private lateinit var userBean: BaseDUserInfoBean
    private lateinit var context: Context
    private val sp = context.getSharedPreferences(SAVE_USER_INFO_TO_SP,MODE_PRIVATE)
    private val spEdit: SharedPreferences.Editor = sp.edit()

    /**
     * 存入token
     */
    private fun saveUserToken(){
        spEdit.putString(SAVE_USER_TOKEN_TO_SP,userBean.token)
        spEdit.commit()
    }

    /**
     * 取出token
     */
    fun getUserToken(): String? = sp.getString(SAVE_USER_TOKEN_TO_SP,"")


    /**
     * 是否是第一次登录
     */
    fun isFirstLogin(): Boolean = getUserToken()?.isEmpty() == true


}