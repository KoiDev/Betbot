package ru.gmgspb.betbot.network.entity;

import java.util.List;

/**
 * Created by DevKoi on 028 28.09.16.
 */
public class RobobetListModel {

    /**
     * data : [{"id":1,"name":"Футбол"},{"id":2,"name":"Теннис"},{"id":3,"name":"Баскетбол"},{"id":7,"name":"Хоккей"},{"id":6,"name":"Американский футбол"},{"id":49,"name":"Бадминтон"},{"id":5,"name":"Бейсбол"},{"id":15,"name":"Биатлон"},{"id":12,"name":"Волейбол"},{"id":24,"name":"Водное поло"},{"id":8,"name":"Гандбол"},{"id":47,"name":"Дартс"},{"id":16,"name":"Лыжные гонки"},{"id":13,"name":"Регби"},{"id":74,"name":"Снукер"},{"id":73,"name":"Киберспорт"},{"id":19,"name":"Футзал"},{"id":36,"name":"Хоккей на траве"},{"id":17,"name":"Хоккей с мячом"},{"id":10,"name":"Шахматы"}]
     * status : OK
     */

    private String status;
    /**
     * id : 1
     * name : Футбол
     */

    private List<DataBean> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
