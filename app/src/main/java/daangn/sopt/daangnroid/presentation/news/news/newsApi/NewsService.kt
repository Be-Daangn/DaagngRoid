package daangn.sopt.daangnroid.presentation.news.news.newsApi

import io.reactivex.Single
import retrofit2.http.GET

interface NewsService {
    @GET("news")
    fun getNews() : Single<News>
    fun getNewsInformation() :Single<NewsInformation>
}