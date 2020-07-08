package com.example.youtubeplayer.view.youtubePlayerCycle.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youtubeplayer.model.channelList.ChannelList;

import java.util.ArrayList;

public class ChannelViewModel extends ViewModel {

    public MutableLiveData<ArrayList<ChannelList>> mutableLiveData = new MutableLiveData<>();
    public MutableLiveData<ChannelList> fragement = new MutableLiveData<>();

    public void setThe_intendedChannel(ChannelList specifiedChannel){
        fragement.setValue(specifiedChannel);

   }



    public void getChannels(){
        ArrayList<ChannelList> channels = getAllChannels();
        mutableLiveData.setValue(channels);
    }

    private ArrayList<ChannelList> getAllChannels(){

        ArrayList<ChannelList> channels =new ArrayList<>();
        channels.add(new ChannelList("Android Developer", "879K subscribers","Android" ,"https://yt3.ggpht.com/a/AATXAJz-xXlS2ao5fm1K97AbykChh3X6jnltOvyBBQ=s88-c-k-c0xffffffff-no-rj-mo" ,
                "https://www.youtube.com/channel/UCVHFbqXqoYvEWM1Ddxl0QDg","PLWz5rJ2EKKc_HHVa1JEL7vnBTr6fFezqO"));
        channels.add(new ChannelList("coding with nerd", "4.15K subscribers","Android" ,"https://yt3.ggpht.com/a/AATXAJzfPgD-wLHJvZhq4CfQE69_KYMk7NEOnE_cGQ=s88-c-k-c0xffffffff-no-rj-mo" ,
                "https://www.youtube.com/channel/UCnDAXfhnL5j-KhHc1KhvXHw","PLXjbGq0ERjFq0KvT7clQoOxM5TTd03yji"));
        channels.add(new ChannelList("CodingWithMitch","83K subscribers","Android", "https://www.youtube.com/channel/UCoNZZLhPuuRteu02rh7bzsw",
                "https://yt3.ggpht.com/a/AATXAJzeVaKgaaldp7IpjgXSWImHTNV9kDqkrCJrMQ=s288-c-k-c0xffffffff-no-rj-mo"
                , "PLgCYzUzKIBE-8wE9Sv3yzYZlo70PBmFPz"));
        channels.add(new ChannelList("Raqami tv ", "2.25M subscribers","technology","https://www.youtube.com/c/raqamitv/featured",
                "https://yt3.ggpht.com/a/AATXAJyI33vhIhHdJahKN-IohVcWv55n3xtaeTEqXsgaiQ=s48-c-k-c0xffffffff-no-rj-mo"
                , "PLJuNYYTMwpi3R5htDsM90Zz0EIQsS4IEY"));
        channels.add(new ChannelList("S7S  ", "4.98M subscribers","Food","https://www.youtube.com/channel/UCtdKiwN9vw961uho0lre4_A",
                "https://yt3.ggpht.com/a/AATXAJwfEQJbOFpggXtU4VFwJDORcLqGllbMno3Dc90_=s100-c-k-c0xffffffff-no-rj-mo"
                , "PLwC_IJcwydyUG7BJiYIN0YX_fnlYDmu-u"));
        return channels;
    }

}
