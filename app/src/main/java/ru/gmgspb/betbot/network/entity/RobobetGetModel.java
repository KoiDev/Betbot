package ru.gmgspb.betbot.network.entity;

/**
 * Created by KoiDev on 005 05.10.16.
 */
public class RobobetGetModel {
    private int id;
    private String home;
    private String away;
    private String data;
    private String league;
    private String result;
    private String result_home;
    private String result_away;
    private String rating;
    private String percent_home;
    private String percent_draw;
    private String percent_away;
    private String percent_home_color;
    private String percent_draw_color;
    private String percent_away_color;
    private String kf_home;
    private String kf_draw;
    private String kf_away;
    private String odds;

    public RobobetGetModel(String home, String away, String percent_home,String percent_home_color, String percent_away,
                           String percent_away_color, String kf_home, String kf_away, String oddsodds, String result_home, String result_away) {
        this.home = home;
        this.away = away;
        this.percent_home = percent_home;
        this.percent_home_color = percent_home_color;
        this.percent_away = percent_away;
        this.percent_away_color = percent_away_color;
        this.kf_home = kf_home;
        this.kf_away = kf_away;
        this.odds = oddsodds;
        this.result_home = result_home;
        this.result_away = result_away;



    }


    public int getId() {
        return id;
    }

    public String getHome() {
        return home;
    }

    public String getAway() {
        return away;
    }

    public String getData() {
        return data;
    }

    public String getLeague() {
        return league;
    }

    public String getResult() {
        return result;
    }

    public String getResult_home() {
        return result_home;
    }

    public String getResult_away() {
        return result_away;
    }

    public String getRating() {
        return rating;
    }

    public String getPercent_home() {
        return percent_home;
    }

    public String getPercent_draw() {
        return percent_draw;
    }

    public String getPercent_away() {
        return percent_away;
    }

    public String getPercent_home_color() {
        return percent_home_color;
    }

    public String getPercent_draw_color() {
        return percent_draw_color;
    }

    public String getPercent_away_color() {
        return percent_away_color;
    }

    public String getKf_home() {
        return kf_home;
    }

    public String getKf_draw() {
        return kf_draw;
    }

    public String getKf_away() {
        return kf_away;
    }

    public String getOdds() {
        return odds;
    }

}
