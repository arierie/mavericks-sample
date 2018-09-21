package id.arieridwan.maverickssample.data

import id.arieridwan.maverickssample.data.response.MovieListResponse
import id.arieridwan.maverickssample.data.response.ReviewListResponse
import id.arieridwan.maverickssample.data.response.TrailerListResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by arieridwan on 31/08/18.
 */

interface ApiService {

    @GET("movie/{category}")
    fun getMovies(@Path("category") category: String, @Query("api_key") apiKey: String,
                         @Query("page") page: Int): Observable<MovieListResponse>

    @GET("movie/{id}/videos")
    fun getTrailer(@Query("api_key") apiKey: String, @Path("id") id: Int): Observable<TrailerListResponse>

    @GET("movie/{id}/reviews")
    fun getReviews(@Query("api_key") apiKey: String, @Path("id") id: Int): Observable<ReviewListResponse>

}