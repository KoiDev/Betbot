package ru.gmgspb.betbot.network.entity;

import java.util.List;

public class DataLiveChampionshipItem {

    /**
     * data : [{"id":"f6be085","league":"Азербайджан. Премьер-лига","logo_league":"http://vprognoze.ru/uploads/logo_country/0.png","data":[{"tid":"4572103","g_id":"2138827","league":"Азербайджан. Премьер-лига","sport":"Футбол","fullresult":"","date":"1477310400","home":"АЗАЛ Баку","away":"Зира","res1":"0","res2":"0","id":"8452d73e7bb81acb4b7aff0cfe444ff7","league_id":"f6be085","end":"0","live":"0","stat":"1"}]}]
     * status : OK
     * totalevent : 1
     */

    private String status;
    private int totalevent;
    /**
     * id : f6be085
     * league : Азербайджан. Премьер-лига
     * logo_league : http://vprognoze.ru/uploads/logo_country/0.png
     * data : [{"tid":"4572103","g_id":"2138827","league":"Азербайджан. Премьер-лига","sport":"Футбол","fullresult":"","date":"1477310400","home":"АЗАЛ Баку","away":"Зира","res1":"0","res2":"0","id":"8452d73e7bb81acb4b7aff0cfe444ff7","league_id":"f6be085","end":"0","live":"0","stat":"1"}]
     */

    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalevent() {
        return totalevent;
    }

    public void setTotalevent(int totalevent) {
        this.totalevent = totalevent;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String league;
        private String logo_league;
        /**
         * tid : 4572103
         * g_id : 2138827
         * league : Азербайджан. Премьер-лига
         * sport : Футбол
         * fullresult :
         * date : 1477310400
         * home : АЗАЛ Баку
         * away : Зира
         * res1 : 0
         * res2 : 0
         * id : 8452d73e7bb81acb4b7aff0cfe444ff7
         * league_id : f6be085
         * end : 0
         * live : 0
         * stat : 1
         */

        private List<DataDetail> data;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLeague() {
            return league;
        }

        public void setLeague(String league) {
            this.league = league;
        }

        public String getLogo_league() {
            return logo_league;
        }

        public void setLogo_league(String logo_league) {
            this.logo_league = logo_league;
        }

        public List<DataDetail> getData() {
            return data;
        }

        public void setData(List<DataDetail> data) {
            this.data = data;
        }

        public static class DataDetail {
            private String tid;
            private String g_id;
            private String league;
            private String sport;
            private String fullresult;
            private String date;
            private String home;
            private String away;
            private String res1;
            private String res2;
            private String id;
            private String league_id;
            private String end;
            private String live;
            private String stat;

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getG_id() {
                return g_id;
            }

            public void setG_id(String g_id) {
                this.g_id = g_id;
            }

            public String getLeague() {
                return league;
            }

            public void setLeague(String league) {
                this.league = league;
            }

            public String getSport() {
                return sport;
            }

            public void setSport(String sport) {
                this.sport = sport;
            }

            public String getFullresult() {
                return fullresult;
            }

            public void setFullresult(String fullresult) {
                this.fullresult = fullresult;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHome() {
                return home;
            }

            public void setHome(String home) {
                this.home = home;
            }

            public String getAway() {
                return away;
            }

            public void setAway(String away) {
                this.away = away;
            }

            public String getRes1() {
                return res1;
            }

            public void setRes1(String res1) {
                this.res1 = res1;
            }

            public String getRes2() {
                return res2;
            }

            public void setRes2(String res2) {
                this.res2 = res2;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLeague_id() {
                return league_id;
            }

            public void setLeague_id(String league_id) {
                this.league_id = league_id;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getLive() {
                return live;
            }

            public void setLive(String live) {
                this.live = live;
            }

            public String getStat() {
                return stat;
            }

            public void setStat(String stat) {
                this.stat = stat;
            }
        }
    }
}
