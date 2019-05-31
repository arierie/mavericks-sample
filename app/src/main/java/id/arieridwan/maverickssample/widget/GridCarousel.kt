package id.arieridwan.maverickssample.widget

import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.ModelView.Size
import id.arieridwan.maverickssample.util.CommonUtil.Companion.SPAN_COUNT

@ModelView(saveViewState = true, autoLayout = Size.WRAP_WIDTH_WRAP_HEIGHT)
class GridCarousel(context: Context) : Carousel(context) {

    override fun createLayoutManager(): LayoutManager {
        return GridLayoutManager(context, SPAN_COUNT, LinearLayoutManager.HORIZONTAL, false)
    }

}