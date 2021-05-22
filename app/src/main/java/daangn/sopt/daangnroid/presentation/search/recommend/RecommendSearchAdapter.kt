package daangn.sopt.daangnroid.presentation.search.recommend

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import daangn.sopt.daangnroid.databinding.ItemSearchBinding

class RecommendSearchAdapter : RecyclerView.Adapter<RecommendSearchAdapter.MyViewHolder>() {
    val recommendList = mutableListOf<RecommendSearchInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecommendSearchAdapter.MyViewHolder {
        val binding = ItemSearchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = recommendList.size

    override fun onBindViewHolder(holder: RecommendSearchAdapter.MyViewHolder, position: Int) {
        holder.onBind(recommendList[position])
    }

    class MyViewHolder(
        private val binding : ItemSearchBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(recommendSearchInfo: RecommendSearchInfo){
            binding.tvName.text = recommendSearchInfo.name
        }
    }
}