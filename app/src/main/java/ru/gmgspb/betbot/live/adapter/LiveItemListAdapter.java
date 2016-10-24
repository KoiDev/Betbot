package ru.gmgspb.betbot.live.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.fragment.TabFragmentTwo;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;

public class LiveItemListAdapter extends StatelessSection {

    String title;
    List<DataLiveChampionshipList.DataBean.DataDetails> list;
    int myId;

    public LiveItemListAdapter(
            String title, List<DataLiveChampionshipList.DataBean.DataDetails> list, int myId) {
        super(R.layout.section_livelist_header, R.layout.section_livelist_item);
        this.title = title;
        this.list = list;
        this.myId = myId;
    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder) holder;
        DataLiveChampionshipList.DataBean.DataDetails name = list.get(position);
        itemHolder.txtHome.setText(name.getHome());
        itemHolder.txtAway.setText(name.getAway());
        itemHolder.txtCountHome.setText(name.getRes1());
        itemHolder.txtCountAway.setText(name.getRes2());
        itemHolder.txtMin.setText(name.getEnd());

        itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), String.format("Clicked on position #%s of Section %s",
                        TabFragmentTwo.sectionAdapter.getSectionPosition(itemHolder.getAdapterPosition()), title),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
        HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
        headerHolder.tvTitle.setText(title);
    }
}

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.section_livelist_header_txt)
        TextView tvTitle;

        public HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this,view);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.selection_livelist_item_home_txt)
        TextView txtHome;
        @BindView(R.id.selection_livelist_item_away_count_txt)
        TextView txtAway;
        @BindView(R.id.selection_livelist_item_min_txt)
        TextView txtMin;
        @BindView(R.id.selection_livelist_item_home_count_txt)
        TextView txtCountHome;
        @BindView(R.id.selection_livelist_item_away_count_txt)
        TextView txtCountAway;


        View rootView;

        public ItemViewHolder(View view) {
            super(view);
            rootView = view;
            ButterKnife.bind(this, view);
        }

}
