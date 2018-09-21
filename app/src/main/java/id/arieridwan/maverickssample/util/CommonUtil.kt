package id.arieridwan.maverickssample.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import id.arieridwan.maverickssample.R

open class CommonUtil {

    companion object {
        const val SPAN_COUNT = 2
        const val MOVIES_PER_PAGE = 10
        const val HOME_TAG = "home_fragment"
        const val CAT_LATEST = "latest"
        const val CAT_NOW_PLAYING = "now_playing"
        const val CAT_POPULAR = "popular"
        const val CAT_TOP_RATED = "top_rated"
        const val CAT_UPCOMING = "upcoming"
        const val posterPath = "http://image.tmdb.org/t/p/w185"
        const val backdropPath = "http://image.tmdb.org/t/p/w500"

        fun loadImageWithUrl(context: Context, url: String?, imageView: ImageView) {
            val myOptions = RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .placeholder(R.color.text_color)
                    .dontAnimate()
            Glide.with(context)
                    .asBitmap()
                    .apply(myOptions)
                    .load(url)
                    .into(imageView)
        }
    }

}