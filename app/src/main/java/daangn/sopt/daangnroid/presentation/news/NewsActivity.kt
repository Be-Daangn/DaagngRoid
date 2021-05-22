package daangn.sopt.daangnroid.presentation.news

import android.content.res.ColorStateList
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipDrawable
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.databinding.ActivityNewsBinding
import daangn.sopt.daangnroid.presentation.news.news.NewsAdapter
import daangn.sopt.daangnroid.presentation.news.news.NewsInfo


class NewsActivity : AppCompatActivity() {
    private var _binding: ActivityNewsBinding? = null
    private val binding get() = _binding ?: error("view 참조 실패")
    private val viewModel: NewsViewModel by viewModels()
    private lateinit var myAdapter: NewsAdapter
    private lateinit var mLayoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SEARCH_ACTIVITY", "created")
        _binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
        chips()
        button()
    }

    fun init() {
        myAdapter = NewsAdapter()
        binding.rvNews.adapter = myAdapter
        mLayoutManager = LinearLayoutManager(this)
        binding.rvNews.layoutManager = mLayoutManager

        myAdapter.newsList.addAll(
            listOf<NewsInfo>(
                NewsInfo(
                    title = "아인플라워 오픈 행사",
                    location = "한남동",
                    description = "<<6월 1일 GRAND OPEN>>\n\n안녕하세요 당근님들!\n오픈 기념 이벤트 행사를 진행합니다!\n\n인스타그램 : aynflower\n\n카카오 플러스친구 : 아인플라워\n\n전화 : 070 4151 0488",
                    imgSrc = ""
                ),
                NewsInfo(
                    title = "인테리어 상담 서비",
                    location = "한남동",
                    description = "<<여름맞이 인테리어가 고민이라면?>>\n\n안녕하세요 당근님들!\n오픈 기념 이벤트 행사를 진행합니다!\n\n인스타그램 : aynflower\n\n카카오 플러스친구 : 아인플라워\n\n전화 : 070 4151 0488",
                    imgSrc = ""
                )
            )
        )
    }

    fun chips() {
        val chipGroup = binding.cgGroup
        val chipResources = listOf("신규", "할인", "이벤트", "카페", "네일", "강아지", "정수기", "이사")

        chipResources
            .map { it.toChip() }
            .map {
                it.apply {
                    setTextColor(resources.getColor(R.color.chip_text_color, null))
                    isCheckable = true
                    isCheckedIconVisible = false
                    setTextColor(ContextCompat.getColorStateList(this@NewsActivity, R.color.chip_text_color))
                    chipBackgroundColor = ContextCompat.getColorStateList(this@NewsActivity, R.color.chip_background_color)
                    setChipStrokeColorResource(R.color.white)
                    chipStrokeWidth = 1.0F
                    isChecked = false
                }
            }
            .map {
                it.apply {
                    it.setOnCheckedChangeListener { buttonView, checked ->
                        Log.d("TAG", "$checked")
                        buttonView.isChecked = checked
                    }
                }
            }
            .map { chipGroup.addView(it) }
    }

    private fun String.toChip() = Chip(this@NewsActivity).apply { text = this@toChip }

    fun button() {
        binding.ivBack.setOnClickListener {
            //TODO:뒤로가기
        }
        binding.ivAlarm.setOnClickListener {
            //TODO:알람
        }
        binding.ivPencil.setOnClickListener {
            //TODO:글쓰기
        }
    }
}