package ru.gmgspb.betbot.forecast.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.network.api.GetDescriptionForecastApi;
import ru.gmgspb.betbot.network.entity.DataForecast;
import ru.gmgspb.betbot.network.entity.GetDescriptionForecastModel;
import ru.gmgspb.betbot.network.repository.GetDescriptionForecastService;


public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<DataForecast.DataBean> list;

    public ForecastAdapter(List<DataForecast.DataBean> list) {
        this.list = list;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.listitem_forecast, parent, false);
        return new ForecastViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ForecastViewHolder holder, final int position) {
        final DataForecast.DataBean searchModel = list.get(position);
        holder.timedate.setText(searchModel.getDate());
        holder.game.setText(searchModel.getCommand());
        holder.forecast.setText("Фора1 по очкам (-4.5) @ " + searchModel.getKf());
        holder.about.setVisibility(View.GONE);
        holder.cv_forecast.setBackgroundResource(R.color.white);

        holder.cv_forecast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.about.getVisibility() == View.GONE) {

                    GetDescriptionForecastApi service =
                            GetDescriptionForecastService.getInstance(holder.cv_forecast.getContext()).getApi();
                    Call<GetDescriptionForecastModel> descriptionCall =
                            service.getList(searchModel.getId());

                    descriptionCall.enqueue(new Callback<GetDescriptionForecastModel>() {
                        @Override
                        public void onResponse(Call<GetDescriptionForecastModel> call, Response<GetDescriptionForecastModel> response) {
                            GetDescriptionForecastModel dataDescription = response.body();
                            holder.about.setText(dataDescription.getData());
                            holder.about.setVisibility(View.VISIBLE);
                            holder.cv_forecast.setBackgroundResource(R.color.forecast_about_all);
                        }

                        @Override
                        public void onFailure(Call<GetDescriptionForecastModel> call, Throwable t) {
                            Log.e("Tag", t.getMessage());
                        }
                    });

                } else {
                    holder.about.setVisibility(View.GONE);
                    holder.cv_forecast.setBackgroundResource(R.color.white);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ForecastViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_forecast_timedate)
        TextView timedate;
        TextView game, forecast, score, about;
        @BindView(R.id.cv_forecast)
        CardView cv_forecast;
        public ForecastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            timedate = (TextView) itemView.findViewById(R.id.txt_forecast_timedate);
            game = (TextView) itemView.findViewById(R.id.txt_forecast_game);
            forecast = (TextView) itemView.findViewById(R.id.txt_forecast_forecast);
            score = (TextView) itemView.findViewById(R.id.txt_forecast_score);
            about = (TextView) itemView.findViewById(R.id.forecast_txt_about);
        }
    }


}
