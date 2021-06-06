package daangn.sopt.daangnroid.presentation.news

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import daangn.sopt.daangnroid.presentation.news.news.newsApi.NewsClient
import daangn.sopt.daangnroid.presentation.news.news.newsApi.NewsInformation
import daangn.sopt.daangnroid.util.ListLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    //mutableLiveData
    val newsList = ListLiveData<NewsInformation>()

    @SuppressLint("CheckResult")
    fun getNewsApi(){
        NewsClient.getApi.getNews()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({items ->
                newsList.clear()
                items.data.forEach {
                    newsList.add(NewsInformation(it.version,it.id,it.event,it.image,it.info,it.place,it.title,it.title_idx))
                }
            },{e ->
                println(e.toString())
            })
    }
}