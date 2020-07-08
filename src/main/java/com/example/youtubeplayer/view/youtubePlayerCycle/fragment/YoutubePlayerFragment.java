package com.example.youtubeplayer.view.youtubePlayerCycle.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youtubeplayer.R;
import com.example.youtubeplayer.adapter.VideoPlayerAdapter;
import com.example.youtubeplayer.model.videoPlayer.VideoPlayer;

import java.util.Vector;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubePlayerFragment extends Fragment {

    RecyclerView recyclerView;
    Vector<VideoPlayer> youtubeVideos = new Vector<VideoPlayer>();
    private VideoPlayerAdapter videoAdapter;
    private Unbinder unbinder;



    public YoutubePlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_youtube_player, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }
    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));

        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=oLLUDOQxJS8\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=U5BwfqBpiWU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=82einkyFns4\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/watch?v=U5BwfqBpiWU\" frameborder=\"0\" allowfullscreen></iframe>") );
        youtubeVideos.add( new VideoPlayer("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/uhQ7mh_o_cM\" frameborder=\"0\" allowfullscreen></iframe>") );

        videoAdapter = new VideoPlayerAdapter(youtubeVideos);

        recyclerView.setAdapter(videoAdapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
