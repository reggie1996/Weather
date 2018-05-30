package com.chaochaow.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.UpDownAnimatorAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author chaochaowu
 * @Description : 主界面
 * @class : MainActivity
 * @time Create at 5/28/2018 2:04 PM
 */

public class MainActivity extends AppCompatActivity implements MainContract.View, CardStackView.ItemExpendListener {

    MainPresenter presenter;
    @BindView(R.id.stackview_main)
    CardStackView mStackview;
    WeatherStackAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        String[] cities = new String[]{"杭州", "绍兴", "成都", "武汉", "重庆", "南京", "天津", "苏州", "西安", "长沙", "沈阳",
                "青岛", "郑州", "大连", "宁波", "厦门", "福州", "无锡", "合肥", "昆明", "哈尔滨", "济南", "佛山", "长春", "温州"};

        presenter.getData(cities);


    }

    @Override
    public void setData(List<WeatherEntity> weatherEntities) {

        mAdapter = new WeatherStackAdapter(this);
        mStackview.setAnimatorAdapter(new UpDownAnimatorAdapter(mStackview));
        mStackview.setItemExpendListener(this);
        mAdapter.setData(weatherEntities);
        mStackview.setAdapter(mAdapter);

    }

    @Override
    public void dataError(Throwable e) {
        Toast.makeText(this,"加载失败...",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemExpend(boolean expend) {

    }

}
