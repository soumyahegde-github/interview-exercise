package com.acme.mytrader.price.impl;

import com.acme.mytrader.execution.ExecutionService;
import com.acme.mytrader.price.PriceListener;

public class PriceListenerImpl implements PriceListener {
    private final String security;
    private final double triggerLevel;

    private final int quantityToPurchase;

    private boolean isTradeExecuted;

    public boolean isTradeExecuted() {
        return isTradeExecuted;
    }

    public PriceListenerImpl(String security, double triggerLevel, int quantityToPurchase) {
        this.security = security;
        this.triggerLevel = triggerLevel;
        this.quantityToPurchase = quantityToPurchase;
    }

    @Override
    public void priceUpdate(String security, double price) {
        if (canBuy(security, price)) {
            new ExecutionService() {
                @Override
                public void buy(String security, double price, int volume) {
                    System.out.println("Buying " +security+". Units: "+volume+" Price: "+price);
                }

                @Override
                public void sell(String security, double price, int volume) {}
            }.buy(security, price, 100);

            isTradeExecuted = true;
        }
    }

    private boolean canBuy(String security, double price) {
        return (!isTradeExecuted) && this.security.equals(security) && (price < this.triggerLevel);
    }
}
