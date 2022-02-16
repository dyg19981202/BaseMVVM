package cn.dfordog.common.utils

import cn.dfordog.common.BuildConfig
import cn.dfordog.common.utils.Constant.Companion.TOKEN
import okhttp3.Headers
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit


/**
 * 网络请求初始化
 */
object RetrofitUtil {

    /**
     * 初始化网络请求
     */
    fun initNetWork(): Retrofit {

        /*设置Cookie*/
        val cookieManager = CookieManager()
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL)

        /*log信息拦截器*/
        val httpLoggingInterceptor = if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            loggingInterceptor
        } else {
            HttpLoggingInterceptor()
        }

        /*OkHttp连接*/
        val okHttpClient = OkHttpClient().newBuilder()
            /*log信息拦截器*/
            .addInterceptor(httpLoggingInterceptor)
            /*公共参数*/
            .addInterceptor {
                val originalRequest: Request = it.request()
                val request: Request
                val method: String = originalRequest.method
                val headers: Headers = originalRequest.headers
                val modifiedUrl: HttpUrl =
                    originalRequest.url.newBuilder() // Provide your custom parameter here
                        /*将token添加到公共参数中*/
                        .addQueryParameter(TOKEN, "")
                        .build()
                request = originalRequest.newBuilder()
                    .url(modifiedUrl)
                    /*将token添加到请求头中*/
//                    .header(TOKEN,"")
                    .build()
                it.proceed(request)
            }
            /*设置超时和重连*/
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            /*错误重连*/
            .retryOnConnectionFailure(true)
            .build()


        return Retrofit.Builder()
            .baseUrl("http://yuelian.sd.cloudjp.cn/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}