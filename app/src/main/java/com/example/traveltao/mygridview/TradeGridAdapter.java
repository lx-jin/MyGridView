package com.example.traveltao.mygridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TradeGridAdapter extends BaseAdapter {
    private static int ROW_NUMBER =2;
    private static int itemMaxNum =4;
    private List<Map<String, Object>> dataList;
    private Context context;
    private GridView tradeGridView;

    private float buy_money, buy_cash, sale_money, sale_cash;

    private String[] tradeTitleMsg = new String[]{"我要买现金", "我要买现汇", "我要卖现金", "我要卖现汇"};
    private String[] tradeMoney = new String[]{"null", "null", "null", "null"};
    private String[] tradeTips = new String[]{"银行向客户卖出现钞的价格", "银行向客户卖出现汇的价格",
            "银行向客户买入现钞的价格", "银行向客户买入现汇的价格"};

    public TradeGridAdapter(Context context, GridView gridView){
        this.context = context;
        tradeGridView = gridView;
        dataList = new ArrayList<>();

        for (int i=0; i<itemMaxNum; i++) {
            Map<String, Object> map = new HashMap<>();
            //map.put("buy_title_img", buy_title_img);
            map.put("trade_title", tradeTitleMsg[i]);
            map.put("trade_money", tradeMoney[i]);
            map.put("trade_tips", tradeTips[i]);
            dataList.add(map);
        }
    }

    public void setMoney(String[] money){
        for (int i=0; i<itemMaxNum; i++) {
            tradeMoney[i] = money[i];
        }
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

            holder.tv_trade_title = convertView.findViewById(R.id.trade_title);
            holder.tv_trade_money = convertView.findViewById(R.id.trade_money);
            holder.tv_trade_tips = convertView.findViewById(R.id.trade_tips);

            holder.tv_trade_title.setText(tradeTitleMsg[position]);
            holder.tv_trade_money.setText(tradeMoney[position]);
            holder.tv_trade_tips.setText(tradeTips[position]);

            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }

//        AbsListView.LayoutParams param = new AbsListView.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, tradeGridView.getHeight() / ROW_NUMBER);
//        convertView.setLayoutParams(param);
        return convertView;
    }

    class Holder {
        TextView tv_trade_title;
        TextView tv_trade_money;
        TextView tv_trade_tips;
    }
}
