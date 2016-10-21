package ru.gmgspb.betbot.live.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.live.adapter.LiveGamesListAdapter;
import ru.gmgspb.betbot.live.sections.MySection;
import ru.gmgspb.betbot.network.api.ForecastApi;
import ru.gmgspb.betbot.network.entity.RobobetListModel;
import ru.gmgspb.betbot.network.repository.ForecastService;

public class TabFragmentTwo extends Fragment {

    private static final String ARG_EXAMPLE = "this_a_constant";
    private String example_data;

    public TabFragmentTwo() {

    }

    public static TabFragmentTwo newInstance(String example_argument) {
        TabFragmentTwo oneFragment = new TabFragmentTwo();
        Bundle args = new Bundle();
        args.putString(ARG_EXAMPLE, example_argument);
        oneFragment.setArguments(args);
        return oneFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        example_data = getArguments().getString(ARG_EXAMPLE);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_live_tablive, container, false);
        initRecyclerViewList(view);

        return view;
    }

    private void initRecyclerViewList(final View view) {
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.fragment_live_rv); //TODO ERROR
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);

        ForecastApi api = ForecastService.getInstance(view.getContext()).getApi();
        final Call<RobobetListModel> robobetListModelCall = api.getSportList();

        robobetListModelCall.enqueue(new Callback<RobobetListModel>() {
            @Override
            public void onResponse(Call<RobobetListModel> call, Response<RobobetListModel> response) {
                final RobobetListModel model = response.body();
                LiveGamesListAdapter adapter = new LiveGamesListAdapter(model.getData(), new LiveGamesListAdapter.LiveGamesListAdapterListener() {
                    @Override
                    public void liveGamesListViewOnClick(View v, int position) {
                        RobobetListModel.DataBean bean = (RobobetListModel.DataBean) model.getData();
                        initRecyclerViewListGames(bean.getId(), view);
                    }
                });
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<RobobetListModel> call, Throwable t) {
                Log.e("Tag", t.getMessage());
            }
        });

    }

    private SectionedRecyclerViewAdapter sectionAdapter;

    private void initRecyclerViewListGames(int id, View view) {

    /*    // Create an instance of SectionedRecyclerViewAdapter
        sectionAdapter = new SectionedRecyclerViewAdapter();

// Add your Sections
        sectionAdapter.addSection(new MySection());

// Set up your RecyclerView with the SectionedRecyclerViewAdapter
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.live_tablelive_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(sectionAdapter);
    }*/

        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            List<String> contacts = getContactsWithLetter(alphabet);

            if (contacts.size() > 0) {
                sectionAdapter.addSection(new ContactsSection(String.valueOf(alphabet), contacts));
            }
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.live_tablelive_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(sectionAdapter);
    }

    private List<String> getContactsWithLetter(char letter) {
        List<String> contacts = new ArrayList<>();

        for (String contact : getResources().getStringArray(R.array.names)) {
            if (contact.charAt(0) == letter) {
                contacts.add(contact);
            }
        }

        return contacts;
    }

    class ContactsSection extends StatelessSection {

        String title;
        List<String> list;

        public ContactsSection(String title, List<String> list) {
            super(R.layout.section_livelist_header, R.layout.section_livelist_item);

            this.title = title;
            this.list = list;
        }

        @Override
        public int getContentItemsTotal() {
            return list.size();
        }

        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }

        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
            final ItemViewHolder itemHolder = (ItemViewHolder) holder;

            String name = list.get(position);

            itemHolder.tvItem.setText(name);

            itemHolder.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), String.format("Clicked on position #%s of Section %s", sectionAdapter.getSectionPosition(itemHolder.getAdapterPosition()), title), Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }

        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;

            headerHolder.tvTitle.setText(title);
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvTitle;

        public HeaderViewHolder(View view) {
            super(view);

            tvTitle = (TextView) view.findViewById(R.id.section_livelist_header_txt);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        private final View rootView;
        private final TextView tvItem;

        public ItemViewHolder(View view) {
            super(view);

            rootView = view;
            tvItem = (TextView) view.findViewById(R.id.selection_livelist_item_home_txt);
        }
    }
}
