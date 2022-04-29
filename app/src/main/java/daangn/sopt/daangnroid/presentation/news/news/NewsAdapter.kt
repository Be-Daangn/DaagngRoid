package daangn.sopt.daangnroid.presentation.news.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import daangn.sopt.daangnroid.databinding.ItemNewsBinding
import daangn.sopt.daangnroid.presentation.news.news.newsApi.NewsInformation

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    val newsList = mutableListOf<NewsInformation>()

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
        fun onBind(newsInfo: NewsInformation){
            binding.tvTitle.text = newsInfo.event
            binding.tvLocation.text = newsInfo.place
            binding.tvDescription.text = newsInfo.info
            Glide.with(binding.root) .load(newsInfo.image) .into(binding.ivImage)
        }
    }
}