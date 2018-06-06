package com.example.traveltao.mygridview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class TradeGridView extends GridView {

    private ArrayList<TradeMsg> tradeMsgArrayList;
    private TradeGridAdapter tradeGridAdapter;

    private OnItemClickListener listener;

    private int itemTitleColor = Color.BLUE;
    private Drawable itemColor = getContext().getResources().getDrawable(
            R.drawable.trade_grid_item_theme_boder);

    private static final int BUY_CASH_POS = 0;
    private static final int BUY_CURRENCY_POS = 1;
    private static final int SALE_CASH_POS = 2;
    private static final int SALE_CURRENCY_POS = 3;

    public TradeGridView(Context context) {
        this(context, null);
    }

    public TradeGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TradeGridView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);

        // TODO: init code
        this.setOnItemClickListener(new OnTradeItemClickListener());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tradeMsgArrayList = new ArrayList<>();
        tradeGridAdapter = new TradeGridAdapter(getContext(), tradeMsgArrayList);
        tradeGridAdapter.setSelectedItemColor(itemColor);
        tradeGridAdapter.setSelectedItemTitleColor(itemTitleColor);
        tradeGridAdapter.setSelection(BUY_CASH_POS);
        setAdapter(tradeGridAdapter);


    }

    public void setDatas(ArrayList<TradeMsg> list) {
        if (null != list && 0 < list.size()) {
            tradeMsgArrayList.clear();
            tradeMsgArrayList.addAll(list);
            tradeGridAdapter.notifyDataSetChanged();
        }
    }

    public void setDatas(TradeMsg buyCash, TradeMsg buyCurrency, TradeMsg sellCash,
                         TradeMsg sellCurrency) {
        ArrayList<TradeMsg> list = new ArrayList<>(4);
        list.add(buyCash);
        list.add(buyCurrency);
        list.add(sellCash);
        list.add(sellCurrency);
        setDatas(list);
    }

    class OnTradeItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            tradeGridAdapter.setSelection(position);
            tradeGridAdapter.notifyDataSetChanged();

            if (null != listener) {
                TradeMsg tradeMsg = (TradeMsg) tradeGridAdapter.getItem(position);
                switch (position) {
                    case BUY_CASH_POS:
                        listener.onBuyCash(tradeMsg);
                        break;
                    case BUY_CURRENCY_POS:
                        listener.onBuyCurrency(tradeMsg);
                        break;
                    case SALE_CASH_POS:
                        listener.onSellCash(tradeMsg);
                        break;
                    case SALE_CURRENCY_POS:
                        listener.onSellCurrency(tradeMsg);
                        break;
                }
            }
        }
    }

    public void setTradeOnItemClickListener(OnItemClickListener l) {
        this.listener = l;
    }

    public void setSelectedItemTitleColor(int color) {
        this.itemTitleColor = color;
        tradeGridAdapter.setSelectedItemTitleColor(itemTitleColor);
    }

    public void setSelectedItemColor(Drawable tradeItemColor) {
        this.itemColor = tradeItemColor;
        tradeGridAdapter.setSelectedItemColor(itemColor);
    }

    public interface OnItemClickListener {
        void onBuyCash(TradeMsg tradeMsg);
        void onBuyCurrency(TradeMsg tradeMsg);
        void onSellCash(TradeMsg tradeMsg);
        void onSellCurrency(TradeMsg tradeMsg);
    }
}
