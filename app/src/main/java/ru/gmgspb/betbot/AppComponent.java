package ru.gmgspb.betbot;

import javax.inject.Singleton;

import dagger.Component;
import ru.gmgspb.betbot.live.fragment.TabFragmentOne;
import ru.gmgspb.betbot.live.fragment.TabFragmentTwo;
import ru.gmgspb.betbot.live.view.LiveActivity;
import ru.gmgspb.betbot.network.api.ForecastApi;

@Singleton
@Component(modules = {
        AppModule.class,
        ForecastApiModule.class
})
public interface AppComponent {
    void inject(LiveActivity activity);
    void inject(TabFragmentTwo fragment);
    void inject(TabFragmentOne fragment);


    ForecastApi getForecastApi();
}
