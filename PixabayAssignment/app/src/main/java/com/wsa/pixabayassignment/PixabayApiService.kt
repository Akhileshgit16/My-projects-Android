import com.wsa.pixabayassignment.PixabayResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayService {
    @GET("api/")
    fun getImages(
        @Query("key") apiKey: String,
        @Query("q") query: String,
        @Query("image_type") imageType: String
    ): Call<PixabayResponse>
}
