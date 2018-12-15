package bagaskara.satria.restclient;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("photos")
    Call<List<Photo>>getPhotos();

    @GET("photos/{id}")
    Call<Photo>getPhotoById(@Path("id")int id);

    @GET("photos")
    Call<List<Photo>>getPhotoByAlbumId(@Query("albumId")int albumId);
}
