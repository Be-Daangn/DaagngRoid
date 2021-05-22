package daangn.sopt.daangnroid.presentation.search.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import daangn.sopt.daangnroid.databinding.ItemRecentSearchBinding
import daangn.sopt.daangnroid.databinding.ItemSearchBinding

class RecentSearchAdapter : RecyclerView.Adapter<RecentSearchAdapter.MyViewHolder>() {
    val recentList = mutableListOf<RecentSearchInfo>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentSearchAdapter.MyViewHolder {
        val binding = ItemRecentSearchBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = recentList.size

    override fun onBindViewHolder(holder: RecentSearchAdapter.MyViewHolder, position: Int) {
        holder.onBind(recentList[position])
    }

    class MyViewHolder(
        private val binding : ItemRecentSearchBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(recentSearchInfo: RecentSearchInfo){
            binding.tvName.text = recentSearchInfo.name
        }
    }
}