package daangn.sopt.daangnroid.presentation.recommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.data.BookmarkInfo
import daangn.sopt.daangnroid.data.RecommendationInfo

class RecommendViewModel : ViewModel() {
    private val _recommendStoreList = MutableLiveData<MutableList<BookmarkInfo>>()
    val recommendStoreList: LiveData<MutableList<BookmarkInfo>>
        get() = _recommendStoreList

    val recommendMutablelist: MutableList<RecommendationInfo> = mutableListOf(
        RecommendationInfo(
            img = R.drawable.recommend_1,
            name = "다운타우너",
            reviewNumber = "89",
            maniaNumber = "31",
            location = "한남동",
            select = true,
            tag = "맛집랭킹"
        ),
        RecommendationInfo(
            img = R.drawable.recommend_2,
            name = "오복수산",
            reviewNumber = "75",
            maniaNumber = "24",
            location = "연남동",
            select = false,
            tag = "일식"
        ),
        RecommendationInfo(
            img = R.drawable.recommend_3,
            name = "파이프그라운",
            reviewNumber = "66",
            maniaNumber = "18",
            location = "성수동",
            select = false,
            tag = "맛집랭킹"
        )
    )

    fun addBookmarkInfo(bookmarkInfo: BookmarkInfo) {
        recommendStoreList.value?.add(bookmarkInfo)
    }
}