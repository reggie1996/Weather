package com.chaochaow.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author chaochaowu
 * @Description : 主界面
 * @class : MainActivity
 * @time Create at 5/28/2018 2:04 PM
 */

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.textView)
    TextView mTextView;
    @BindView(R.id.button)
    Button mButton;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new MainPresenter(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getData();
            }
        });

    }

    @Override
    public void setData(WeatherEntity weatherEntity) {
        mTextView.setText(weatherEntity.toString());
    }

    @Override
    public void dataError(Throwable e) {
        mTextView.setText(e.toString());
    }

}
