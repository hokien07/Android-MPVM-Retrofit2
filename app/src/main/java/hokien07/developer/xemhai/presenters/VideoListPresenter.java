package hokien07.developer.xemhai.presenters;

import java.util.List;

import hokien07.developer.xemhai.managers.VideoListManager;
import hokien07.developer.xemhai.models.VideoModel;

public class VideoListPresenter implements VideoListPresenterImp.Presenter, VideoListPresenterImp.Model.OnFinishedListener{

    private VideoListPresenterImp.View mainView;

    private VideoListPresenterImp.Model videoModel;

    public VideoListPresenter(VideoListPresenterImp.View view) {
        this.mainView = view;
        videoModel = new VideoListManager();
    }

    @Override
    public void onFinished(List<VideoModel> videoModels) {
        mainView.setDataToRecyclerView(videoModels);
        if(mainView != null) {
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(String error) {
        mainView.onResponseFailure(error);
    }

    @Override
    public void onDestroy() {
        this.mainView = null;

    }

    @Override
    public void getMoreData(int max) {
        if(mainView != null) {
            mainView.showProgress();
        }
        videoModel.getVideoList(this);
    }

    @Override
    public void requestDataFromServer() {
        if(mainView != null) {
            mainView.showProgress();
        }
        videoModel.getVideoList(this);
    }
}
