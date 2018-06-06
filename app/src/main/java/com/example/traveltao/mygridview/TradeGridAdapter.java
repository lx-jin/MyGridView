package com.example.traveltao.mygridview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class TradeGridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TradeMsg> dataList;
    private Drawable titleDrawable;
    private String titleMsg, money, tips;

    private int clickTemp = -1;

    private static final int TITLE_DRAWABLE_RIGHT = 100;
    private static final int TITLE_DRAWABLE_BOTTOM = 70;

    private int itemTitleColor;
    private Drawable itemColor;
    private Drawable tradeItemColorDefault;

    public TradeGridAdapter(Context context, ArrayList<TradeMsg> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        if (dataList != null) {
            return dataList.size();
        } else {
            return 0;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.trade_grid_item, null);

            holder.tradeGridItemBoder = convertView.findViewById(R.id.tradeGridItemBoder);
            holder.tvTradeTitle = convertView.findViewById(R.id.tradeTitle);
            holder.tvTradeMoney = convertView.findViewById(R.id.tradeMoney);
            holder.tvTradeTips = convertView.findViewById(R.id.tradeTips);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        TradeMsg tradeMsg = (TradeMsg) getItem(position);
        titleDrawable = tradeMsg.getTitleDrawable();
        titleMsg = tradeMsg.getTitleMsg();
        money = tradeMsg.getMoney();
        tips = tradeMsg.getTips();

        tradeItemColorDefault = context.getResources()
                .getDrawable(R.drawable.trade_grid_item_boder);

        titleDrawable.setBounds(0, 0, TITLE_DRAWABLE_RIGHT, TITLE_DRAWABLE_BOTTOM);
        holder.tvTradeTitle.setCompoundDrawables(titleDrawable, null,
                null, null);
        holder.tvTradeTitle.setText(titleMsg);
        holder.tvTradeMoney.setText(money);
        holder.tvTradeTips.setText(tips);

        if (clickTemp == position) {
            holder.tradeGridItemBoder.setBackground(itemColor);
            holder.tvTradeTitle.setTextColor(itemTitleColor);
        } else {
            holder.tradeGridItemBoder.setBackground(tradeItemColorDefault);
            holder.tvTradeTitle.setTextColor(Color.BLACK);
        }

        return convertView;
    }

    public void setSelectedItemTitleColor(int color) {
        this.itemTitleColor = color;
    }

    public void setSelectedItemColor(Drawable tradeItemColor) {
        this.itemColor = tradeItemColor;
    }

    public void setSelection(int position) {
        clickTemp = position;
    }

    private class Holder {
        LinearLayout tradeGridItemBoder;
        TextView tvTradeTitle;
        TextView tvTradeMoney;
        TextView tvTradeTips;
    }
}
