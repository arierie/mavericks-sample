package id.arieridwan.maverickssample.ui.homepage

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyController
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import id.arieridwan.maverickssample.core.BaseFragment
import id.arieridwan.maverickssample.core.simpleController
import id.arieridwan.maverickssample.util.CommonUtil.Companion.HOME_TAG
import id.arieridwan.maverickssample.R
import id.arieridwan.maverickssample.ui.detailmovie.DetailMovieArgs
import id.arieridwan.maverickssample.util.CommonUtil.Companion.CAT_POPULAR
import id.arieridwan.maverickssample.util.CommonUtil.Companion.SPAN_COUNT
import id.arieridwan.maverickssample.widget.*
import kotlinx.android.synthetic.main.fragment_detail_movie.*
import kotlinx.android.synthetic.main.fragment_detail_movie.marquee
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.marquee.*

class HomePageFragment: BaseFragment() {

    private val mViewModel: HomePageViewModel by fragmentViewModel()

    override fun resLayout(): Int = R.layout.fragment_main

    private fun initView() {
        val layoutManager = GridLayoutManager(context, SPAN_COUNT)
        epoxyController.spanCount = SPAN_COUNT
        layoutManager.spanSizeLookup = epoxyController.spanSizeLookup
        recycler_view.layoutManager = layoutManager
        recycler_view.setController(epoxyController)
    }

    override fun invalidate() {
        recycler_view.requestModelBuild()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        mViewModel.asyncSubscribe(HomePageState::request, onFail = {
            Log.e(HOME_TAG, "Movies request failed ${it.message}")
            mViewModel.fetchMovies("popular")
        }, onSuccess = {
            invalidate()
        })
    }

    override fun epoxyController() = simpleController(mViewModel) {
        marquee {
            id("movieTitleOne")
            title("Title Section One")
            subtitle("This is the descriptions of the section one")
        }

        val movieModels = mutableListOf<MovieCarouselRowModel_>()
        it.movies.forEach {
            movieModels.add(MovieCarouselRowModel_()
                    .id(it.id)
                    .title(it.title)
                    .imageCover(it.posterPath)
                    .rating(it.voteAverage)
                    .clickListener { _ ->
                        navigateTo(R.id.action_main_to_detailMovieFragment,
                                DetailMovieArgs(it.id, it))
                    })
        }

        gridCarousel {
            id("carousel")
            models(movieModels)
        }

        marquee {
            id("movieTitleTwo")
            title("Title Section Two")
            subtitle("This is the descriptions of the section two")
        }

        it.movies.forEach {
            movieRow {
                id(it.id)
                title(it.title)
                imageCover(it.posterPath)
                spanSizeOverride { totalSpanCount, _, _ -> totalSpanCount }
                rating(it.voteAverage)
                category(it.releaseDate)
                clickListener { _ ->
                    navigateTo(R.id.action_main_to_detailMovieFragment,
                            DetailMovieArgs(it.id, it))
                }
            }
        }

        loadingRow {
            // Changing the ID will force it to rebind when new data is loaded even if it is
            // still on screen which will ensure that we trigger loading again.
            id("loading${it.movies.size}")
            onBind { _, _, _ -> mViewModel.fetchMovies(CAT_POPULAR) }
        }
    }

}
