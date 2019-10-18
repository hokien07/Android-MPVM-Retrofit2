package hokien07.developer.xemhai.views.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import hokien07.developer.xemhai.R;
import hokien07.developer.xemhai.adapters.VideoAdapter;
import hokien07.developer.xemhai.models.Snippet;
import hokien07.developer.xemhai.models.VideoModel;
import hokien07.developer.xemhai.presenters.VideoListPresenter;
import hokien07.developer.xemhai.presenters.VideoListPresenterImp;
import hokien07.developer.xemhai.views.activitys.VideoDetailActivity;

public class MusicFragment extends Fragment implements VideoListPresenterImp.View {

    private static final String TAG = MusicFragment.class.getSimpleName();

    private VideoListPresenter videoListPresenter;
    private RecyclerView recyclerView;
    private List<VideoModel> videos;
    private VideoAdapter adapter;
    private ProgressBar pbLoading;

    private MusicFragment() {

    }

    public static MusicFragment getInstance() {
       MusicFragment musicFragment = new MusicFragment();
       Bundle bundle = new Bundle();
       musicFragment.setArguments(bundle);
       return musicFragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Initializing presenter
        videoListPresenter = new VideoListPresenter(this);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        initView(view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoListPresenter.requestDataFromServer();
    }



    private void initView(View view) {
        recyclerView = view.findViewById(R.id.video_list);
        videos = new ArrayList<>();
        adapter = new VideoAdapter(getContext());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        pbLoading = view.findViewById(R.id.pbLoading);
        pbLoading.setVisibility(View.GONE);


        adapter.setOnItemClickListener(new VideoAdapter.OnitemClickListenner() {
            @Override
            public void onVideoClick(VideoModel videoModel) {
                Snippet snippet = videoModel.getSnippet();
                Intent intent = new Intent(getContext(), VideoDetailActivity.class);
                intent.putExtra("VIDEO_ID", snippet.getResourceId().getVideoId());
                intent.putExtra("TITLE_VIDEO", snippet.getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setDataToRecyclerView(List<VideoModel> videoModels) {
        adapter.submitList(videoModels);
    }

    @Override
    public void onResponseFailure(String error) {
        Log.e(TAG, "onResponseFailure: " + error );
    }
}
