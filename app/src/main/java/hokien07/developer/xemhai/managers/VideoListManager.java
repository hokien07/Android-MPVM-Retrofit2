package hokien07.developer.xemhai.managers;

import java.util.List;

import hokien07.developer.xemhai.models.VideoModel;
import hokien07.developer.xemhai.models.YoutubeResponAPI;
import hokien07.developer.xemhai.network.ApiClient;
import hokien07.developer.xemhai.network.ApiInterface;
import hokien07.developer.xemhai.presenters.VideoListPresenterImp;
import hokien07.developer.xemhai.utils.YoutubeView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoListManager implements VideoListPresenterImp.Model {
    private static final String TAG = VideoListManager.class.getSimpleName();
    private YoutubeView youtubeSingleton = YoutubeView.getInstance();

    @Override
    public void getVideoList(OnFinishedListener onFinishedListener) {
        ApiInterface apiService = ApiClient.getRetrofitInstance().create(ApiInterface.class);

        Call<YoutubeResponAPI> call = apiService.getVideoByListId("snippet",50, youtubeSingleton.getListVideoComedy(), youtubeSingleton.getBrowserKey());
        call.enqueue(new Callback<YoutubeResponAPI>() {
            @Override
            public void onResponse(Call<YoutubeResponAPI> call, Response<YoutubeResponAPI> response) {

                if(response.body() != null) {
                    List<VideoModel> videos = response.body().getVideos();
                    onFinishedListener.onFinished(videos);

                }else {
                    onFinishedListener.onFailure("Không có dữ liệu hiển thị");
                }
            }

            @Override
            public void onFailure(Call<YoutubeResponAPI> call, Throwable t) {
                onFinishedListener.onFailure(t.getMessage());
            }
        });
    }
}
