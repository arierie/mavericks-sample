package id.arieridwan.maverickssample.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import id.arieridwan.maverickssample.R
import id.arieridwan.maverickssample.util.CommonUtil.Companion.loadImageWithUrl
import id.arieridwan.maverickssample.util.CommonUtil.Companion.posterPath
import kotlinx.android.synthetic.main.movie_row.view.*

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class MovieRow @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.movie_row, this)
    }

    @TextProp
    fun setTitle(title: CharSequence) {
        movieTitle.text = title
    }

    @ModelProp
    fun setImageCover(url: String) {
        loadImageWithUrl(context, posterPath + url, movieCover)
    }

    @ModelProp
    fun setRating(rating: Double) {
        movieRating.text = rating.toString()
    }

    @ModelProp
    fun setCategory(category: String) {
        movieCat.text = category
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        cardView.setOnClickListener(clickListener)
        movieTitle.setOnClickListener(clickListener)
    }

}