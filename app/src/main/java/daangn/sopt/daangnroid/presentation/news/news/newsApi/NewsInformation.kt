package daangn.sopt.daangnroid.presentation.news.news.newsApi

import com.google.gson.annotations.SerializedName

data class NewsInformation(
    @SerializedName("__v") val version: Int,
    @SerializedName("_id") val id: String,
    val event: String,
    val image: String,
    val info: String,
    val place: String,
    val title: String,
    val title_idx: Int
)