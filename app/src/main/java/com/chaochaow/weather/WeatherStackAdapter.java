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
 * @Description :
 * @classes :
 * @time Create at 5/29/2018 4:43 PM
 */


public class WeatherStackAdapter  extends StackAdapter<WeatherEntity> {

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
        TextView mTextTitle;

        public WeatherItemViewHolder(View view) {
            super(view);
            mLayout = view.findViewById(R.id.frame_list_card_item);
            mContainerContent = view.findViewById(R.id.container_list_content);
            mTextTitle = (TextView) view.findViewById(R.id.text_list_card_title);
        }

        @Override
        public void onItemExpand(boolean b) {
            mContainerContent.setVisibility(b ? View.VISIBLE : View.GONE);
        }

        public void onBind(WeatherEntity data, int position) {
            mLayout.getBackground().setColorFilter(ContextCompat.getColor(getContext(), R.color.color_1), PorterDuff.Mode.SRC_IN);
            mTextTitle.setText(String.valueOf(position));
        }

    }

}
