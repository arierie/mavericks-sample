package id.arieridwan.maverickssample.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import id.arieridwan.maverickssample.R

/**
 * Created by arieridwan on 31/08/18.
 */

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class LoadingRow @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.loading_row, this)
    }

    @ModelProp
    fun setVisibility(visible: Boolean) {
        this.visibility = visibility
    }

}