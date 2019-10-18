package hokien07.developer.xemhai.views.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import hokien07.developer.xemhai.R;
import hokien07.developer.xemhai.utils.YoutubeView;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class VideoDetailActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView youTubeView;
    private String VIDEO_ID;
    private String TITLE_VIDEO;

    private TextView videoTitle;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        getIntetFromActivity();
        initView();
    }

    private void getIntetFromActivity() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            VIDEO_ID = bundle.getString("VIDEO_ID");
            TITLE_VIDEO = bundle.getString("TITLE_VIDEO");
        }

        Log.i(TAG, "getIntetFromActivity: "+ VIDEO_ID);
    }


    private void initView() {
        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youTubeView.initialize(YoutubeView.getInstance().getApiKey(), this);

        videoTitle = findViewById(R.id.videoTitle);
        videoTitle.setText(TITLE_VIDEO);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getResources().getString(R.string.app_name));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_back));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VideoDetailActivity.this, VideoListActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.setShowFullscreenButton(true);
            youTubePlayer.cueVideo(VIDEO_ID);
            youTubePlayer.play();
        }
    }


    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        String error = "Không thể load video! Kiểm tra Internet và ứng dụng Youtube trên máy của bạn!";
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        youTubeView.removeAllViews();
        toolbar = null;
        videoTitle = null;
    }
}
