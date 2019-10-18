package hokien07.developer.xemhai.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hokien07.developer.xemhai.BaseActivity;
import hokien07.developer.xemhai.R;
import hokien07.developer.xemhai.adapters.VideoAdapter;
import hokien07.developer.xemhai.models.Snippet;
import hokien07.developer.xemhai.models.VideoModel;
import hokien07.developer.xemhai.presenters.VideoListPresenter;
import hokien07.developer.xemhai.presenters.VideoListPresenterImp;

public class VideoListActivity extends BaseActivity implements VideoListPresenterImp.View {
    private static final String TAG = VideoListActivity.class.getSimpleName();

    private Toolbar toolbar;
    private VideoListPresenter videoListPresenter;
    private RecyclerView recyclerView;
    private List<VideoModel> videos;
    private VideoAdapter adapter;
    private ProgressBar pbLoading;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        videoListPresenter = new VideoListPresenter(this);
        videoListPresenter.requestDataFromServer();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initView() {

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Video Tổng hợp");

        recyclerView = findViewById(R.id.video_list);
        videos = new ArrayList<>();
        adapter = new VideoAdapter(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        pbLoading = findViewById(R.id.pbLoading);
        pbLoading.setVisibility(View.GONE);


        adapter.setOnItemClickListener(new VideoAdapter.OnitemClickListenner() {
            @Override
            public void onVideoClick(VideoModel videoModel) {
                Snippet snippet = videoModel.getSnippet();
                Intent intent = new Intent(VideoListActivity.this, VideoDetailActivity.class);
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

    }
}
