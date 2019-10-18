package hokien07.developer.xemhai.presenters;

import java.util.List;

import hokien07.developer.xemhai.models.Playlist;

public interface PlaylistPresenterImp {
    interface Model{
        interface OnFinishedListener{
            void onFinish(List<Playlist> playLists);

            void onFailure(String error);
        }

        void getPlaylist(OnFinishedListener onFinishedListener);
    }


    interface View {
        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<Playlist> playLists);

        void onResponsiveFailure(String error);

    }


    interface Presenter {
        void onDestroy();

        void getMoreData(int max);

        void requestDataFromServer();
    }
}
