package ru.gmgspb.betbot.main.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
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
import ru.gmgspb.betbot.network.entity.DataMain;

public class MainExpressAdapter extends RecyclerView.Adapter<MainExpressAdapter.MainExpresViewHolder>{
    
    private List<DataMain.DataBean> list;
    private List<DataMain.DataBean.CommandBean> listImg;
    
    public MainExpressAdapter(List<DataMain.DataBean> dataBeen,
                              List<DataMain.DataBean.CommandBean> commandBeen) {
        this.list = dataBeen;
        this.listImg = commandBeen;
    }

    @Override
    public MainExpresViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_main_express, parent, false);
        return new MainExpresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainExpresViewHolder holder, int position) {
        final DataMain.DataBean bean = list.get(position);
        final DataMain.DataBean.CommandBean commandBean = listImg.get(position);
        holder.data.setText(bean.getDate());
        holder.txtHome.setText(commandBean.getHome());
        holder.txtAway.setText(commandBean.getAway());
        holder.imgHome.setImageResource(R.drawable.de_flag);
        holder.imgAway.setImageResource(R.drawable.it_flag);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainExpresViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.main_cv_exp_data)
        TextView data;
        @BindView(R.id.main_cv_exp_home_img)
        ImageView imgHome;
        @BindView(R.id.main_cv_exp_away_img)
        ImageView imgAway;
        @BindView(R.id.main_cv_exp_home_txt)
        TextView txtHome;
        @BindView(R.id.main_cv_exp_away_txt)
        TextView txtAway;
        @BindView(R.id.cv_main_express)
        CardView cardView;
        
        public MainExpresViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
