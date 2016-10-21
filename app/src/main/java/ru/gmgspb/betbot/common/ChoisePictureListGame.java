package ru.gmgspb.betbot.common;

import ru.gmgspb.betbot.R;

/**
 * Created by koidev on 21/10/16.
 */

public class ChoisePictureListGame {

    public static int getImage(String name){
        int image = 0;
        switch (name){
            case "Все":
                image = R.drawable.all;
                break;
            case "Футбол":
                image = R.drawable.football;
                break;
            case "Теннис":
                image = R.drawable.tennis;
                break;
            case "Баскетбол":
                image = R.drawable.backetball;
                break;
            case "Хоккей":
                image = R.drawable.hockey;
                break;
            case "Американский футбол":
                image = R.drawable.am_footbool;
                break;
            case "Бадминтон":
                image = R.drawable.badminton;
                break;
            case "Бейсбол":
                image = R.drawable.baseball;
                break;
            case "Биатлон":
                image = R.drawable.biathlon;
                break;
            case "Волейбол":
                image = R.drawable.volleyball;
                break;
            case "Водное поло":
                image = R.drawable.waterpolo;
                break;
            case "Гандбол":
                image = R.drawable.handball;
                break;
            case "Дартс":
                image = R.drawable.darts;
                break;
            case "Лыжные гонки":
                image = R.drawable.skiing;
                break;
            case "Регби":
                image = R.drawable.rugby;
                break;
            case "Снукер":
                image = R.drawable.snooker;
                break;
            case "Киберспорт":
                image = R.drawable.cybersport;
                break;
            case "Футзал":
                image = R.drawable.futsal;
                break;
            case "Хоккей на траве":
                image = R.drawable.hockey_grass;
                break;
            case "Хоккей с мячом":
                image = R.drawable.hockey_ball;
                break;
            case "Шахматы":
                image = R.drawable.chess;
                break;

            //TODO: Get true name for two case
            case "Пляжный волейбол":
                image = R.drawable.beach_soccer;
                break;
            case "Настольный теннис":
                image = R.drawable.table_tennis;
                break;

        }
    return image;
    }
}
