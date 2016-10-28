//package ru.gmgspb.betbot.live.sections;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import ru.gmgspb.betbot.live.adapter.LiveItemListAdapter;
//import ru.gmgspb.betbot.network.api.ApiClient;
//import ru.gmgspb.betbot.network.api.ForecastApi;
//import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
//import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
//
//public class LiveRecyclerServices {
//
//    private static ForecastApi api;
//    public SectionedRecyclerViewAdapter sectionAdapter;
//    public static List<DataLiveChampionship.DataBean> championshipList = new ArrayList<>();
//    private static List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetails = new ArrayList<>();
//    private static int sport_id;
//    private static String item_liga;
//    private static int item_sort;
//    private static int item_liga_pos;
//
//
//    static List<DataLiveChampionship.DataBean> championshipListTemp;
//
//    public static List<DataLiveChampionship.DataBean> getListHeader(int sportId) {
//
//        api = ApiClient.getClient().create(ForecastApi.class);
//
//        Call<DataLiveChampionship> dataBeanCall = api.getСhampionship(sportId, "get_league");
//        sport_id = sportId;
//        dataBeanCall.enqueue(new Callback<DataLiveChampionship>() {
//            @Override
//            public void onResponse(Call<DataLiveChampionship> call, Response<DataLiveChampionship> response) {
//                if (response.body().getTotalevent() > 0) {
//                    championshipList = response.body().getData();
//                    int i = 0;
//                    for (DataLiveChampionship.DataBean getLigua : championshipList) {
//                        getListItem(getLigua.getLeague_id(), sport_id, i);
//                        i++;
//                    }
//                }
//                championshipListTemp = championshipList;
//            }
//
//            @Override
//            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {
//            }
//        });
//        return championshipListTemp;
//    }
//
//
//    static List<DataLiveChampionshipList.DataBean.DataDetails> championshipListDetailsTemp;
//
//    public static List<DataLiveChampionshipList.DataBean.DataDetails> getListItem(String liguaId,
//                                                                                  int sportId,
//                                                                                  int liguaPos) {
//
//        Call<DataLiveChampionshipList> matchi = api.getСhampionshipListGame(sportId, liguaId);
//        item_liga = liguaId;
//        item_sort = sportId;
//        item_liga_pos = liguaPos;
//        championshipListDetailsTemp.clear();
//        matchi.enqueue(new Callback<DataLiveChampionshipList>() {
//            @Override
//            public void onResponse(Call<DataLiveChampionshipList> call,
//                                   Response<DataLiveChampionshipList> response) {
//
//                if (response.body().getTotalevent() > 0) {
//                    for (DataLiveChampionshipList.DataBean detail : response.body().getData()) {
//                        championshipListDetails = detail.getData();
//                        championshipListDetailsTemp = championshipListDetails;
//
//
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DataLiveChampionshipList> call, Throwable t) {
//            }
//        });
//        return championshipListDetailsTemp;
//    }
//
//    private SectionedRecyclerViewAdapter addSectionToRecycler(String league,
//                                                              List<DataLiveChampionshipList.DataBean.DataDetails> listData,
//                                                              int sportId){
//
//        DataLiveChampionship.DataBean bean = championshipList.get(item_liga_pos);
//
//        sectionAdapter.addSection(new LiveItemListAdapter(bean.getLeague(), championshipListDetails, sportId));
//        sectionAdapter.notifyDataSetChanged();
//
//        return sectionAdapter;
//    }
//
//}
