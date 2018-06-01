package com.example.traveltao.mygridview;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static int tradeGridViewItemNum = 4;

    private TradeGridView tradeGridView;

    private int tradeTitleImg = R.drawable.test_b;

    private String[] tradeTitleMsg = new String[]{"我要买现金", "我要买现汇", "我要卖现金", "我要卖现汇"};
    private String[] tradeMoney = new String[]{"6666", "6666", "6666", "6666"};
    private String[] tradeTips = new String[]{"银行向客户卖出现钞的价格", "银行向客户卖出现汇的价格",
            "银行向客户买入现钞的价格", "银行向客户买入现汇的价格"};

    private ArrayList<TradeMsg> tradeMsgArrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resetdata();
        tradeGridView = findViewById(R.id.tradeGridView);
        tradeGridView.setDatas(tradeMsgArrayList);
    }

    private void resetdata(){
        tradeMsgArrayList = TradeMsgList.getTradeMsgList();
        for (int i = 0; i<tradeGridViewItemNum; i++) {
            TradeMsg tradeMsg = new TradeMsg(tradeTitleImg, tradeTitleMsg[i], tradeMoney[i],
                    tradeTips[i]);
            tradeMsgArrayList.add(tradeMsg);
        }
    }
}
