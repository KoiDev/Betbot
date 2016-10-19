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
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public class LiveGamesListAdapter extends RecyclerView.Adapter<LiveGamesListAdapter.LiveGamesViewHolder>{

    private List<RobobetListModel> list;

    public LiveGamesListAdapter(List<RobobetListModel> list) {
        this.list = list;
    }

    @Override
    public LiveGamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_live_cv_games, parent, false);
        return new LiveGamesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LiveGamesViewHolder holder, int position) {
        RobobetListModel model = list.get(position);
        holder.imgGame.setImageResource(model.getImage());
        holder.txtGame.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LiveGamesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.live_games_list_img)
        ImageView imgGame;
        @BindView(R.id.live_games_txt)
        TextView txtGame;

        public LiveGamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
