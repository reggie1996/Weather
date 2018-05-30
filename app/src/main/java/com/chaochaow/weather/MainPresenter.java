package com.chaochaow.weather;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author chaochaowu
 * @Description : MVP框架中的presenter用来处理数据请求
 * @class : MainPresenter
 * @time Create at 5/28/2018 2:05 PM
 */


public class MainPresenter implements MainContract.Presenter{

    MainContract.View mView;


    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getData(String[] cities) {

        final List<WeatherEntity> weatherEntities = new ArrayList<>();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);

        for (String city : cities) {

            weatherService.getWeather("2c8121290a004d63a50cd73b5b9f7524", city)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<WeatherEntity>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(WeatherEntity weatherEntity) {
                            weatherEntities.add(weatherEntity);
                        }

                        @Override
                        public void onError(Throwable e) {
                            mView.dataError(e);
                        }

                        @Override
                        public void onComplete() {
                            mView.setData(weatherEntities);
                        }
                    });

        }


    }
}
