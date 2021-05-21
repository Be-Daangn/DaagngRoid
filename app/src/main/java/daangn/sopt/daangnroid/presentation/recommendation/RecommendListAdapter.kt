package daangn.sopt.daangnroid.presentation.recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.bitmap.TransformationUtils.centerCrop
import daangn.sopt.daangnroid.data.RecommendationInfo
import daangn.sopt.daangnroid.databinding.ItemRecommendationBinding

class RecommendListAdapter : RecyclerView.Adapter<RecommendListAdapter.RecommendViewHolder>() {
    private var storeButtonClickListener: ((RecommendationInfo, Boolean)-> Unit) ?= null

    val recommendList = mutableListOf<RecommendationInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendViewHolder {
        val binding = ItemRecommendationBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RecommendViewHolder(binding)
    }

    fun setStoryButtonClickListener(listener : (RecommendationInfo, Boolean)-> Unit) {
        this.storeButtonClickListener = listener
    }

    override fun getItemCount(): Int = recommendList.size

    override fun onBindViewHolder(holder: RecommendViewHolder, position: Int) {
        holder.onBind(recommendList[position])
    }

    inner class RecommendViewHolder(
        private val binding: ItemRecommendationBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(recommendInfo: RecommendationInfo) {
            Glide.with(binding.imgRecommendList.context).load(recommendInfo.img).transform(
                CenterCrop(), RoundedCorners(40)).into(binding.imgRecommendList)

            binding.recommendData = recommendInfo
            binding.ivRecommendBookmark.setOnClickListener {
                it.isSelected = !it.isSelected
                storeButtonClickListener?.invoke(recommendInfo, it.isSelected)
            }
        }
    }
}