package ru.gmgspb.betbot.live.sections;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.MyItemViewHolder;
//import ru.gmgspb.betbot.live.adapter.

public class MySection extends StatelessSection {

    List<String> myList = Arrays.asList("Item1", "Item2", "Item3");

    public MySection() {
        // call constructor with layout resources for this Section header and items
        super(R.layout.section_livelist_header, R.layout.section_livelist_item);
    }

    @Override
    public int getContentItemsTotal() {
        return myList.size(); // number of items of this section
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        // return a custom instance of ViewHolder for the items of this section
        return new MyItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyItemViewHolder itemHolder = (MyItemViewHolder) holder;

        //@BindView(R.id.selection_livelist_item_home_txt)
        //TextView txtHome;
        // bind your view here
//        itemHolder.tvItem.setText(myList.get(position));
        itemHolder.tvItem.setText(myList.get(position));
    }
}