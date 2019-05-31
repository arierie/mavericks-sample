package id.arieridwan.maverickssample.ui.detailmovie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel

import id.arieridwan.maverickssample.R
import id.arieridwan.maverickssample.util.CommonUtil.Companion.backdropPath
import id.arieridwan.maverickssample.util.CommonUtil.Companion.loadImageWithUrl
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import kotlinx.android.synthetic.main.fragment_detail_movie.view.*

class DetailMovieFragment : BaseMvRxFragment() {

    private val mViewModel: DetailMovieViewModel by fragmentViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_detail_movie, container, false).apply {
                toolbar.setupWithNavController(findNavController())
            }

    override fun invalidate() {
        marquee.setTitle(mViewModel.initialState.movie.title)
        marquee.setSubtitle(mViewModel.initialState.movie.overview)
        activity?.let { loadImageWithUrl(it, backdropPath + mViewModel.initialState.movie.posterPath, movieCover) }
    }

}