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

public class TabFragmentOne extends Fragment{

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;

    public TabFragmentOne(){

    }

    public static TabFragmentOne newInstance(String example_argument){
        TabFragmentOne tabFragmentOne = new TabFragmentOne();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argument);
        tabFragmentOne.setArguments(args);
        return tabFragmentOne;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        example_data = getArguments().getString(ARG_EXAMPLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }
}
