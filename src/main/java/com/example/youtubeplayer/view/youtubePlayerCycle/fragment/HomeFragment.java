package com.example.youtubeplayer.view.youtubePlayerCycle.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.youtubeplayer.R;
import com.example.youtubeplayer.adapter.ChanneListAdapter;
import com.example.youtubeplayer.model.channelList.ChannelList;
import com.example.youtubeplayer.view.youtubePlayerCycle.viewmodel.ChannelViewModel;

import java.util.ArrayList;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class HomeFragment extends Fragment {

    @BindView(R.id.search_et_frag_home__channel_list_youtube)
    EditText searchEtFragHomeChannelListYoutube;
    @BindView(R.id.rv_frag_channel_list_youtube)
    RecyclerView rvFragchannelListClient;
    private Unbinder unbinder;
    private ChannelViewModel mViewModel;
    private Context context ;

    public void setContext(Context context){
        this.context = context;
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initViews(rvFragchannelListClient);
        setEditTextListener();
        return view;
    }

    private void setEditTextListener() {
        searchEtFragHomeChannelListYoutube.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                }


            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initViews(final RecyclerView recyclerView) {

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        mViewModel = new ViewModelProvider(this).get(ChannelViewModel.class);
        mViewModel.getChannels();
        mViewModel.mutableLiveData.observe(getViewLifecycleOwner(), new Observer<ArrayList<ChannelList>>() {
            @Override
            public void onChanged(ArrayList<ChannelList> channelLists) {
                ChanneListAdapter adapter = new ChanneListAdapter(channelLists, mViewModel);
                adapter.setContext(context);
                recyclerView.setAdapter(adapter);
            }
        });
        mViewModel = new ViewModelProvider(this).get(ChannelViewModel.class);
        mViewModel.fragement.observe(getViewLifecycleOwner(), new Observer<ChannelList>() {
            @Override
            public void onChanged(ChannelList selectedChannel) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, new YoutubePlayerFragment())
                        .addToBackStack(null)
                        .commit();

            }
        });


    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}

