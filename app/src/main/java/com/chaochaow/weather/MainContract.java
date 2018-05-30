package com.chaochaow.weather;

import java.util.List;

/**
 * @author chaochaowu
 * @Description :MVP框架中的协议类
 * @class :MainContract
 * @time Create at 5/28/2018 2:04 PM
 */


public interface MainContract {

    interface View{
        /**
         * presenter获取数据后调用此方法将数据展示到界面上
         * @param weatherEntities 获取到的天气数据
         */
        void setData(List<WeatherEntity> weatherEntities);

        /**
         * presenter获取数据失败调用此方法将错误信息展示到界面上
         * @param e
         */
        void dataError(Throwable e);
    }

    interface Presenter{
        /**
         * 从服务器获取天气数据
         */
        void getData(String[] cities);
    }

}
