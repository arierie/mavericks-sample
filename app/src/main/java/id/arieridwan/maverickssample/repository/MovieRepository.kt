package id.arieridwan.maverickssample.repository

import id.arieridwan.maverickssample.BuildConfig
import id.arieridwan.maverickssample.data.ApiService
import id.arieridwan.maverickssample.data.response.MovieListResponse
import io.reactivex.Observable

class MovieRepository(private val apiService: ApiService) {

    fun loadMovies(category: String, page: Int): Observable<MovieListResponse> =
            apiService.getMovies(category, BuildConfig.ApiKey, page)

}