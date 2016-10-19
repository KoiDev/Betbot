package ru.gmgspb.betbot.network.entity;

import java.util.List;

public class DataTopForesastDetails {

    /**
     * home :
     * away :
     * result : null
     * logo_home : http://vprognoze.ru/uploads/logo_teams/0.png
     * logo_away : http://vprognoze.ru/uploads/logo_teams/0.png
     * dataOdds : {"home":null,"draw":null,"away":null,"over":null,"under":null,"other":0}
     * dataUsers : [{"author":"game__over","odds":"П2 с ОТ","idnews":"4678006","profit":"-40.2","prohod":"-"}]
     */

    private DataBean data;
    /**
     * data : {"home":"","away":"","result":null,"logo_home":"http://vprognoze.ru/uploads/logo_teams/0.png","logo_away":"http://vprognoze.ru/uploads/logo_teams/0.png","dataOdds":{"home":null,"draw":null,"away":null,"over":null,"under":null,"other":0},"dataUsers":[{"author":"game__over","odds":"П2 с ОТ","idnews":"4678006","profit":"-40.2","prohod":"-"}]}
     * status : OK
     */

    private String status;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class DataBean {
        private String home;
        private String away;
        private Object result;
        private String logo_home;
        private String logo_away;
        /**
         * home : null
         * draw : null
         * away : null
         * over : null
         * under : null
         * other : 0
         */

        private DataOddsBean dataOdds;
        /**
         * author : game__over
         * odds : П2 с ОТ
         * idnews : 4678006
         * profit : -40.2
         * prohod : -
         */

        private List<DataUsersBean> dataUsers;

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

        public Object getResult() {
            return result;
        }

        public void setResult(Object result) {
            this.result = result;
        }

        public String getLogo_home() {
            return logo_home;
        }

        public void setLogo_home(String logo_home) {
            this.logo_home = logo_home;
        }

        public String getLogo_away() {
            return logo_away;
        }

        public void setLogo_away(String logo_away) {
            this.logo_away = logo_away;
        }

        public DataOddsBean getDataOdds() {
            return dataOdds;
        }

        public void setDataOdds(DataOddsBean dataOdds) {
            this.dataOdds = dataOdds;
        }

        public List<DataUsersBean> getDataUsers() {
            return dataUsers;
        }

        public void setDataUsers(List<DataUsersBean> dataUsers) {
            this.dataUsers = dataUsers;
        }

        public static class DataOddsBean {
            private Object home;
            private Object draw;
            private Object away;
            private Object over;
            private Object under;
            private int other;

            public Object getHome() {
                return home;
            }

            public void setHome(Object home) {
                this.home = home;
            }

            public Object getDraw() {
                return draw;
            }

            public void setDraw(Object draw) {
                this.draw = draw;
            }

            public Object getAway() {
                return away;
            }

            public void setAway(Object away) {
                this.away = away;
            }

            public Object getOver() {
                return over;
            }

            public void setOver(Object over) {
                this.over = over;
            }

            public Object getUnder() {
                return under;
            }

            public void setUnder(Object under) {
                this.under = under;
            }

            public int getOther() {
                return other;
            }

            public void setOther(int other) {
                this.other = other;
            }
        }

        public static class DataUsersBean {
            public DataUsersBean(String author, String odds, String prohod, String profit) {
                this.author = author;
                this.odds = odds;
                this.profit = profit;
                this.prohod = prohod;
            }

            private String author;
            private String odds;
            private String idnews;
            private String profit;
            private String prohod;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getOdds() {
                return odds;
            }

            public void setOdds(String odds) {
                this.odds = odds;
            }

            public String getIdnews() {
                return idnews;
            }

            public void setIdnews(String idnews) {
                this.idnews = idnews;
            }

            public String getProfit() {
                return profit;
            }

            public void setProfit(String profit) {
                this.profit = profit;
            }

            public String getProhod() {
                return prohod;
            }

            public void setProhod(String prohod) {
                this.prohod = prohod;
            }
        }
    }
}
