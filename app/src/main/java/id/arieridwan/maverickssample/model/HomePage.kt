package id.arieridwan.maverickssample.model

import id.arieridwan.maverickssample.data.response.MovieListResponse

data class HomePage(val latest: MovieListResponse, val popular: MovieListResponse)