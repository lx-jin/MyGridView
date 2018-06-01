package com.example.traveltao.mygridview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public  class TradeGridView extends GridView{

    public TradeGridView(Context context){
        super(context);
        set();
    }

    public TradeGridView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        set();
    }

    public TradeGridView(Context context, AttributeSet attributeSet, int defStyleAttr){
        super(context, attributeSet, defStyleAttr);
        set();
    }

    private void set(){
        setNumColumns(2);
        setBackgroundColor(getResources().getColor(R.color.littlegray));
        setVerticalSpacing(40);
        setHorizontalSpacing(40);
    }
}
