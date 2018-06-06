package com.example.traveltao.mygridview;

import android.graphics.drawable.Drawable;

public class TradeMsg {
    private Drawable titleDrawable;
    private String titleMsg;
    private String money;
    private String tips;

    public TradeMsg() {

    }

    public TradeMsg(Drawable titleDrawable, String titleMsg, String money, String tips) {
        this.titleDrawable = titleDrawable;
        this.titleMsg = titleMsg;
        this.money = money;
        this.tips = tips;
    }

    public Drawable getTitleDrawable() {
        return titleDrawable;
    }

    public String getTitleMsg() {
        return titleMsg;
    }

    public String getMoney() {
        return money;
    }

    public String getTips() {
        return tips;
    }
}
