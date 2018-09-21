package id.arieridwan.maverickssample.usecase

import id.arieridwan.maverickssample.data.response.MovieListResponse
import id.arieridwan.maverickssample.model.HomePage
import id.arieridwan.maverickssample.repository.MovieRepository
import id.arieridwan.maverickssample.util.CommonUtil
import io.reactivex.Observable
import io.reactivex.functions.BiFunction

class MovieUseCase(private val movieRepository: MovieRepository) {

    fun loadHomePageMovies(): Observable<HomePage> = Observable.zip(
            movieRepository.loadMovies(CommonUtil.CAT_LATEST, 1),
            movieRepository.loadMovies(CommonUtil.CAT_POPULAR, 1),
            BiFunction<MovieListResponse, MovieListResponse, HomePage> { a, b -> HomePage(a, b) }
    )

    fun loadMovies(category: String, page: Int): Observable<MovieListResponse> = movieRepository.loadMovies(category, page)
}