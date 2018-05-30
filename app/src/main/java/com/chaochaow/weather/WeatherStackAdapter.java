package com.chaochaow.weather;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loopeer.cardstack.CardStackView;
import com.loopeer.cardstack.StackAdapter;

/**
 * @author chaochaowu
 * @Description : 城市列表展示的adapter
 * @class : WeatherStackAdapter
 * @time Create at 5/29/2018 4:43 PM
 */


public class WeatherStackAdapter  extends StackAdapter<WeatherEntity> {

    public static Integer[] COLOR_DATAS = new Integer[]{
            R.color.color_1,
            R.color.color_2,
            R.color.color_3,
            R.color.color_4,
            R.color.color_5,
            R.color.color_6,
            R.color.color_7,
            R.color.color_8,
            R.color.color_9,
            R.color.color_10,
            R.color.color_11,
            R.color.color_12,
            R.color.color_13,
            R.color.color_14,
            R.color.color_15,
            R.color.color_16,
            R.color.color_17,
            R.color.color_18,
            R.color.color_19,
            R.color.color_20,
            R.color.color_21,
            R.color.color_22,
            R.color.color_23,
            R.color.color_24,
            R.color.color_25,
            R.color.color_26
    };


    public WeatherStackAdapter(Context context) {
        super(context);
    }

    @Override
    public void bindView(WeatherEntity data, int position, CardStackView.ViewHolder holder) {
        WeatherItemViewHolder h = (WeatherItemViewHolder) holder;
        h.onBind(data, position);
    }

    @Override
    protected CardStackView.ViewHolder onCreateView(ViewGroup parent, int viewType) {
        View view;
        view = getLayoutInflater().inflate(R.layout.list_card_item, parent, false);
        return new WeatherItemViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.list_card_item;
    }

    static class WeatherItemViewHolder extends CardStackView.ViewHolder {
        View mLayout;
        View mContainerContent;

        TextView mLocation;
        TextView mTmp;
        TextView mCondTxt;
        TextView mLoc;

        TextView mFl;
        TextView mWindDir;
        TextView mWindSc;
        TextView mWindSpd;
        TextView mHum;
        TextView mPcpn;
        TextView mPres;
        TextView mVis;
        TextView mCloud;


        public WeatherItemViewHolder(View view) {
            super(view);
            mLayout = view.findViewById(R.id.frame_list_card_item);
            mContainerContent = view.findViewById(R.id.container_list_content);

            mLocation = view.findViewById(R.id.tv_location);
            mTmp = view.findViewById(R.id.tv_tmp);
            mCondTxt = view.findViewById(R.id.tv_cond_txt);
            mLoc = view.findViewById(R.id.tv_loc);

            mFl = view.findViewById(R.id.tv_fl);
            mWindDir = view.findViewById(R.id.tv_wind_dir);
            mWindSc = view.findViewById(R.id.tv_wind_sc);
            mWindSpd = view.findViewById(R.id.tv_wind_spd);
            mHum = view.findViewById(R.id.tv_hum);
            mPcpn = view.findViewById(R.id.tv_pcpn);
            mPres = view.findViewById(R.id.tv_pres);
            mVis = view.findViewById(R.id.tv_vis);
            mCloud = view.findViewById(R.id.tv_cloud);

        }

        @Override
        public void onItemExpand(boolean b) {
            mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
        }

        public void onBind(WeatherEntity data, int position) {

            mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), COLOR_DATAS[position%26]), PorterDuff.Mode.SRC_IN);

            WeatherEntity.HeWeather6Bean.NowBean now = data.getHeWeather6().get(0).getNow();
            mLocation.setText(data.getHeWeather6().get(0).getBasic().getLocation());
            mTmp.setText(now.getTmp());
            mCondTxt.setText(now.getCond_txt());
            mLoc.setText(data.getHeWeather6().get(0).getUpdate().getLoc());

            mFl.setText(now.getFl() + " ℃");
            mWindDir.setText(now.getWind_dir());
            mWindSc.setText(now.getWind_sc() + " 级");
            mWindSpd.setText(now.getWind_spd() + " km/h");
            mHum.setText(now.getHum() + " %");
            mPcpn.setText(now.getPcpn() + " mm");
            mPres.setText(now.getPres() + " Pa");
            mVis.setText(now.getVis() + " km");
            mCloud.setText(now.getCloud() + " %");
        }

    }

}
