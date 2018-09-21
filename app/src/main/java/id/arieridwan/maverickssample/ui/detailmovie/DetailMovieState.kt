package id.arieridwan.maverickssample.ui.detailmovie

import android.annotation.SuppressLint
import android.os.Parcelable
import com.airbnb.mvrx.MvRxState
import id.arieridwan.maverickssample.data.response.MovieResponse
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class DetailMovieArgs(val id: Int, val movie: MovieResponse) : Parcelable

data class DetailMovieState(val id: Int, val movie: MovieResponse): MvRxState {

    /**
     * This secondary constructor will automatically called if your Fragment has
     * a parcelable in its arguments at key [com.airbnb.mvrx.MvRx.KEY_ARG]
     */
    constructor(args: DetailMovieArgs) : this(args.id, args.movie)

}