package daangn.sopt.daangnroid.presentation.recommendation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.data.BookmarkInfo
import daangn.sopt.daangnroid.data.RecommendationInfo

class BookmarkViewModel : ViewModel() {

    val bookmarkMutablelist: MutableList<BookmarkInfo> = mutableListOf(
        BookmarkInfo(
            img = R.drawable.ic_recommend_img_1,
            name = "다운타우너",
            location = "한남동",
            select = true
        ),
        BookmarkInfo(
            img = R.drawable.ic_recommend_img_2,
            name = "오복수산",
            location = "연남동",
            select = false
        ),
        BookmarkInfo(
            img = R.drawable.ic_recommend_img_3,
            name = "파이프그라운",
            location = "성수동",
            select = false
        )
    )

}