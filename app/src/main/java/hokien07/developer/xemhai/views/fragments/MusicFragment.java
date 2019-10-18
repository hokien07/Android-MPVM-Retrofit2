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

public class MusicFragment extends Fragment {

    private static final String TAG = MusicFragment.class.getSimpleName();

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

    }


    private void initView(View view) {

    }
}
