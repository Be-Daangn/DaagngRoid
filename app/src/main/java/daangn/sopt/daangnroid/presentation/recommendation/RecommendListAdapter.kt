package daangn.sopt.daangnroid.presentation.recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import daangn.sopt.daangnroid.data.RecommendationInfo
import daangn.sopt.daangnroid.databinding.ItemRecommendationBinding

class RecommendListAdapter : RecyclerView.Adapter<RecommendListAdapter.RecommendViewHolder>() {

    val recommendList = mutableListOf<RecommendationInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val binding = ItemRecommendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecommendViewHolder(binding)
    }

    override fun getItemCount(): Int = recommendList.size

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        holder.onBind(recommendList[position])
    }

    class RecommendViewHolder(
        private val binding: ItemRecommendationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recommendInfo: RecommendationInfo) {
            binding.recommendData = recommendInfo
        }
    }
}