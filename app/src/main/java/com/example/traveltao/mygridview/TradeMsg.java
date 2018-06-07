package com.example.traveltao.mygridview;

import android.graphics.drawable.Drawable;

public class TradeMsg {
    private final Drawable titleDrawable;
    private final String titleMsg;
    private  String money;
    private final String tips;

    public TradeMsg(Drawable titleDrawable, String titleMsg, String money, String tips) {
        this.titleDrawable = titleDrawable;
        this.titleMsg = titleMsg;
        this.money = money;
        this.tips = tips;
    }

    private TradeMsg(Builder builder){
        this.titleDrawable = builder.titleDrawable;
        this.titleMsg = builder.titleMsg;
        this.money = builder.money;
        this.tips = builder.tips;
    }

    public void setMoney(String money) {
        this.money = money;
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

    public static final class Builder {
        private Drawable titleDrawable;
        private String titleMsg;
        private String money;
        private String tips;

        public Builder titleDrawable(Drawable titleDrawable) {
            this.titleDrawable = titleDrawable;
            return this;
        }

        public Builder titleMsg(String titleMsg) {
            this.titleMsg = titleMsg;
            return this;
        }

        public Builder money(String money) {
            this.money = money;
            return this;
        }

        public Builder tips(String tips) {
            this.tips = tips;
            return this;
        }

        public TradeMsg build() {
            return new TradeMsg(this);
        }
    }

}
