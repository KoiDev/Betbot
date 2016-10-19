package ru.gmgspb.betbot.network.entity;

import java.util.List;

/**
 * Created by User on 007 07.10.16.
 */

public class DataTopForecast {

    /**
     * data : [{"id":"14344378","home":"Бельгия","away":"Босн. и Герц.","date":1475865900,
     * "league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":158},
     * {"id":"14344379","home":"Венгрия","away":"Швейцария","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":138},{"id":"14344375","home":"Люксембург","away":"Швеция","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":115},{"id":"14344373","home":"Нидерланды","away":"Беларусь","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":112},{"id":"14344380","home":"Франция","away":"Болгария","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":101},{"id":"14344374","home":"Латвия","away":"Фареры","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":88},{"id":"14370338","home":"Конта Дж.","away":"Чжан Шуай","date":1475839200,"league":" Турнир WTA. Пекин. Китай. Hard.","count":83},{"id":"14344377","home":"Греция","away":"Кипр","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":81},{"id":"14368350","home":"Барыс","away":"Лада","date":1475847000,"league":" КХЛ. Регулярный чемпионат.","count":79},{"id":"14344376","home":"Португалия","away":"Андорра","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":76},{"id":"14368349","home":"Автомобилист","away":"Нефтехимик","date":1475848800,"league":" КХЛ. Регулярный чемпионат.","count":75},{"id":"14368348","home":"Югра","away":"Ак Барс","date":1475848800,"league":" КХЛ. Регулярный чемпионат.","count":64},{"id":"14370339","home":"Надаль Р.","away":"Димитров Г.","date":1475844300,"league":" Турнир ATP. Пекин. Китай. Hard.","count":60},{"id":"14344381","home":"Эстония","away":"Гибралтар","date":1475865900,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":39},{"id":"14368180","home":"Филиппины","away":"Бахрейн","date":1475841600,"league":" Товарищеские матчи. Сборные.","count":31},{"id":"14370009","home":"Гана","away":"Уганда","date":1475854200,"league":" Чемпионат мира 2018. Отборочные матчи. Африка.","count":29},{"id":"14370292","home":"Мумбаи Сити","away":"Норт Ист Юнайтед","date":1475847000,"league":" Чемпионат Индии. Суперлига.","count":23},{"id":"14369172","home":"Автодор","away":"Нижний Новгород","date":1475857800,"league":" Мужчины. Единая лига ВТБ. Регулярный сезон.","count":22},{"id":"14370656","home":"Штруфф Я.-Л.","away":"Матье П.-А.","date":1475843400,"league":" Турнир ATP. Монс. Бельгия. Hard.","count":20},{"id":"14370661","home":"Майхшак К.","away":"Циципас С.","date":1475839500,"league":" Турнир ATP. Мохаммедия. Марокко. Clay.","count":19},{"id":"14368255","home":"Германия (мол)","away":"Россия (мол)","date":1475856000,"league":" Чемпионат Европы 2017 (до 21 года). Отборочные матчи.","count":19},{"id":"14370168","home":"Кёльн II","away":"Фортуна Д II","date":1475841600,"league":" Чемпионат Германии. Региональная лига. Запад.","count":17},{"id":"14370894","home":"Раонич М.","away":"Каррено-Буста П.","date":1475843100,"league":" Турнир ATP. Пекин. Китай. Hard.","count":16},{"id":"14343136","home":"Азербайджан","away":"Норвегия","date":1475942400,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":15},{"id":"14370593","home":"Радванска А.","away":"Шведова Я.","date":1475849400,"league":" Турнир WTA. Пекин. Китай. Hard.","count":15},{"id":"14368181","home":"Сингапур","away":"Малайзия","date":1475843400,"league":" Товарищеские матчи. Сборные.","count":14},{"id":"14369692","home":"Ст. Патрикс","away":"Уэксфорд","date":1475865900,"league":" Чемпионат Ирландии.","count":13},{"id":"14369301","home":"Торпедо У-К","away":"Химик Вск","date":1475843400,"league":" ВХЛ. Регулярный чемпионат.","count":13},{"id":"14369693","home":"Финн Харпс","away":"Брей Уондерерс","date":1475866800,"league":" Чемпионат Ирландии.","count":13},{"id":"14369687","home":"Людвигсбург","away":"Ольденбург","date":1475859600,"league":" Чемпионат Германии. Мужчины.","count":13},{"id":"14370157","home":"Бавария II","away":"Аугсбург II","date":1475859600,"league":" Чемпионат Германии. Региональная лига. Бавария.","count":13},{"id":"14370658","home":"Брандс Д.","away":"Рублев А.","date":1475865000,"league":" Турнир ATP. Монс. Бельгия. Hard.","count":12},{"id":"14343139","home":"Германия","away":"Чехия","date":1475952300,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":12},{"id":"14343141","home":"Польша","away":"Дания","date":1475952300,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":12},{"id":"14368260","home":"Финляндия (мол)","away":"Азербайджан (мол)","date":1475854200,"league":" Чемпионат Европы 2017 (до 21 года). Отборочные матчи.","count":12},{"id":"14370657","home":"Беранкис Р.","away":"Милло В.","date":1475857800,"league":" Турнир ATP. Монс. Бельгия. Hard.","count":11},{"id":"14368262","home":"Чехия (мол)","away":"Молдавия (мол)","date":1475856000,"league":" Чемпионат Европы 2017 (до 21 года). Отборочные матчи.","count":11},{"id":"14369903","home":"Кудла Д.","away":"Макдональд М.","date":1475859900,"league":" Турнир ATP. Стоктон. США. Hard.","count":9},{"id":"14369689","home":"Богемианс Дублин","away":"Шемрок Роверс","date":1475865900,"league":" Чемпионат Ирландии.","count":9},{"id":"14370175","home":"Зиген","away":"Виктория Кёльн","date":1475863200,"league":" Чемпионат Германии. Региональная лига. Запад.","count":9},{"id":"14369302","home":"Сары-Арка","away":"ТХК","date":1475845200,"league":" ВХЛ. Регулярный чемпионат.","count":9},{"id":"14368898","home":"Бильбао","away":"Эстудиантес","date":1475860500,"league":" Чемпионат Испании. Мужчины.","count":9},{"id":"14370487","home":"Финляндия","away":"Хорватия","date":1476028800,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":8},{"id":"14343140","home":"Шотландия","away":"Литва","date":1475952300,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":8},{"id":"14369630","home":"Гресик Юн","away":"Арема","date":1475848800,"league":" Чемпионат Индонезии. Высшая Лига.","count":8},{"id":"14343143","home":"Англия","away":"Мальта","date":1475942400,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":8},{"id":"14368258","home":"Болгария (мол)","away":"Дания (мол)","date":1475852400,"league":" Чемпионат Европы 2017 (до 21 года). Отборочные матчи.","count":8},{"id":"14369300","home":"Сокол Кр","away":"Динамо СПб","date":1475841600,"league":" ВХЛ. Регулярный чемпионат.","count":8},{"id":"14343137","home":"Армения","away":"Румыния","date":1475942400,"league":" Чемпионат мира 2018. Отборочные матчи. Европа.","count":8},{"id":"14370093","home":"Каролина","away":"Вашингтон","date":1475883000,"league":" NHL. Предсезонные матчи.","count":8}]
     * status : OK
     * totalevent : 50
     */

    private String status;
    private int totalevent;
    /**
     * id : 14344378
     * home : Бельгия
     * away : Босн. и Герц.
     * date : 1475865900
     * league :  Чемпионат мира 2018. Отборочные матчи. Европа.
     * count : 158
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
        private String home;
        private String away;
        private String date;
        private String league;
        private String count;

        public DataBean(String date, String home, String away, String league, String count) {
            this.home = home;
            this.away = away;
            this.date = date;
            this.league = league;
            this.count = count;
        }


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getLeague() {
            return league;
        }

        public void setLeague(String league) {
            this.league = league;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }
    }
}
