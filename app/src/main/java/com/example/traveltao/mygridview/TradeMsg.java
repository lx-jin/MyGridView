package com.example.traveltao.mygridview;

import android.graphics.drawable.Drawable;
import android.media.Image;

public class TradeMsg {
    private int tradeTitleImg;
    private Drawable tradeTitleDrawable;
    private String tradeTitleMsg;
    private String tradeMoney;
    private String tradeTips;

    public TradeMsg(String tradeTitleMsg, String tradeMoney, String tradeTips){
        this.tradeTitleMsg = tradeTitleMsg;
        this.tradeMoney = tradeMoney;
        this.tradeTips = tradeTips;
    }

    public TradeMsg(int tradeTitleImg, String tradeTitleMsg, String tradeMoney, String tradeTips){
        this.tradeTitleImg = tradeTitleImg;
        this.tradeTitleMsg = tradeTitleMsg;
        this.tradeMoney = tradeMoney;
        this.tradeTips = tradeTips;
    }

    public TradeMsg(Drawable tradeTitleDrawable, String tradeTitleMsg, String tradeMoney, String tradeTips){
        this.tradeTitleDrawable = tradeTitleDrawable;
        this.tradeTitleMsg = tradeTitleMsg;
        this.tradeMoney = tradeMoney;
        this.tradeTips = tradeTips;
    }

    public int getTradeTitleImg() {
        return tradeTitleImg;
    }

    public Drawable getTradeTitleDrawable() {
        return tradeTitleDrawable;
    }

    public String getTradeTitleMsg() {
        return tradeTitleMsg;
    }

    public String getTradeMoney() {
        return tradeMoney;
    }

    public String getTradeTips() {
        return tradeTips;
    }
}
