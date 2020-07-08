package com.example.youtubeplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplayer.R;
import com.example.youtubeplayer.model.videoPlayer.VideoPlayer;

import java.util.List;

import butterknife.BindView;

public class VideoPlayerAdapter extends RecyclerView.Adapter<VideoPlayerAdapter.VideoViewHolder> {

    List<VideoPlayer> youtubeVideoPlayer;


    public VideoPlayerAdapter() {
    }

    public VideoPlayerAdapter(List<VideoPlayer> youtubeVideoPlayer) {
        this.youtubeVideoPlayer = youtubeVideoPlayer;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_youtube_player, parent, false);

        return new VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {

        holder.videoWebView.loadData(youtubeVideoPlayer.get(position).getVideoUrl(), "text/html", "utf-8");

    }

    @Override
    public int getItemCount() {
        return youtubeVideoPlayer.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.videoWebView)
        WebView videoWebView;

        public VideoViewHolder(View itemView) {
            super(itemView);


            videoWebView.getSettings().setJavaScriptEnabled(true);
            videoWebView.setWebChromeClient(new WebChromeClient() {

            });
        }
    }
}