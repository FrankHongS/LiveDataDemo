package com.hon.livedatademo.next;

import android.arch.lifecycle.ViewModel;

/**
 * Created by Frank on 2018/8/27.
 * E-mail:frank_hon@foxmail.com
 */

public class StockViewModel extends ViewModel{

    private StockLiveData mStockPrice;

    public StockLiveData getStockPrice(){
        if (mStockPrice==null){
            mStockPrice=StockLiveData.getInstance();
        }

        return mStockPrice;
    }
}
