package daangn.sopt.daangnroid.presentation.news.news.newsApi

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NewsClient {
    private const val BASE_URL = "http://15.164.251.55:5000/api/main/"

    val getApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build()
        .create(NewsService::class.java)
}