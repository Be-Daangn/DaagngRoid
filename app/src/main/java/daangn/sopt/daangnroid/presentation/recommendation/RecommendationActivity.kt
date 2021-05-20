package daangn.sopt.daangnroid.presentation.recommendation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.databinding.ActivityRecommendationBinding

class RecommendationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecommendationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecommendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bookMarkClickEvent()

        binding.ivRecommendBack.setOnClickListener{
            onBackPressed()
        }
    }

    private fun bookMarkClickEvent(){
        binding.ivRecommendGoBookmark.setOnClickListener{ startBookmarkActivity() }
    }

    private fun startBookmarkActivity(){
        var intent = Intent(this@RecommendationActivity, BookmarkActivity::class.java)
        startActivity(intent)

    }
}
