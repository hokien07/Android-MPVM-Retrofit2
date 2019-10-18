package hokien07.developer.xemhai.presenters;

import java.util.List;

import hokien07.developer.xemhai.models.VideoModel;

public interface VideoListPresenterImp {
    interface Model {
        interface OnFinishedListener {
            void onFinished(List<VideoModel> videoModels);

            void onFailure(String error);
        }

        void getVideoList(OnFinishedListener onFinishedListener);
    }


    interface View {
        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(List<VideoModel> videoModels);

        void onResponseFailure(String error);
    }

    interface Presenter {
        void onDestroy();

        void getMoreData(int max);

        void requestDataFromServer();



    }
}
