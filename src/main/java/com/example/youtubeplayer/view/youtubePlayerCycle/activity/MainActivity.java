package com.example.youtubeplayer.view.youtubePlayerCycle.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.youtubeplayer.R;
import com.example.youtubeplayer.view.youtubePlayerCycle.fragment.HomeFragment;
import com.example.youtubeplayer.view.youtubePlayerCycle.fragment.YoutubePlayerFragment;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragment = getSupportFragmentManager()
                .findFragmentById(R.id.container);
        Bundle bundle = getIntent().getExtras();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, new HomeFragment())
                .commit();
    }
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        fragment = getSupportFragmentManager().findFragmentById(R.id.container);

       if (fragment instanceof YoutubePlayerFragment) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new HomeFragment())
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager().popBackStack();
        }

    }
}
