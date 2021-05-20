package daangn.sopt.daangnroid.presentation.recommendation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.databinding.ActivityBookmarkBinding

class BookmarkActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBookmarkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBookmarkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBookmarkBack.setOnClickListener{
            onBackPressed()
        }
    }
}