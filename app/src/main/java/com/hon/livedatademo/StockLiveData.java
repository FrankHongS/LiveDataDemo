package com.hon.livedatademo;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import java.math.BigDecimal;

/**
 * Created by Frank on 2018/8/27.
 * E-mail:frank_hon@foxmail.com
 */

public class StockLiveData extends LiveData<BigDecimal> {

    private static StockLiveData sInstance;
    private StockManager mStockManager;

    private StockManager.SimplePriceListener mListener=new StockManager.SimplePriceListener() {
        @Override
        public void onPriceChanged(BigDecimal price) {
            setValue(price);
        }
    };

    public static StockLiveData getInstance() {
        if (sInstance == null){
            synchronized (StockLiveData.class) {
                if (sInstance == null) {
                    sInstance=new StockLiveData();
                }
            }
        }

        return sInstance;
    }

    private StockLiveData() {
        mStockManager = new StockManager();
    }

    @Override
    protected void onActive() {
        Log.d("Hon", "onActive: ");
        mStockManager.requestPriceUpdates(mListener);
    }

    @Override
    protected void onInactive() {
        Log.d("Hon", "onInactive: ");
        mStockManager.removeUpdates(mListener);
    }

}
