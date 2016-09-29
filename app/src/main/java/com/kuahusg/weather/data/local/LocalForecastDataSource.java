package com.kuahusg.weather.data.local;

import com.kuahusg.weather.data.IDataSource;
import com.kuahusg.weather.data.callback.RequestCityCallback;
import com.kuahusg.weather.data.callback.RequestWeatherCallback;
import com.kuahusg.weather.model.Forecast;
import com.kuahusg.weather.model.ForecastInfo;
import com.kuahusg.weather.util.PreferenceUtil;

import java.util.List;

import static com.kuahusg.weather.util.PreferenceUtil.PREF_SELECTED_CITY;

/**
 * Created by kuahusg on 16-9-28.
 */


public class LocalForecastDataSource implements IDataSource {


    @Override
    public void queryWeather(String woeid, RequestWeatherCallback callback) {

        if (woeid == null)
            woeid = getWoeid();

        assert woeid != null;
        WeatherDB.loadForecastAndInfo(woeid, callback);
    }

    @Override
    public void saveWeather(List<Forecast> forecastList, ForecastInfo info) {
        WeatherDB.saveForecastAndInfo(forecastList, info);
    }

    @Override
    public void loadAllCity(RequestCityCallback cityCallback) {

    }

    public void queryWeather(RequestWeatherCallback callback) {

    }

    public String getWoeid() {
        return PreferenceUtil.getInstance().getSharedPreferences().getString(PREF_SELECTED_CITY, null);

    }



}
