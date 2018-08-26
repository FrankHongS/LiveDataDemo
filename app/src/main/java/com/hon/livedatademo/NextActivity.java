package com.hon.livedatademo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by Frank on 2018/8/27.
 * E-mail:frank_hon@foxmail.com
 */

public class NextActivity extends AppCompatActivity{

    private StockViewModel mStockModel;

    private TextView mPriceText;
    private Button mChangeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mPriceText=findViewById(R.id.tv_name);
        mChangeButton=findViewById(R.id.btn_change_name);

        mStockModel= ViewModelProviders.of(this).get(StockViewModel.class);

        final Observer<BigDecimal> stockObserver=new Observer<BigDecimal>() {
            @Override
            public void onChanged(@Nullable BigDecimal bigDecimal) {
                mPriceText.setText(bigDecimal.toString());
            }
        };
        mStockModel.getStockPrice().observe(this,stockObserver);
    }
}
