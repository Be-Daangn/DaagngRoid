package daangn.sopt.daangnroid.presentation.search

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import daangn.sopt.daangnroid.databinding.ActivitySearchBinding
import daangn.sopt.daangnroid.presentation.search.recent.RecentSearchAdapter
import daangn.sopt.daangnroid.presentation.search.recent.RecentSearchInfo
import daangn.sopt.daangnroid.presentation.search.recommend.RecommendSearchAdapter
import daangn.sopt.daangnroid.presentation.search.recommend.RecommendSearchInfo

class SearchActivity : AppCompatActivity(){
    //binding && viewModel connection
    private var _binding: ActivitySearchBinding? = null
    private val binding get() = _binding?: error("view 참조 실패")
    private val viewModel : SearchViewModel by viewModels()
    private lateinit var recommendSearchAdapter: RecommendSearchAdapter
    private lateinit var recentSearchAdapter: RecentSearchAdapter
    private lateinit var recommendLayoutManager: RecyclerView.LayoutManager
    private lateinit var recentLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SEARCH_ACTIVITY","created")
        _binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recommendInit()
        recentInit()
    }

    fun recommendInit(){
        recommendSearchAdapter = RecommendSearchAdapter()
        binding.rvRecommendSearch.adapter = recommendSearchAdapter
        recommendLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.rvRecommendSearch.layoutManager = recommendLayoutManager

        recommendSearchAdapter.recommendList.addAll(
            listOf<RecommendSearchInfo>(
                RecommendSearchInfo(
                    name = "카페"
                ),
                RecommendSearchInfo(
                    name = "네일"
               ),
                RecommendSearchInfo(
                    name = "강아지"
                ),
                RecommendSearchInfo(
                    name = "정수기"
                ),
                RecommendSearchInfo(
                    name = "이사"
                )

            )
        )
    }

    fun recentInit(){
        recentSearchAdapter = RecentSearchAdapter()
        binding.rvRecentSearch.adapter = recentSearchAdapter
        recentLayoutManager = LinearLayoutManager(this)
        binding.rvRecentSearch.layoutManager = recentLayoutManager
        //구분선
        binding.rvRecentSearch.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        recentSearchAdapter.recentList.addAll(
            listOf<RecentSearchInfo>(
                RecentSearchInfo(
                    name = "꽃집"
                ),
                RecentSearchInfo(
                    name = "일식 맛집"
                ),
                RecentSearchInfo(
                    name = "이케아 가구"
                ),
                RecentSearchInfo(
                    name = "당근"
                ),
                RecentSearchInfo(
                    name = "오오오오오오오오오오~~~"
                )
            )
        )
    }


    override fun onDestroy(){
        _binding = null
        super.onDestroy()
    }


}