package com.example.traveltao.mygridview;

import java.util.ArrayList;

public class TradeMsgList {
    private static ArrayList<TradeMsg> TradeMsgArray = new ArrayList<TradeMsg>();

    private TradeMsgList(){    }

    public static ArrayList<TradeMsg> getTradeMsgList(){
        return TradeMsgArray;
    }
}
