package com.hon.livedatademo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;

/**
 * Created by Frank on 2018/8/26.
 * E-mail:frank_hon@foxmail.com
 */

public class MainActivity extends AppCompatActivity{

    private NameViewModel mModel;
    private StockViewModel mStockModel;

    private TextView mNameText;
    private Button mChangeNameButton;

    private TextView mMainPriceText;
    private Button mNextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameText=findViewById(R.id.tv_name);
        mChangeNameButton=findViewById(R.id.btn_change_name);
        mMainPriceText=findViewById(R.id.tv_main_price);
        mNextButton=findViewById(R.id.btn_next_activity);


        mChangeNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mModel.getCurrentName().postValue("Chandler Bing");
                mModel.getCurrentName().setValue("Joey Tribiani");
                mModel.getCurrentName().setValue("Ross Geller");
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,NextActivity.class));
            }
        });

        // Get the ViewModel
        mModel= ViewModelProviders.of(this).get(NameViewModel.class);
        mStockModel=ViewModelProviders.of(this).get(StockViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver=new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                mNameText.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        mModel.getCurrentName().observe(this,nameObserver);

        mStockModel.getStockPrice().observe(this, new Observer<BigDecimal>() {
            @Override
            public void onChanged(@Nullable BigDecimal bigDecimal) {
                mMainPriceText.setText(bigDecimal.toString());
            }
        });
    }
}
