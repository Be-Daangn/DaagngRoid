package daangn.sopt.daangnroid.presentation.recommendation

import android.widget.ImageView
import androidx.databinding.BindingAdapter

object BindingAdapter {
    @JvmStatic
    @BindingAdapter("imgResId")
    fun setImg(view : ImageView, resId : Int) {
        view.setBackgroundResource(resId)
    }
}