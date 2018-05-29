package com.chaochaow.weather;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author chaochaowu
 * @Description : retrofit 定义网络请求
 * @classes : WeatherService
 * @time Create at 5/28/2018 2:41 PM
 */


public interface WeatherService {

    /**
     * 获取指定城市的天气信息
     * @param key 开发者key
     * @param location 城市名称
     * @return 返回一个Observable类型 用于Rxjava的处理
     */
    @GET("s6/weather/now")
    Observable<WeatherEntity> getWeather(@Query("key") String key, @Query("location") String location);

}
