package id.arieridwan.maverickssample.ui.homepage

import com.airbnb.mvrx.*
import id.arieridwan.maverickssample.core.MvRxViewModel
import id.arieridwan.maverickssample.repository.MovieRepository
import id.arieridwan.maverickssample.util.CommonUtil.Companion.CAT_POPULAR
import org.koin.android.ext.android.inject

class HomePageViewModel(initialState: HomePageState, private val movieRepository: MovieRepository
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
            movieRepository.loadMoviesFromNetwork(category = category, page = currentPage)
                    .execute { copy(request = it, movies = movies + (it()?.movies ?: emptyList())) }
        }
    }

    companion object : MvRxViewModelFactory<HomePageViewModel, HomePageState> {
        @JvmStatic override fun create(viewModelContext: ViewModelContext, state: HomePageState): HomePageViewModel {
            val movieRepository: MovieRepository by viewModelContext.activity.inject()
            return HomePageViewModel(state, movieRepository)
        }
    }

}