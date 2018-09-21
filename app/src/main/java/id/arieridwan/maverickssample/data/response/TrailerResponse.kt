package id.arieridwan.maverickssample.data.response

data class TrailerResponse(val id: String, val iso_639_1: String, val iso_3166_1: String,
                           val key: String, val name: String, val site: String,
                           val size: Int = 0, val type: String)