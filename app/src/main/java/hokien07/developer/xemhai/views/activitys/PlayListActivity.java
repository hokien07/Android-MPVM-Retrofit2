package hokien07.developer.xemhai.views.activitys;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import hokien07.developer.xemhai.BaseActivity;
import hokien07.developer.xemhai.R;
import hokien07.developer.xemhai.views.fragments.MusicFragment;

public class PlayListActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        initView();
        loadFragment(MusicFragment.getInstance());
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);

        BottomNavigationView navigationView = findViewById(R.id.bottom_navigation);
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.navigation_music:
                toolbar.setTitle("Top Nhạc nghe nhiều nhất");
                fragment = MusicFragment.getInstance();
                loadFragment(fragment);
                return true;
            case R.id.navigation_arts:
                toolbar.setTitle("Top Video võ thuật xem nhiều nhất");
                fragment = MusicFragment.getInstance();
                loadFragment(fragment);
                return true;
            case R.id.navigation_tv:
                toolbar.setTitle("Top chương trình xem nhiều nhất");
                fragment = MusicFragment.getInstance();
                loadFragment(fragment);
                return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
