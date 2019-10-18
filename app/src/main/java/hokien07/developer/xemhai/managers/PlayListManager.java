package hokien07.developer.xemhai.managers;

import java.util.List;

import hokien07.developer.xemhai.models.Playlist;
import hokien07.developer.xemhai.models.PlaylistResponsiveAPI;
import hokien07.developer.xemhai.network.ApiClient;
import hokien07.developer.xemhai.network.ApiInterface;
import hokien07.developer.xemhai.presenters.PlaylistPresenterImp;
import hokien07.developer.xemhai.utils.YoutubeView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlayListManager implements PlaylistPresenterImp.Model {

    private static final String TAG = PlayListManager.class.getSimpleName();
    private YoutubeView youtubeSingleton = YoutubeView.getInstance();

    @Override
    public void getPlaylist(OnFinishedListener onFinishedListener) {
        ApiInterface apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        Call<PlaylistResponsiveAPI> call = apiService.getAllListByChannelId("snippet", youtubeSingleton.getChannelId(), youtubeSingleton.getBrowserKey());
        call.enqueue(new Callback<PlaylistResponsiveAPI>() {
            @Override
            public void onResponse(Call<PlaylistResponsiveAPI> call, Response<PlaylistResponsiveAPI> response) {
                if(response.body() != null) {
                    List<Playlist> playLists = response.body().getPlaylists();
                    onFinishedListener.onFinish(playLists);
                }
            }

            @Override
            public void onFailure(Call<PlaylistResponsiveAPI> call, Throwable t) {
                onFinishedListener.onFailure(t.getMessage());
            }
        });
    }
}
