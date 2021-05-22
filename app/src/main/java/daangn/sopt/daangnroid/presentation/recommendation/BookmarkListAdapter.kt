package daangn.sopt.daangnroid.presentation.recommendation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import daangn.sopt.daangnroid.data.BookmarkInfo
import daangn.sopt.daangnroid.data.RecommendationInfo
import daangn.sopt.daangnroid.databinding.ItemBookmarkBinding

class BookmarkListAdapter : RecyclerView.Adapter<BookmarkListAdapter.BookmarkViewHolder>()  {

    val bookmarkList = mutableListOf<BookmarkInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val binding = ItemBookmarkBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return BookmarkViewHolder(binding)
    }

    override fun getItemCount(): Int = bookmarkList.size

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.onBind(bookmarkList[position])
    }

    class BookmarkViewHolder(
        private val binding: ItemBookmarkBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(bookmarkInfo: BookmarkInfo) {
            binding.bookmarkData = bookmarkInfo
            binding.ivBookmarkTrue.setOnClickListener {
                it.isSelected = !it.isSelected
            }
        }
    }
}