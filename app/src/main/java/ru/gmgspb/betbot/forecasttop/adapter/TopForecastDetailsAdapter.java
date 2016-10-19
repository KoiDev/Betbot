package ru.gmgspb.betbot.forecasttop.adapter;

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
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.network.entity.DataTopForesastDetails;

public class TopForecastDetailsAdapter extends
        RecyclerView.Adapter<TopForecastDetailsAdapter.TopForecastDetailsViewHolder>{

    List<DataTopForesastDetails.DataBean.DataUsersBean> list;

    public TopForecastDetailsAdapter(List<DataTopForesastDetails.DataBean.DataUsersBean> list){
        this.list = list;
    }

    @Override
    public TopForecastDetailsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listitem_top_forecast_cv_detail, parent, false);
        return new TopForecastDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopForecastDetailsViewHolder holder, int position) {
        final DataTopForesastDetails.DataBean.DataUsersBean usersBean = list.get(position);
        holder.prognosticator.setText(usersBean.getAuthor());
        holder.forecast.setText(usersBean.getOdds());
        holder.percent.setText(usersBean.getProhod());
        holder.profit.setText(usersBean.getProfit());

        if (position % 2 == 1) {
            holder.prognosticator_cv.setBackgroundColor(Color.parseColor("#f5f5f5"));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopForecastDetailsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.top_forecast_details_prognosticator)
        TextView prognosticator;
        @BindView(R.id.top_forecast_details_forecast_cv)
        TextView forecast;
        @BindView(R.id.top_forecast_details_percent_cv)
        TextView percent;
        @BindView(R.id.top_forecast_details_profit_cv)
        TextView profit;
        @BindView(R.id.top_forecast_details_prognosticator_cardview)
        CardView prognosticator_cv;

        public TopForecastDetailsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
