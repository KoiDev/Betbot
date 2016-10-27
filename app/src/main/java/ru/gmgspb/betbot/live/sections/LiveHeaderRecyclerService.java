//package ru.gmgspb.betbot.live.sections;
//
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import ru.gmgspb.betbot.live.adapter.LiveItemListAdapter;
//import ru.gmgspb.betbot.network.entity.DataLiveChampionship;
//import ru.gmgspb.betbot.network.entity.DataLiveChampionshipList;
//
///**
// * Created by koidev on 26/10/16.
// */
//
//public class LiveHeaderRecyclerService (int sportId){
//
//
//    private void getListHeader(int sportId) {
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
//            }
//            @Override
//            public void onFailure(Call<DataLiveChampionship> call, Throwable t) {
//            }
//        });
//    }
//
//    private void getListItem(String liguaId, int sportId, int liguaPos) {
//
//        Call<DataLiveChampionshipList> matchi = api.getСhampionshipListGame(sportId, liguaId);
//        item_liga = liguaId;
//        item_sort = sportId;
//        item_liga_pos = liguaPos;
//        matchi.enqueue(new Callback<DataLiveChampionshipList>() {
//            @Override
//            public void onResponse(Call<DataLiveChampionshipList> call, Response<DataLiveChampionshipList> response) {
//                if (response.body().getTotalevent() > 0) {
//                    for (DataLiveChampionshipList.DataBean detail : response.body().getData()) {
//                        championshipListDetails = detail.getData();
//                    }
//                    DataLiveChampionship.DataBean bean = championshipList.get(item_liga_pos);
//                    sectionAdapter.addSection(new LiveItemListAdapter(
//                            bean.getLeague(), championshipListDetails, item_sort));
//
//                    sectionAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DataLiveChampionshipList> call, Throwable t) {
//            }
//        });
//    }
//}
