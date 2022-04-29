package daangn.sopt.daangnroid.presentation.news.news.newsApi

data class News(
    val `data`: List<NewsInformation>,
    val message: String,
    val status: Int,
    val success: Boolean
)