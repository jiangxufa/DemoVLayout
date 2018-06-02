package com.jiangxufa.demodagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jiangxufa.demodagger.bean.PersonBean;
import com.jiangxufa.demodagger.di.DaggerDemoComponent;
import com.jiangxufa.demodagger.di.OneModule;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {
    @Named("xigua")
    @Inject
    PersonBean personBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerDemoComponent.builder()
                .oneModule(new OneModule())
                .build()
                .inject(this);


        toast(personBean.toString());

    }

    public void toast(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


}
