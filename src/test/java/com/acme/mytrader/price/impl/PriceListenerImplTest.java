package com.acme.mytrader.price.impl;

import com.acme.mytrader.execution.ExecutionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class PriceListenerImplTest {

    PriceListenerImpl priceListener;

    @Before
    public void setup(){
        priceListener = new PriceListenerImpl("IBM", 55.00, 1000);
    }
    
    @Test
    public void testPriceUpdateSuccessful() {
        priceListener.priceUpdate("IBM", 5);
        Assert.assertEquals(priceListener.isTradeExecuted(),true);
    }


    @Test
    public void testPriceUpdateIBMUnSuccesful() {
        priceListener.priceUpdate("IBM", 59);
        Assert.assertEquals(priceListener.isTradeExecuted(),false);
    }

    @Test
    public void testPriceUpdateABCUnSuccesful() {
        priceListener.priceUpdate("ABC", 5);
        Assert.assertEquals(priceListener.isTradeExecuted(),false);
    }
}
