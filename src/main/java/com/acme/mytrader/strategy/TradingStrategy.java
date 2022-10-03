package com.acme.mytrader.strategy;

import com.acme.mytrader.price.PriceListener;
import com.acme.mytrader.price.impl.PriceListenerImpl;

import java.util.Random;

/**
 * <pre>
 * User Story: As a trader I want to be able to monitor stock prices such
 * that when they breach a trigger level orders can be executed automatically
 * </pre>
 */
public class TradingStrategy {
    private static final double RANGE_MIN = 1.00;
    private static final double RANGE_MAX = 100.00;

    private static final String IBM = "IBM";

    public TradingStrategy() {
    }


    public static void main(String[] args) {
        PriceListener ibmPriceListener = new PriceListenerImpl(IBM, 55.00, 1000);
        buySecurity(ibmPriceListener);
    }

    /**
     * Calls the PriceListener's method to monitor and buy the Security Trade
     * PriceSource implementation is not available, so generating the price in this method
     * @param ibmPriceListener
     */
    public static void buySecurity(PriceListener ibmPriceListener) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            double price = RANGE_MIN + (RANGE_MAX - RANGE_MIN) * rand.nextDouble(); //prices randomly generated for running the application
            System.out.println("Current price is: "+price);
            ibmPriceListener.priceUpdate(IBM, price);
        }
    }
}
