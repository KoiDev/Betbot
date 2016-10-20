package ru.gmgspb.betbot.live.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.gmgspb.betbot.R;

/**
 * Created by koidev on 20/10/16.
 */

public class TabFragmentTwo extends Fragment{

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;

    public TabFragmentTwo(){

    }

    public static TabFragmentTwo newInstance(String example_argument){
        TabFragmentTwo oneFragment = new TabFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argument);
        oneFragment.setArguments(args);
        return oneFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        example_data = getArguments().getString(ARG_EXAMPLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_live_tablive, container, false);
    }
}
