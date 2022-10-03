package com.acme.mytrader.strategy;

import com.acme.mytrader.price.impl.PriceListenerImpl;
import jdk.jfr.internal.tool.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TradingStrategyTest {
    @Mock
    TradingStrategy tradingStrategy;

    @Mock
    PriceListenerImpl ibmPriceListener;



    @Test
    public void testBuySuccessful() {
        tradingStrategy.buySecurity(ibmPriceListener);
        Mockito.verify(ibmPriceListener, times(10)).priceUpdate(anyString(),anyDouble());
    }
}
