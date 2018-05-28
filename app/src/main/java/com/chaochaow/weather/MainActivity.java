package com.chaochaow.weather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;


/**
 * @author chaochaowu
 * @Description :
 * @class :
 * @time Create at 5/28/2018 2:04 PM
 */

public class MainActivity extends AppCompatActivity implements MainContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainPresenter presenter = new MainPresenter(this);
        presenter.getData();

    }


}
