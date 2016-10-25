package ru.gmgspb.betbot.network.entity;

public class GetDescriptionForecastModel {

    /**
     * data : Представлю вашему вниманию еще один неплохой прогноз. Хоккей. МХЛ.
     * Амурские Тигры принимают на домашней арене Чайку.<br />Сразу скажу, я не большой фанат молодежки,
     * но статистика меня убедила сделать ставку на сегодняшний матч.<br />В последних 10ти играх амурским
     * тиграм удавалось не проиграть в основное время в рамках МХЛ. В то время, когда Чайка в гостях
     * проиграла 4 последнии встречи из 5. Победу удалось удержать Чайке только над заведомым аутсайдером
     * - Тайфуном.<br />В этой встрече Тигры обязаны продолжить свою отличную серию и забрать как минимум
     * 1 очко.<br />
     * status : OK
     */

    private String data;
    private String status;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


