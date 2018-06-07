package com.example.traveltao.mygridview;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "test";
    private int tradeGridViewItemNum = 4;

    private TradeGridView tradeGridView;

    private Drawable drawable;
    private int themeColor = Color.RED;

    private int tradeTitleImg[] = new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher_round};
    private String[] tradeTitleMsg = new String[]{"我要买现金", "我要买现汇", "我要卖现金", "我要卖现汇"};
    private String[] tradeMoney = new String[]{"¥6.6666", "¥6.6667", "¥6.6668", "¥6.6669"};
    private String[] tradeTips = new String[]{"银行向客户卖出现钞的价格", "银行向客户卖出现汇的价格",
            "银行向客户买入现钞的价格", "银行向客户买入现汇的价格"};

    private TradeMsg tradeMsg;
    private TradeMsg tradeMsg1, tradeMsg2, tradeMsg3, tradeMsg4;
    private ArrayList<TradeMsg> tradeMsgArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tradeGridView = findViewById(R.id.tradeGridView);

        //resetData();
        //tradeGridView.setDatas(tradeMsgArrayList);
        //resetData2();
        buildData();
        tradeGridView.updateDatas(tradeMsg1, tradeMsg2, tradeMsg3, tradeMsg4);
        final Drawable tradeItemColor =
                getResources().getDrawable(R.drawable.trade_grid_item_theme2_boder);
        tradeGridView.setTradeOnItemClickListener(new TradeGridView.OnItemClickListener() {
            @Override
            public void onItemClicked(int position, TradeMsg tradeMsg) {
                switch (position) {
                    case TradeGridView.BUY_CASH_POS:
                        Log.i(TAG, "onBuyCash" + tradeMsg.getMoney());

                        tradeGridView.setSelectedItemColor(tradeItemColor);
                        tradeGridView.setSelectedItemTitleColor(Color.RED);

                        tradeMsg1.setMoney("¥9.9999");
                        tradeGridView.updateDatas(tradeMsg1, tradeMsg2, tradeMsg3, tradeMsg4);

                        Log.i(TAG, "onBuyCash" + tradeMsg.getMoney());
                        break;
                    case TradeGridView.BUY_CURRENCY_POS:
                        break;
                    case TradeGridView.SALE_CASH_POS:
                        break;
                    case TradeGridView.SALE_CURRENCY_POS:
                        break;
                }
            }
        });

    }

    private void resetData() {
        tradeMsgArrayList = new ArrayList<>();
        for (int i = 0; i < tradeGridViewItemNum; i++) {
            drawable = getResources().getDrawable(tradeTitleImg[i]);
            tradeMsg = new TradeMsg(drawable, tradeTitleMsg[i], tradeMoney[i], tradeTips[i]);
            tradeMsgArrayList.add(tradeMsg);
        }
    }

    /*private void resetData2() {
        tradeMsg1 = new TradeMsg(getResources().getDrawable(
                tradeTitleImg[0]), tradeTitleMsg[0], tradeMoney[0], tradeTips[0]);

        tradeMsg2 = new TradeMsg(getResources().getDrawable(
                tradeTitleImg[1]), tradeTitleMsg[1], tradeMoney[1], tradeTips[1]);

        tradeMsg3 = new TradeMsg(getResources().getDrawable(
                tradeTitleImg[2]), tradeTitleMsg[2], tradeMoney[2], tradeTips[2]);

        tradeMsg4 = new TradeMsg(getResources().getDrawable(
                tradeTitleImg[3]), tradeTitleMsg[3], tradeMoney[3], tradeTips[3]);
    }*/

    private void buildData() {
        TradeMsg.Builder builder = new TradeMsg.Builder();
        tradeMsg1 = builder.titleDrawable(getResources().getDrawable(R.mipmap.ic_launcher))
                .titleMsg("我要买现金").money("¥6.6666").tips("银行向客户卖出现钞的价格").build();
        tradeMsg2 = builder.titleDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round))
                .titleMsg("我要买现汇").money("¥6.6667").tips("银行向客户卖出现汇的价格").build();
        tradeMsg3 = builder.titleDrawable(getResources().getDrawable(R.mipmap.ic_launcher))
                .titleMsg("我要卖现金").money("¥6.6668").tips("银行向客户买入现钞的价格").build();
        tradeMsg4 = builder.titleDrawable(getResources().getDrawable(R.mipmap.ic_launcher_round))
                .titleMsg("我要卖现汇").money("¥6.6669").tips("银行向客户买入现汇的价格").build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tradeGridView.setTradeOnItemClickListener(null);
    }
}
