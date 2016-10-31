package ru.gmgspb.betbot.live.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.network.entity.DataLiveChampionship;

public class LiveAllGamesHeaderOtherAdapter extends RecyclerView.Adapter<LiveAllGamesHeaderOtherAdapter.LiveAllGamesHeaderOtherViewHolder>{


    List<DataLiveChampionship.DataBean> list;

    public LiveAllGamesHeaderOtherAdapter(List<DataLiveChampionship.DataBean> list) {
        this.list = list;

    }

    @Override
    public LiveAllGamesHeaderOtherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_live_cv_games, parent, false);
        return new LiveAllGamesHeaderOtherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveAllGamesHeaderOtherViewHolder holder, int position) {
        DataLiveChampionship.DataBean dataBean = list.get(position);

        holder.txtLeagueNew.setText(dataBean.getLeague());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LiveAllGamesHeaderOtherViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.live_all_games_detail_header_txt)
        TextView txtLeagueNew;
        @BindView(R.id.live_all_games_count)
        TextView txtCountGames;
        @BindView(R.id.live_all_games_favorite_img)
        ImageView imgLogoLeague;

        public LiveAllGamesHeaderOtherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
