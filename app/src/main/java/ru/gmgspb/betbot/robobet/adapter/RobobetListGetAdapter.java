package ru.gmgspb.betbot.robobet.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.gmgspb.betbot.network.entity.RobobetGetModel;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.robobet.view.RobobetDetail;

import static ru.gmgspb.betbot.R.id.robobet_com1;

/**
 * Created by User on 005 05.10.16.
 */

public class RobobetListGetAdapter extends RecyclerView.Adapter<RobobetListGetAdapter.RobobetGetViewHolder> {

    private List<RobobetGetModel> listGet;

    public RobobetListGetAdapter(List<RobobetGetModel> list){
        this.listGet = list;
    }

    @Override
    public RobobetGetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_robobet_get, parent, false);
        return new RobobetGetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RobobetGetViewHolder holder, final int position) {
        final RobobetGetModel searchModel = listGet.get(position);
        holder.roboter_com1.setText(searchModel.getHome());
        holder.robobet_com2.setText(searchModel.getAway());
        holder.robobet_com1_per.setText(searchModel.getPercent_home());
        holder.robobet_com1_per.setBackgroundColor(Color.parseColor(searchModel.getPercent_home_color()));
        holder.robobet_com2_per.setText(searchModel.getPercent_away());
        holder.robobet_com2_per.setBackgroundColor(Color.parseColor(searchModel.getPercent_away_color()));
        holder.robobet_com1_kf.setText(searchModel.getKf_home());
        holder.robobet_com2_kf.setText(searchModel.getKf_away());
        holder.robobet_rate_txt.setText(searchModel.getOdds());
        holder.robobet_count.setText(searchModel.getResult_home() + "\n" + searchModel.getResult_away());

        holder.cv_robobet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "Click work");
                Intent intent = new Intent(v.getContext(), RobobetDetail.class);
//                intent.putExtra("message", "My message text");
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listGet.size();
    }

    public class RobobetGetViewHolder extends RecyclerView.ViewHolder {
       TextView roboter_com1, robobet_com2, robobet_com1_per, robobet_com2_per, robobet_com1_kf,
               robobet_com2_kf, robobet_rate_txt, robobet_count;
        CardView cv_robobet;

        public RobobetGetViewHolder(View itemView) {
            super(itemView);
            roboter_com1 = (TextView) itemView.findViewById(robobet_com1);
            robobet_com2 = (TextView) itemView.findViewById(R.id.robobet_com2);
            robobet_com1_per = (TextView) itemView.findViewById(R.id.robobet_com1_per);
            robobet_com2_per = (TextView) itemView.findViewById(R.id.robobet_com2_per);
            robobet_com1_kf = (TextView) itemView.findViewById(R.id.robobet_com1_kf);
            robobet_com2_kf = (TextView) itemView.findViewById(R.id.robobet_com2_kf);
            robobet_rate_txt = (TextView) itemView.findViewById(R.id.robobet_rate_txt);
            robobet_count = (TextView) itemView.findViewById(R.id.robobet_count);
            cv_robobet = (CardView) itemView.findViewById(R.id.cv_robobet_list_get);
        }
    }
}
