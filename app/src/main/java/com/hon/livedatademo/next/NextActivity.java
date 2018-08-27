package com.hon.livedatademo.next;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hon.livedatademo.R;
import com.hon.livedatademo.next.fragments.FragmentA;
import com.hon.livedatademo.next.fragments.FragmentB;

/**
 * Created by Frank on 2018/8/27.
 * E-mail:frank_hon@foxmail.com
 */

public class NextActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mTab1Button;
    private Button mTab2Button;

    private FragmentA mFragmentA;
    private FragmentB mFragmentB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        mTab1Button=findViewById(R.id.btn_tab1);
        mTab2Button=findViewById(R.id.btn_tab2);
        mTab1Button.setOnClickListener(this);
        mTab2Button.setOnClickListener(this);

       initFragments();
    }

    private void initFragments() {
        mFragmentA=new FragmentA();
        mFragmentB=new FragmentB();

        if(!mFragmentA.isAdded()){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_fragment_container,mFragmentA,"FragmentA")
                    .commit();
        }

        if(!mFragmentB.isAdded()){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_fragment_container,mFragmentB,"FragmentB")
                    .commit();
        }

        navigateTo("A");
    }

    private void navigateTo(@NonNull String target){
        if("A".equals(target)){
            getSupportFragmentManager().beginTransaction()
                                        .show(mFragmentA)
                                        .hide(mFragmentB)
                                        .commit();
        }else if("B".equals(target)){
            getSupportFragmentManager().beginTransaction()
                    .show(mFragmentB)
                    .hide(mFragmentA)
                    .commit();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tab1:
                if(mFragmentA.isHidden()){
                    navigateTo("A");
                }
                break;
            case R.id.btn_tab2:
                if(mFragmentB.isHidden()){
                    navigateTo("B");
                }
                break;
            default:
                break;
        }
    }
}
