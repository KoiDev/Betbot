package ru.gmgspb.betbot.live.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.sections.helpersDB.ServicesDataSource;
import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;

public class LiveItemListAdapter extends StatelessSection {

    String title;
    List<DataLiveChampionshipList.DataBean.DataDetails> list;
    int myId;

    ServicesDataSource datasourceServices;

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
        final DataLiveChampionshipList.DataBean.DataDetails details = list.get(position);
        itemHolder.txtHome.setText(details.getHome());
        itemHolder.txtAway.setText(details.getAway());
        itemHolder.txtCountHome.setText("  " + details.getRes1());
        itemHolder.txtCountAway.setText(details.getRes2());
        itemHolder.txtMin.setText(details.getLive()); //TODO this

//        datasourceServices = new ServicesDataSource();
//        datasourceServices.open();
//
//        itemHolder.imgFavorite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                HashMap<String, String> paramService = new HashMap<>();
//                paramService.put("id", details.getId());
//                paramService.put("gameId", details.getId());
//                paramService.put("league", details.getLeague());
//                paramService.put("data", details.getDate());
//                paramService.put("home", details.getHome());
//                paramService.put("away", details.getAway());
//                paramService.put("res1", details.getRes1());
//                paramService.put("res2", details.getRes2());
//                paramService.put("live", details.getLive());
//
//
//                itemHolder.imgFavorite.setImageResource(R.drawable.star_live_selected);
//            }
//        });
//
//        datasourceServices.close();
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
        @BindView(R.id.selection_livelist_item_away_txt)
        TextView txtAway;
        @BindView(R.id.selection_livelist_item_min_txt)
        TextView txtMin;
        @BindView(R.id.selection_livelist_item_home_count_txt)
        TextView txtCountHome;
        @BindView(R.id.selection_livelist_item_away_count_txt)
        TextView txtCountAway;
        @BindView(R.id.selection_livelist_item_img)
        ImageView imgFavorite;

        View rootView;

        public ItemViewHolder(View view) {
            super(view);
            rootView = view;
            ButterKnife.bind(this, view);
        }

}
