package ru.gmgspb.betbot.main.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.network.entity.DataMain;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private List<DataMain.DataBean> list;
    private List<DataMain.DataBean.CommandBean> listImg;

    public MainAdapter(List<DataMain.DataBean> list, List<DataMain.DataBean.CommandBean> listImg) {
        this.list = list;
        this.listImg = listImg;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_main, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        final DataMain.DataBean dataBean = list.get(position);
        final DataMain.DataBean.CommandBean dataImg = listImg.get(position);
        holder.data.setText("19.09.16 16:32"); //TODO: data correct
        holder.imgHome.setImageResource(R.drawable.de_flag);
        holder.imgAway.setImageResource(R.drawable.it_flag);
        holder.txtHome.setText(dataImg.getHome());
        holder.txtAway.setText(dataImg.getAway());
        holder.txtForecast.setText("П1"); //TODO: WTF, man, what you do?! Stop!!!!
        holder.txtKf.setText("2.0");
        holder.txtRate.setText("60");
        holder.txtAbout.setText("Поставлю 0,5 на такой матч. Ставлю против правильной ставки поэтому в лайве маст хев сидеть");
        holder.txtEmail.setText("JackPot@ss.org");
        //TODO: color for ratting player
        holder.txtRating.setText(dataBean.getUser_bank()+"("+dataBean.getUser_rating()+"%)");
//        holder.txtComments.setText(dataBean.getComm_num());
//        holder.txtViews.setText(dataBean.getView_num());

        holder.league.setText(dataBean.getLeague());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.main_cv_data)
        TextView data;
        @BindView(R.id.main_cv_home_img)
        ImageView imgHome;
        @BindView(R.id.main_cv_away_img)
        ImageView imgAway;
        @BindView(R.id.main_cv_home_txt)
        TextView txtHome;
        @BindView(R.id.main_cv_away_txt)
        TextView txtAway;
        @BindView(R.id.main_cv_forecast)
        TextView txtForecast;
        @BindView(R.id.main_cv_kf)
        TextView txtKf;
        @BindView(R.id.main_cv_rate)
        TextView txtRate;
        @BindView(R.id.main_cv_about_txt)
        TextView txtAbout;
        @BindView(R.id.main_cv_email_txt)
        TextView txtEmail;
        @BindView(R.id.main_cv_rating_txt)
        TextView txtRating;
//        @BindView(R.id.main_cv_comments_txt)
//        TextView txtComments;
//        @BindView(R.id.main_cv_vievs_txt)
//        TextView txtViews;
        @BindView(R.id.main_cv_league)
        TextView league;

        public MainViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
