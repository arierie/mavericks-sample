package id.arieridwan.maverickssample.ui.homepage

import com.airbnb.mvrx.Async
import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.Uninitialized
import id.arieridwan.maverickssample.data.response.MovieListResponse
import id.arieridwan.maverickssample.data.response.MovieResponse

data class HomePageState(
        /** We use this request to store the list of all jokes */
        val movies: List<MovieResponse> = emptyList(),
        /** We use this Async to keep track of the state of the current network request */
        val request: Async<MovieListResponse> = Uninitialized
): MvRxState