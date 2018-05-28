package com.chaochaow.weather;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.Result;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author chaochaowu
 * @Description :
 * @class :
 * @time Create at 5/28/2018 2:05 PM
 */


public class MainPresenter implements MainContract.Presenter{

    MainContract.View mView;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void getData() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://free-api.heweather.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);

        weatherService.getWeather()
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<WeatherEntity>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Response<WeatherEntity> weatherEntityResponse) {
                        Log.e("111111",weatherEntityResponse.body().getHeWeather6().get(0).getBasic().getAdmin_area());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("111111","error");
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        Call<WeatherEntity> weather2 = weatherService.getWeather2();
        weather2.enqueue(new Callback<WeatherEntity>() {
            @Override
            public void onResponse(Call<WeatherEntity> call, Response<WeatherEntity> response) {
                Log.e("222222",response.body().getHeWeather6().get(0).getBasic().getAdmin_area());
            }

            @Override
            public void onFailure(Call<WeatherEntity> call, Throwable t) {
                Log.e("222222","error");
            }
        });

    }
}
