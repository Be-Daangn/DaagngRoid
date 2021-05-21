package daangn.sopt.daangnroid.presentation.recommendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.data.BookmarkInfo
import daangn.sopt.daangnroid.data.RecommendationInfo
import daangn.sopt.daangnroid.databinding.ActivityRecommendationBinding

class RecommendationActivity : AppCompatActivity() {

    private lateinit var recommendViewModel: RecommendViewModel
    private var _binding: ActivityRecommendationBinding? = null
    private val binding get() = _binding ?: error("binding 초기화 error")

    private lateinit var recommendListAdapter: RecommendListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRecommendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recommendViewModel = ViewModelProvider(this).get(RecommendViewModel::class.java)
        bookMarkClickEvent()

        setRecommendAdapter()
        setRecommendListData()

        binding.ivRecommendBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setRecommendAdapter() {
        recommendListAdapter = RecommendListAdapter()
        binding.recycleRecommend.adapter = recommendListAdapter
        recommendListAdapter.setStoryButtonClickListener {data, select ->
            if(select) {
                recommendViewModel.addBookmarkInfo(BookmarkInfo(data.img, data.name, data.location, true))
            }
            else {
                //remove
            }
        }
    }

    private fun setRecommendListData() {
        recommendListAdapter.recommendList.addAll(
            recommendViewModel.recommendMutablelist
        )

        recommendListAdapter.notifyDataSetChanged()
    }

    private fun bookMarkClickEvent() {
        binding.ivRecommendGoBookmark.setOnClickListener { startBookmarkActivity() }
    }

    private fun startBookmarkActivity() {
        var intent = Intent(this@RecommendationActivity, BookmarkActivity::class.java)
        startActivity(intent)

    }
}
