package com.example.traveltao.mygridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

import java.util.ArrayList;

public  class TradeGridView extends GridView{

    private ArrayList<TradeMsg> tradeMsgArrayList;
    private TradeGridAdapter tradeGridAdapter;

    public TradeGridView(Context context){
        super(context);
    }

    public TradeGridView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }

    public TradeGridView(Context context, AttributeSet attributeSet, int defStyleAttr){
        super(context, attributeSet, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tradeMsgArrayList = new ArrayList<>();
        tradeGridAdapter = new TradeGridAdapter(getContext(), tradeMsgArrayList);
        setAdapter(tradeGridAdapter);
    }

    public void setDatas(ArrayList<TradeMsg> list) {
        if (null != list && 0 < list.size()) {
            tradeMsgArrayList.clear();
            tradeMsgArrayList.addAll(list);
            tradeGridAdapter.notifyDataSetChanged();
        }
    }

}
