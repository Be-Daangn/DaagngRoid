package daangn.sopt.daangnroid.presentation.recommendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.data.RecommendationInfo
import daangn.sopt.daangnroid.databinding.ActivityRecommendationBinding

class RecommendationActivity : AppCompatActivity() {

    private var _binding: ActivityRecommendationBinding? = null
    private val binding get() = _binding ?: error("binding 초기화 error")

    private lateinit var recommendListAdapter: RecommendListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityRecommendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
    }

    private fun setRecommendListData() {
        recommendListAdapter.recommendList.addAll(
            listOf<RecommendationInfo>(
                RecommendationInfo(
                    img = R.drawable.ic_recommend_img_1,
                    name = "다운타우너",
                    reviewNumber = "89",
                    maniaNumber = "31",
                    select = true
                ),
                RecommendationInfo(
                    img = R.drawable.ic_recommend_img_2,
                    name = "오복수산",
                    reviewNumber = "75",
                    maniaNumber = "24",
                    select = false
                ),
                RecommendationInfo(
                    img = R.drawable.ic_recommend_img_3,
                    name = "파이프그라운",
                    reviewNumber = "66",
                    maniaNumber = "18",
                    select = false
                )
            )
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
