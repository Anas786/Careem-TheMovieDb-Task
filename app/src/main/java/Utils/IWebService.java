package Utils;

import com.example.anas.careemmoviedb.Model.MovieListDataModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Anas on 15-May-18.
 */

public interface IWebService {

//    enum SortBy {
//        RELEASE_DATE_ASCENDING("release_date.asc"),
//        RELEASE_DATE_DESCENDING("release_date.desc");
//
//        String value;
//
//        SortBy(String value) {
//            this.value = value;
//        }
//
//
//        @Override
//        public String toString() {
//            return this.value;
//        }
//    }

    @GET("/3/discover/movie")
    Call<MovieListDataModel> getMovies(@Query("primary_release_date.lte") String releaseDate,
                                       @Query("sort_by") String sortBy, @Query("page") int page,
                                       @Query("api_key") String apiKey);

    @GET("/3/movie/{id}")
    Call<ResponseBody> getMovie(@Path("id") int id);


//    @Headers("Cache-Control: public, max-stale=2419200") // 4 weeks
//    @GET("/3/configuration")
//    Call<Configuration> getConfiguration();

//    @GET("device/get_all")
//    Call<ResponseBody> getBeaconData(@Query("date") String date, @Query("user_id") String userId);

}
