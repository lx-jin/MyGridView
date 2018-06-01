package com.example.traveltao.mygridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SimpleAdapter;

public class MainActivity extends AppCompatActivity {


    private SimpleAdapter simpleAdapter;
    private GridView tradeGridView;

    private int buy_title_img = R.mipmap.test_a;

    private String[] tradeMoney = new String[]{"6666", "6666", "6666", "6666"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tradeGridView = findViewById(R.id.tradeGridView);

        TradeGridAdapter tradeGridAdapter = new TradeGridAdapter(this, tradeGridView);
        tradeGridAdapter.setMoney(tradeMoney);
        tradeGridView.setAdapter(tradeGridAdapter);
    }
}
