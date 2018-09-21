package id.arieridwan.maverickssample.data.response

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

class MovieResponse (val title: String, @Json(name = "poster_path") val posterPath: String, val overview: String,
                     @Json(name = "backdrop_path") val backdropPath: String, @Json(name = "release_date") val releaseDate: String,
                     val id: Int = 0, val video: Boolean = false, @Json(name = "vote_average") val voteAverage: Double = 0.toDouble(),
                     val popularity: Double = 0.toDouble()): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readByte() != 0.toByte(),
            parcel.readDouble(),
            parcel.readDouble())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(posterPath)
        parcel.writeString(overview)
        parcel.writeString(backdropPath)
        parcel.writeString(releaseDate)
        parcel.writeInt(id)
        parcel.writeByte(if (video) 1 else 0)
        parcel.writeDouble(voteAverage)
        parcel.writeDouble(popularity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MovieResponse> {
        override fun createFromParcel(parcel: Parcel): MovieResponse {
            return MovieResponse(parcel)
        }

        override fun newArray(size: Int): Array<MovieResponse?> {
            return arrayOfNulls(size)
        }
    }
}
