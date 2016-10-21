package ru.gmgspb.betbot.live.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.gmgspb.betbot.R;

public class MyItemViewHolder extends RecyclerView.ViewHolder {

    public final TextView tvItem;

    public MyItemViewHolder(View itemView) {
        super(itemView);

        tvItem = (TextView) itemView.findViewById(R.id.selection_livelist_item_home_txt);
    }
}