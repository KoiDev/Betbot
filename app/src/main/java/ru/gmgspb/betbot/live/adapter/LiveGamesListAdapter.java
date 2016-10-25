package ru.gmgspb.betbot.live.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.common.ChoisePictureListGame;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

public class LiveGamesListAdapter extends RecyclerView.Adapter<LiveGamesListAdapter.LiveGamesViewHolder>{

    private List<RobobetListModel.DataBean> list;
    int mCurrentItemPosition = -1;
    int previous=-1;
    Boolean itemRepeat = false;

    public LiveGamesListAdapter(List<RobobetListModel.DataBean> list, LiveGamesListAdapterListener listener) {
        this.list = list;
        onClickListener = listener;
    }



    @Override
    public LiveGamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_live_cv_games, parent, false);
        return new LiveGamesViewHolder(view);
    }

    public LiveGamesListAdapterListener onClickListener;

    public interface LiveGamesListAdapterListener {

        void liveGamesListViewOnClick(View v, int position);
    }

    @Override
    public void onBindViewHolder(LiveGamesViewHolder holder, int position) {
        RobobetListModel.DataBean model = list.get(position);
        holder.imgGame.setImageResource(ChoisePictureListGame.getImage(model.getName()));
        holder.txtGame.setText(model.getName());
        if (previous == -1){
            holder.txtGame.setTextColor(Color.parseColor("#ffffff"));
            holder.imgSelect.setVisibility(View.VISIBLE);
            mCurrentItemPosition = 0;
            previous = 0;/*
        }else if (itemRepeat == true){
            holder.txtGame.setTextColor(Color.parseColor("#ffffff"));
            holder.imgSelect.setVisibility(View.VISIBLE);
            itemRepeat = false;*/
        }else if(mCurrentItemPosition == position){
            holder.txtGame.setTextColor(Color.parseColor("#ffffff"));
            holder.imgSelect.setVisibility(View.VISIBLE);
        } else {
            holder.txtGame.setTextColor(Color.parseColor("#0277bd"));
            holder.txtGame.setTag(1);
            holder.imgSelect.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LiveGamesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.live_games_list_img)
        ImageView imgGame;
        @BindView(R.id.live_games_list_txt)
        TextView txtGame;
        @BindView(R.id.live_games_list_select)
        ImageView imgSelect;
        @BindView(R.id.live_list_rl)
        RelativeLayout rl;

        public LiveGamesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            rl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int ItemSelectedState = (int) txtGame.getTag();

                    int previousPosition = mCurrentItemPosition;
                    if (ItemSelectedState == 1) {

                        mCurrentItemPosition = getAdapterPosition();

                        txtGame.setTextColor(Color.parseColor("#ffffff"));
                        txtGame.setTag(2);
                        imgSelect.setVisibility(View.VISIBLE);
/*
                        if (mCurrentItemPosition == previous){
                            itemRepeat = true;
                        }else previous = mCurrentItemPosition;      */

                    } else {
                        mCurrentItemPosition = -1;
                        txtGame.setTextColor(Color.parseColor("#0277bd"));
                        txtGame.setTag(1);
                        imgSelect.setVisibility(View.GONE);
                    }

                    if(previousPosition != -1) {
                        notifyItemChanged(previousPosition);

                    }
                    onClickListener.liveGamesListViewOnClick(v, getAdapterPosition());

                }
            });
        }

    }
}
