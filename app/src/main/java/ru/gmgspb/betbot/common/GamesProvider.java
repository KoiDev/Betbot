package ru.gmgspb.betbot.common;

import java.util.LinkedList;
import java.util.List;

import ru.gmgspb.betbot.R;
import ru.gmgspb.betbot.network.entity.RobobetListModel;

/**
 * Created by koidev on 19/10/16.
 */

public class GamesProvider {


    public static List<RobobetListModel> intiDate() {
        List<RobobetListModel> list = new LinkedList<>();
        list.add(new RobobetListModel(R.drawable.all, "Все"));
        list.add(new RobobetListModel(R.drawable.football, "Футбол"));
        list.add(new RobobetListModel(R.drawable.tennis, "Тенис"));
        list.add(new RobobetListModel(R.drawable.hockey, "Хоккей"));
        list.add(new RobobetListModel(R.drawable.backetball, "Баскетбол"));
        list.add(new RobobetListModel(R.drawable.volleyball, "Волейбол"));
        list.add(new RobobetListModel(R.drawable.am_footbool, "Америк.футбол"));
        list.add(new RobobetListModel(R.drawable.baseball, "Бейсбол"));
        list.add(new RobobetListModel(R.drawable.rugby, "Регби"));
        list.add(new RobobetListModel(R.drawable.badminton, "Бадбинтон"));
        list.add(new RobobetListModel(R.drawable.waterpolo, "Водное поло"));
        list.add(new RobobetListModel(R.drawable.futsal, "Футзал"));
        list.add(new RobobetListModel(R.drawable.darts, "Дартс"));
        list.add(new RobobetListModel(R.drawable.table_tennis, "Настрол.тенис"));
        list.add(new RobobetListModel(R.drawable.chess, "Шахматы"));
        list.add(new RobobetListModel(R.drawable.snooker, "Снукер"));
        list.add(new RobobetListModel(R.drawable.hockey_grass, "Хоккей на траве"));
        list.add(new RobobetListModel(R.drawable.hockey_ball, "Теннис с мячом"));
        list.add(new RobobetListModel(R.drawable.skiing, "Лыжи"));
        list.add(new RobobetListModel(R.drawable.cybersport, "Киберспоррт"));
        list.add(new RobobetListModel(R.drawable.beach_soccer, "Пляжний футбол"));
        list.add(new RobobetListModel(R.drawable.handball, "Нагдбол"));
        list.add(new RobobetListModel(R.drawable.biathlon, "Биатлон"));
        return list;
    }
}
