package com.hon.livedatademo.next;

import java.math.BigDecimal;

/**
 * Created by Frank on 2018/8/27.
 * E-mail:frank_hon@foxmail.com
 */

public class StockManager {

    public void requestPriceUpdates(SimplePriceListener listener){
        listener.onPriceChanged(new BigDecimal(1000));
    }

    public void removeUpdates(SimplePriceListener listener){
        listener=null;
    }

    public interface SimplePriceListener{

        void onPriceChanged(BigDecimal price);

    }
}
