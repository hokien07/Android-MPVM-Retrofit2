package hokien07.developer.xemhai.presenters;

import java.util.List;

import hokien07.developer.xemhai.managers.PlayListManager;
import hokien07.developer.xemhai.models.Playlist;

public class PlaylistPresenter implements PlaylistPresenterImp.Presenter, PlaylistPresenterImp.Model.OnFinishedListener{

    private PlaylistPresenterImp.View playListView;

    private PlaylistPresenterImp.Model playListModel;

    public PlaylistPresenter (PlaylistPresenterImp.View playListView) {
        this.playListView = playListView;
        this.playListModel = new PlayListManager();
    }

    @Override
    public void onFinish(List<Playlist> playLists) {
        playListView.setDataToRecyclerView(playLists);
        if(playListView != null) playListView.hideProgress();
    }

    @Override
    public void onFailure(String error) {
        playListView.onResponsiveFailure(error);
    }

    @Override
    public void onDestroy() {
        this.playListView = null;
    }

    @Override
    public void getMoreData(int max) {
        if(playListView != null) playListView.showProgress();
        playListModel.getPlaylist(this);
    }

    @Override
    public void requestDataFromServer() {
        if(playListView != null) playListView.showProgress();
        playListModel.getPlaylist(this);
    }
}
