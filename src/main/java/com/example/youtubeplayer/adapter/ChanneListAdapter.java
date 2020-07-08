package com.example.youtubeplayer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeplayer.R;
import com.example.youtubeplayer.helper.ConvertStringToOtherFormat;
import com.example.youtubeplayer.helper.MediaLoader;
import com.example.youtubeplayer.model.channelList.ChannelList;
import com.example.youtubeplayer.view.youtubePlayerCycle.viewmodel.ChannelViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ChanneListAdapter extends RecyclerView.Adapter<ChanneListAdapter.myViewHolder> {
    private ArrayList<ChannelList> channels ;

    private Context context;
    private ChannelViewModel mViewModel;

    public void setContext(Context context) {
        this.context = context;
    }

    public ChanneListAdapter(ArrayList<ChannelList> h, ChannelViewModel mViewModel) {
        channels = h;
        this.mViewModel = mViewModel;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycle_view_channel_list, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.channelNameTvItemRecycViewFragChannelYoutube.setText(channels.get(position).getName());
        holder.subscribeNumbersTvItemRecycViewFragChannelYoutube.setText(ConvertStringToOtherFormat.getIntFromString(channels.get(position).getSubscribenumber()));
        holder.aboutTvItemRecycViewFragChannelYoutube.setText(channels.get(position).getAbout());
        MediaLoader.getInstance().load(holder.channelIvRecycViewFragChannelYoutube,channels.get(position).getImage_url());
    }


    @Override
    public int getItemCount() {
        return channels.size();
    }



    public class myViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.channel_name_tv_item_recyc_view_frag_channel_youtube)
        TextView channelNameTvItemRecycViewFragChannelYoutube;
        @BindView(R.id.subscribe_numbers_tv_item_recyc_view_frag_channel_youtube)
        TextView subscribeNumbersTvItemRecycViewFragChannelYoutube;
        @BindView(R.id.about_tv_item_recyc_view_frag_channel_youtube)
        TextView aboutTvItemRecycViewFragChannelYoutube;
        @BindView(R.id.subscribe_btn_item_recyc_view_frag_channel_list)
        ToggleButton subscribeBtnItemRecycViewFragChannelList;
        @BindView(R.id.state_iv_item_recyc_view_frag_channel_youtube)
        ImageView channelIvRecycViewFragChannelYoutube;
        @BindView(R.id.channel_cv_item_recyc_view_frag_channel_youtube)
        CardView channelCvItemRecycViewFragChannelYoutube;

        private ArrayList<ChannelList> channels;



        public myViewHolder(View view) {
            super(view);

            channelCvItemRecycViewFragChannelYoutube.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int index = 0;
                    for (int i = 0; i < channels.size(); i++) {
                        if (channels.get(i).getName().equals((String) channelNameTvItemRecycViewFragChannelYoutube.getText())) {
                            index = i;
                        }
                    }
                    mViewModel.setThe_intendedChannel(channels.get(index));
                }
            });


        }
        @OnClick(R.id.subscribe_btn_item_recyc_view_frag_channel_list)
        public void onViewClicked() {
            if (!subscribeBtnItemRecycViewFragChannelList.isChecked()) {

                subscribeBtnItemRecycViewFragChannelList.setTextColor(context.getResources().getColor(R.color.gray));
                subscribeBtnItemRecycViewFragChannelList.setBackgroundColor(context.getResources().getColor(R.color.white));
            } else {

                subscribeBtnItemRecycViewFragChannelList.setTextColor(context.getResources().getColor(R.color.white));
                subscribeBtnItemRecycViewFragChannelList.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
            }
        }
    }



}
