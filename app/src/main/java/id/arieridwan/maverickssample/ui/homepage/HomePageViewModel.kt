package id.arieridwan.maverickssample.ui.homepage

import android.support.v4.app.FragmentActivity
import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.MvRxViewModelFactory
import id.arieridwan.maverickssample.core.MvRxViewModel
import id.arieridwan.maverickssample.usecase.MovieUseCase
import id.arieridwan.maverickssample.util.CommonUtil.Companion.CAT_POPULAR
import org.koin.android.ext.android.inject

class HomePageViewModel(initialState: HomePageState,
                        private val useCase: MovieUseCase
): MvRxViewModel<HomePageState>(initialState) {

    private var currentPage = 0
    private val maxMovieOnPage = 80

    init {
        fetchMovies(CAT_POPULAR)
    }

    fun fetchMovies(category: String) = withState { state ->
        if (state.request is Loading) return@withState
        if (state.movies.size < maxMovieOnPage) {
            currentPage += 1
            useCase.loadMovies(category = category, page = currentPage)
                    .execute { copy(request = it, movies = movies + (it()?.movies ?: emptyList())) }
        }
    }

    companion object : MvRxViewModelFactory<HomePageState> {
        @JvmStatic override fun create(activity: FragmentActivity, state: HomePageState): BaseMvRxViewModel<HomePageState> {
            val useCase: MovieUseCase by activity.inject()
            return HomePageViewModel(state, useCase)
        }
    }

}
