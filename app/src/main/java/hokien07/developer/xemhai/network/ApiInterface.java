package hokien07.developer.xemhai.network;

import hokien07.developer.xemhai.models.PlaylistResponsiveAPI;
import hokien07.developer.xemhai.models.YoutubeResponAPI;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {
    @GET("playlistItems")
    Call<YoutubeResponAPI> getVideoByListId(
            @Query("part") String snippet,
            @Query("maxResults") int maxValue,
            @Query("playlistId") String listId,
            @Query("key") String apiKey
    );


    @GET("playlists")
    Call<PlaylistResponsiveAPI> getAllListByChannelId(
            @Query("part") String snippet,
            @Query("channelId") String channelId,
            @Query("key") String apiKey
    );
}
