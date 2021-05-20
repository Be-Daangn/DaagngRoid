package daangn.sopt.daangnroid.presentation.news.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import daangn.sopt.daangnroid.databinding.ItemNewsBinding
import daangn.sopt.daangnroid.databinding.ItemSearchBinding
import daangn.sopt.daangnroid.presentation.search.recommend.RecommendSearchAdapter
import daangn.sopt.daangnroid.presentation.search.recommend.RecommendSearchInfo

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    val newsList = mutableListOf<NewsInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
        val binding = ItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsAdapter.MyViewHolder(binding)
    }

    override fun getItemCount(): Int = newsList.size

    override fun onBindViewHolder(holder: NewsAdapter.MyViewHolder, position: Int) {
        holder.onBind(newsList[position])
    }

    class MyViewHolder(
        private val binding : ItemNewsBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(newsInfo: NewsInfo){
            binding.tvTitle.text = newsInfo.title
            binding.tvLocation.text = newsInfo.location
            binding.tvDescription.text = newsInfo.description
        }
    }
}