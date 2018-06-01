package com.example.traveltao.mygridview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class TradeGridAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TradeMsg> dataList;
    //private Drawable drawable;

    public TradeGridAdapter(Context context, ArrayList<TradeMsg> dataList){
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
        }else {
            return 0;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.trade_grid_item, null);

            holder.img_trade_title_img = convertView.findViewById(R.id.trade_title_img);
            holder.tv_trade_title = convertView.findViewById(R.id.trade_title);
            holder.tv_trade_money = convertView.findViewById(R.id.trade_money);
            holder.tv_trade_tips = convertView.findViewById(R.id.trade_tips);

            holder.img_trade_title_img.setImageResource(dataList.get(position).getTradeTitleImg());
            holder.tv_trade_title.setText(dataList.get(position).getTradeTitleMsg());
            holder.tv_trade_money.setText(dataList.get(position).getTradeMoney());
            holder.tv_trade_tips.setText(dataList.get(position).getTradeTips());

            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

        return convertView;
    }

    class Holder {
        ImageView img_trade_title_img;
        TextView tv_trade_title;
        TextView tv_trade_money;
        TextView tv_trade_tips;
    }
}
