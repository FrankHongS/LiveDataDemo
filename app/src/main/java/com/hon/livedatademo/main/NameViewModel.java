package com.hon.livedatademo.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by Frank on 2018/8/26.
 * E-mail:frank_hon@foxmail.com
 */

public class NameViewModel extends ViewModel{
    private MutableLiveData<String> mCurrentName;

    public MutableLiveData<String> getCurrentName(){
        if(mCurrentName==null){
            mCurrentName=new MutableLiveData<>();
        }

        return mCurrentName;
    }
}
