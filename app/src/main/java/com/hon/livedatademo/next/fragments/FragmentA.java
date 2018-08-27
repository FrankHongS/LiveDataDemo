package com.hon.livedatademo.next.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hon.livedatademo.R;
import com.hon.livedatademo.next.StockViewModel;

import java.math.BigDecimal;

/**
 * Created by Frank on 2018/8/27.
 * E-mail:frank_hon@foxmail.com
 */

public class FragmentA extends Fragment{

    private StockViewModel mStockModel;

    private TextView mAText;

    public FragmentA(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_a,container,false);
        init(view);

        //动态加载获取实例
        mStockModel= ViewModelProviders.of(this).get(StockViewModel.class);

        mStockModel.getStockPrice().observe(getActivity(), new Observer<BigDecimal>() {
            @Override
            public void onChanged(@Nullable BigDecimal bigDecimal) {
                mAText.setText(bigDecimal.toString());
            }
        });

        return view;
    }

    private void init(View view) {
        mAText=view.findViewById(R.id.tv_a);
    }
}
