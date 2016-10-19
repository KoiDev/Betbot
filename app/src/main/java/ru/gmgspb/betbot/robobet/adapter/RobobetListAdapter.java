package ru.gmgspb.betbot.robobet.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ru.gmgspb.betbot.network.entity.RobobetListModel;
import ru.gmgspb.betbot.R;

public class RobobetListAdapter extends RecyclerView.Adapter<RobobetListAdapter.RobobetViewHolder>{

    private List<RobobetListModel> list;

    public RobobetListAdapter(List<RobobetListModel> list) {
        this.list = list;
    }

    @Override
    public RobobetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_robobet, parent, false);
        return new RobobetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RobobetViewHolder holder, int position) {
        RobobetListModel searchModel = list.get(position);
        holder.robobet_list_img.setImageResource(searchModel.getImage());
        holder.robobet_txt.setText(searchModel.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RobobetViewHolder extends RecyclerView.ViewHolder {
        ImageView robobet_list_img;
        TextView robobet_txt;
        CardView cv;

        public RobobetViewHolder(View itemView) {
            super(itemView);
            robobet_list_img = (ImageView) itemView.findViewById(R.id.robobet_list_img);
            robobet_txt = (TextView) itemView.findViewById(R.id.robobet_txt);
            cv = (CardView) itemView.findViewById(R.id.robobet_list_cv);
        }
    }
}
