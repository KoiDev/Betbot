package ru.gmgspb.betbot.network.entity;


import java.util.List;

public class DataLiveChampionship {

    /**
     * data : [{"id":"b49e996","league_id":"4689506","league":"Австралия. Эй-лига","count_live":0,"count":1},{"id":"5a6dcb9","league_id":"4598056","league":"Австрия. 1-я лига","count_live":0,"count":5},{"id":"90968fa","league_id":"4565255","league":"Австрия. Региональная лига. Восток","count_live":0,"count":4},{"id":"f0bff17","league_id":"4565291","league":"Австрия. Региональная лига. Запад","count_live":0,"count":2},{"id":"b654941","league_id":"4565366","league":"Австрия. Региональная лига. Центр","count_live":0,"count":6},{"id":"2eebc4b","league_id":"4651422","league":"Алжир. 1-я лига","count_live":0,"count":2},{"id":"0afcdf2","league_id":"4734803","league":"Англия. Премьер-лига 2. 2-й дивизион","count_live":0,"count":1},{"id":"57c670b","league_id":"4638933","league":"Англия. Чемпион-лига","count_live":0,"count":1},{"id":"f4fbdca","league_id":"4713826","league":"Беларусь. Высшая лига","count_live":0,"count":1},{"id":"927d83d","league_id":"4565645","league":"Бельгия. 1-й дивизион A","count_live":0,"count":1},{"id":"14431b8","league_id":"4565578","league":"Бельгия. 1-й дивизион B","count_live":0,"count":1},{"id":"23f2d41","league_id":"4718619","league":"Болгария. 1-я лига","count_live":0,"count":2},{"id":"d96d78a","league_id":"4469343","league":"Боливия. LFPB","count_live":2,"count":3},{"id":"41504b2","league_id":"4663512","league":"Германия. 2-я бундеслига","count_live":0,"count":3},{"id":"d973ca9","league_id":"4663462","league":"Германия. Бундеслига","count_live":0,"count":1},{"id":"6743fdf","league_id":"4722232","league":"Германия. Региональная лига. Бавария","count_live":0,"count":3},{"id":"b52944b","league_id":"4722310","league":"Германия. Региональная лига. Запад","count_live":0,"count":2},{"id":"bbd63e4","league_id":"4722254","league":"Германия. Региональная лига. Северо-Восток","count_live":0,"count":1},{"id":"fd91db2","league_id":"4722279","league":"Германия. Региональная лига. Юго-Запад","count_live":0,"count":3},{"id":"7770235","league_id":"4594928","league":"Дания. Суперлига","count_live":0,"count":2},{"id":"d9f60b7","league_id":"4722055","league":"Египет. Премьер-лига","count_live":0,"count":3},{"id":"b10f09e","league_id":"4675221","league":"Женщины. Сборные. Чемпионат Европы. 2017. Отборочные матчи. Раунд плей-офф. Первый матч","count_live":0,"count":1},{"id":"791d54d","league_id":"4738458","league":"Женщины. Сборные. Чемпионат мира до 17 лет. 2016. Финальный турнир. Иордания. Плей-офф. Матч за 3-е ","count_live":0,"count":1},{"id":"da01568","league_id":"4738459","league":"Женщины. Сборные. Чемпионат мира до 17 лет. 2016. Финальный турнир. Иордания. Плей-офф. Финал","count_live":0,"count":1},{"id":"c063235","league_id":"4710391","league":"Женщины. Товарищеские матчи. Сборные","count_live":0,"count":3},{"id":"2df6036","league_id":"4580581","league":"Индия. Суперлига","count_live":0,"count":1},{"id":"8502cf9","league_id":"4730892","league":"Индонезия. Чемпионат","count_live":0,"count":1},{"id":"dea888f","league_id":"4726990","league":"Иран. Про-лига","count_live":0,"count":5},{"id":"7e410ae","league_id":"4721084","league":"Ирландия. Премьер-дивизион","count_live":0,"count":5},{"id":"6bc18ba","league_id":"4663304","league":"Испания. Примера дивизион","count_live":0,"count":1},{"id":"66a44e7","league_id":"4598253","league":"Италия. Серия B","count_live":0,"count":2},{"id":"5eafafa","league_id":"4719226","league":"Катар. Старз Лига","count_live":0,"count":3},{"id":"f3ea6d0","league_id":"4376852","league":"Клубы. Международные. Лига чемпионов КОНКАКАФ. Групповой этап","count_live":1,"count":2},{"id":"8965621","league_id":"4719504","league":"Клубы. Международные. Южноамериканский кубок. 1/4 финала. Первые матчи","count_live":1,"count":1},{"id":"cd9740a","league_id":"4718017","league":"Латвия. Высшая лига","count_live":0,"count":1},{"id":"7200607","league_id":"4743334","league":"Литва. А-лига. Матчи за звание чемпиона","count_live":0,"count":1},{"id":"9e13ecf","league_id":"4518077","league":"Малайзия. Суперлига","count_live":0,"count":1},{"id":"9dd8a14","league_id":"4733801","league":"Марокко. Ботола","count_live":0,"count":1},{"id":"d519f74","league_id":"4709808","league":"Нидерланды. 1-й дивизион","count_live":0,"count":10},{"id":"fc4a643","league_id":"4651630","league":"Нидерланды. Эредивизи","count_live":0,"count":1},{"id":"d48901e","league_id":"4723557","league":"Норвегия. Типпелига","count_live":0,"count":1},{"id":"7193f41","league_id":"4719436","league":"ОАЭ. Арабиан Галф Лиг","count_live":0,"count":3},{"id":"575fe61","league_id":"4727029","league":"Польша. 1-я лига","count_live":0,"count":2},{"id":"1ce337e","league_id":"4722861","league":"Польша. Экстракласа","count_live":0,"count":2},{"id":"f5d8f12","league_id":"4423469","league":"Португалия. Примейра-лига","count_live":0,"count":2},{"id":"3fa1cd2","league_id":"4709398","league":"Россия. Молодежное первенство","count_live":0,"count":4},{"id":"01fd515","league_id":"4571739","league":"Россия. Премьер-лига","count_live":0,"count":1},{"id":"b2b023b","league_id":"4717998","league":"Румыния. Лига 1","count_live":0,"count":2},{"id":"e27eb16","league_id":"4738990","league":"Саудовская Аравия. Про-лига","count_live":0,"count":4},{"id":"e49c36b","league_id":"4714236","league":"Сборные. Чемпионат AФК до 19 лет. 2016. Финальный турнир. Бахрейн. Групповой этап","count_live":0,"count":2},{"id":"ae10aeb","league_id":"4690650","league":"Сборные. Чемпионат Европы до 17 лет. 2017. Отборочные матчи. Групповой этап. Люксембург","count_live":0,"count":2},{"id":"373ef66","league_id":"4673076","league":"Сербия. Суперлига","count_live":0,"count":1},{"id":"f9ed53e","league_id":"4718127","league":"Словения. 1-я лига","count_live":0,"count":1},{"id":"b3ba157","league_id":"4724367","league":"Турция. 1-я лига","count_live":0,"count":2},{"id":"f69365d","league_id":"4724347","league":"Турция. Суперлига","count_live":0,"count":2},{"id":"8d1aa46","league_id":"4727056","league":"Украина. 1-я лига","count_live":0,"count":2},{"id":"70f0ff2","league_id":"4673301","league":"Уэльс. Премьер-лига","count_live":0,"count":1},{"id":"f17a927","league_id":"4663208","league":"Франция. Лига 1","count_live":0,"count":1},{"id":"75aac18","league_id":"4689888","league":"Франция. Лига 2","count_live":0,"count":8},{"id":"4616e38","league_id":"4689723","league":"Хорватия. 1-я лига","count_live":0,"count":1},{"id":"1e970d5","league_id":"4709543","league":"Чехия. Синот-лига","count_live":0,"count":2},{"id":"816a755","league_id":"4709587","league":"Чехия. ФНЛ","count_live":0,"count":2},{"id":"cfd4c2e","league_id":"4726665","league":"Чили. Кубок. 1/4 финала. Первые матчи","count_live":1,"count":1},{"id":"90ed1ab","league_id":"4581643","league":"Швеция. Аллсвенскан","count_live":0,"count":1},{"id":"25153c2","league_id":"4713849","league":"Эстония. Премиум лига","count_live":0,"count":1},{"id":"f60a68a","league_id":"4732126","league":"ЮАР. Кубок лиги. 1-й раунд","count_live":0,"count":1}]
     * status : OK
     * totalevent : 66
     */

    private String status;
    private int totalevent;
    /**
     * id : b49e996
     * league_id : 4689506
     * league : Австралия. Эй-лига
     * count_live : 0
     * count : 1
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
        private String league_id;
        private String league;
        private int count_live;
        private int count;

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

        public String getLeague() {
            return league;
        }

        public void setLeague(String league) {
            this.league = league;
        }

        public int getCount_live() {
            return count_live;
        }

        public void setCount_live(int count_live) {
            this.count_live = count_live;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
