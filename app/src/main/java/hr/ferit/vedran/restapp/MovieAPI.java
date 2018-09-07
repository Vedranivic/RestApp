package hr.ferit.vedran.restapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by vedra on 24.8.2018..
 */

public interface MovieAPI {
    @GET(".?r=json&type=movie")
    Call<SearchResult> getMovies(@Query("s") String title, @Query("apikey") String apikey);
}
