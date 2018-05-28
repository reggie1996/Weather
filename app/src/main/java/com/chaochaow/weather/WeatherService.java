package com.chaochaow.weather;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author chaochaowu
 * @Description :
 * @classes :
 * @time Create at 5/28/2018 2:41 PM
 */


public interface WeatherService {

    @GET("s6/weather/now?key=2c8121290a004d63a50cd73b5b9f7524&location=beijing")
    Observable<Response<WeatherEntity>> getWeather();

    @GET("s6/weather/now?key=2c8121290a004d63a50cd73b5b9f7524&location=beijing")
    Call<WeatherEntity> getWeather2();

}
