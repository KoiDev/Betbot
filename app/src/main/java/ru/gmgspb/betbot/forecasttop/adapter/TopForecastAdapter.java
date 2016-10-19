package ru.gmgspb.betbot.forecasttop.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.gmgspb.betbot.network.entity.DataTopForecast;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.forecasttop.view.TopForecastDetails;

public class TopForecastAdapter extends RecyclerView.Adapter<TopForecastAdapter.TopForecastViewHolder>{

    private List<DataTopForecast.DataBean> mList;

    public TopForecastAdapter(List<DataTopForecast.DataBean> mList) {
        this.mList = mList;
    }

    @Override
    public TopForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.top_forecast_cv_toplist, parent, false);
        return new TopForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopForecastViewHolder holder, int position) {
        final DataTopForecast.DataBean searchModel = mList.get(position);
        holder.top_forecast_cv_data.setText(searchModel.getDate());
        holder.top_forecast_cv_coms.setText(searchModel.getHome() + " " + searchModel.getAway());
        holder.top_forecast_cv_leagua.setText(searchModel.getLeague());
        holder.top_forecast_cv_count.setText(searchModel.getCount());

        if (position%2 == 1) {
            holder.mCardView.setBackgroundColor(Color.parseColor("#f5f5f5"));
        }

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), TopForecastDetails.class);
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class TopForecastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.top_forecast_cv_data)
        TextView top_forecast_cv_data;
        @BindView(R.id.top_forecast_cv_coms)
        TextView top_forecast_cv_coms;
        @BindView(R.id.top_forecast_cv_leagua)
        TextView top_forecast_cv_leagua;
        @BindView(R.id.top_forecast_cv_count)
        TextView top_forecast_cv_count;
        @BindView(R.id.top_forecast_cv_toplist)
        CardView mCardView;

        public TopForecastViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
