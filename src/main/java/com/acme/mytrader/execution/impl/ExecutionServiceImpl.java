package com.acme.mytrader.execution.impl;

import com.acme.mytrader.execution.ExecutionService;

public class ExecutionServiceImpl implements ExecutionService {
    @Override
    public void buy(String security, double price, int volume) {
        System.out.println("Buying " +security+". Units: "+volume+" Price: "+price);
    }

    @Override
    public void sell(String security, double price, int volume) {}
}
