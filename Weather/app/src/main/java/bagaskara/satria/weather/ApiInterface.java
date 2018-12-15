package bagaskara.satria.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("forecast")
    Call<WeatherIndukJson>getWheater(@Query("lat")Double lat, @Query("lon")Double lon, @Query("appid")String appid);//Penjelasan getWheater
}
