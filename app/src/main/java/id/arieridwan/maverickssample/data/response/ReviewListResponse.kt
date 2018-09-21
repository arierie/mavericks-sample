package id.arieridwan.maverickssample.data.response

import java.util.*

data class ReviewListResponse(val id: Int = 0, val page: Int = 0, val results: List<ReviewResponse> = ArrayList(),
                              val totalPages: Int = 0, val totalResults: Int = 0)