package daangn.sopt.daangnroid.presentation.search

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import daangn.sopt.daangnroid.R
import daangn.sopt.daangnroid.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity(){
    //binding && viewModel connection
    private var _binding: ActivitySearchBinding? = null
    private val binding get() = _binding?: error("view 참조 실패")
    private val viewModel : SearchViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SEARCH_ACTIVITY","created")

        _binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onDestroy(){
        _binding = null
        super.onDestroy()
    }


}