package daangn.sopt.daangnroid.presentation.news

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.databinding.ActivityNewsBinding
import daangn.sopt.daangnroid.presentation.news.news.NewsAdapter


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
        setData() //서버 데이터 받아오기
        chips()
        button()
    }

    fun init() {
        myAdapter = NewsAdapter()
        binding.rvNews.adapter = myAdapter
        mLayoutManager = LinearLayoutManager(this)
        binding.rvNews.layoutManager = mLayoutManager
    }

    fun setData(){
        viewModel.getNewsApi()
        //observe
        viewModel.newsList.observe(this, {
            myAdapter.newsList.clear()
            myAdapter.newsList.addAll(it)
            myAdapter.notifyDataSetChanged()
        })
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