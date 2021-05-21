package daangn.sopt.daangnroid.presentation.recommendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.data.BookmarkInfo
import daangn.sopt.daangnroid.databinding.ActivityBookmarkBinding
import daangn.sopt.daangnroid.databinding.ActivityRecommendationBinding

class BookmarkActivity : AppCompatActivity() {

    private lateinit var bookmarkViewModel: BookmarkViewModel
    private var _binding: ActivityBookmarkBinding? = null
    private val binding get() = _binding ?: error("binding 초기화 error")

    private lateinit var bookmarkListAdapter: BookmarkListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookmarkViewModel = ViewModelProvider(this).get(BookmarkViewModel::class.java)

        setBookmarkAdapter()
        setBookmarkListData()

        binding.ivBookmarkBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setBookmarkAdapter() {
        bookmarkListAdapter = BookmarkListAdapter()
        binding.recycleBookmark.adapter = bookmarkListAdapter
    }

    private fun setBookmarkListData() {
        bookmarkListAdapter.bookmarkList.addAll(
            bookmarkViewModel.bookmarkMutablelist
        )

        bookmarkListAdapter.notifyDataSetChanged()
    }
}

