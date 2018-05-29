package com.chaochaow.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.UpDownAnimatorAdapter;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author chaochaowu
 * @Description : 主界面
 * @class : MainActivity
 * @time Create at 5/28/2018 2:04 PM
 */

public class MainActivity extends AppCompatActivity implements MainContract.View, CardStackView.ItemExpendListener{

    MainPresenter presenter;
    @BindView(R.id.stackview_main)
    CardStackView mStackview;
    WeatherStackAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);
        setData(null);


    }

    @Override
    public void setData(WeatherEntity weatherEntity) {
        mAdapter = new WeatherStackAdapter(this);
        mStackview.setAnimatorAdapter(new UpDownAnimatorAdapter(mStackview));
        mStackview.setItemExpendListener(this);

        WeatherEntity weatherEntity1 = new WeatherEntity();
        WeatherEntity weatherEntity2 = new WeatherEntity();
        WeatherEntity weatherEntity3 = new WeatherEntity();
        WeatherEntity weatherEntity4 = new WeatherEntity();
        WeatherEntity weatherEntity5 = new WeatherEntity();

        List<WeatherEntity> list = new ArrayList<>();
        list.add(weatherEntity1);
        list.add(weatherEntity2);
        list.add(weatherEntity3);
        list.add(weatherEntity4);
        list.add(weatherEntity5);

        mAdapter.setData(list);
        mStackview.setAdapter(mAdapter);
    }

    @Override
    public void dataError(Throwable e) {

    }

    @Override
    public void onItemExpend(boolean expend) {

    }

}
