package com.example.youtubeplayer.model.channelList;

import java.util.ArrayList;

public class ChannelList {

    private String name;
    private String subscribenumber;
    private String about;
    private String id;
    private String image_url;

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    private String playlist;

    private Boolean sup_state;
    private ArrayList<String> videosnames;

    public ChannelList(String name,String subscribenumber,String about, String id, String image_url, String playlistName) {
        this.name = name;
        this.subscribenumber = subscribenumber;
        this.about = about;
        this.id = id;
        this.image_url = image_url;
        this.playlist = playlistName;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }


    public Boolean getSup_state() {
        return sup_state;
    }

    public void setSup_state(Boolean sup_state) {
        this.sup_state = sup_state;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSubscribenumber() {
        return subscribenumber;
    }

    public void setSubscribenumber(String subscribenumber) {
        this.subscribenumber = subscribenumber;
    }
    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getVideos() {
        return videosnames;
    }

    public void setVideos(ArrayList<String> videos) {
        this.videosnames = videos;
    }
}