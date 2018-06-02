package com.jiangxufa.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * 创建时间：2018/5/24
 * 编写人：lenovo
 * 功能描述：
 */

public class FragActivity extends AppCompatActivity {

    private TextView view;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fra);

        final FrameLayout frameLayout = findViewById(R.id.container);

//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.add(R.id.container,new MyFragment()).commit();


//        Observable.just(0)
//                .delay(10, TimeUnit.MILLISECONDS)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(Integer integer) throws Exception {
//                        Log.i(TAG, "accept: " + integer);
//                    }
//                });


        Observable.just(0)
                .delay(3000, TimeUnit.MILLISECONDS)
                .flatMap(new Function<Integer, ObservableSource<TextView>>() {
                    @Override
                    public ObservableSource<TextView> apply(Integer integer) throws Exception {
                        view = new TextView(FragActivity.this);
                        view.setText("aasdasdasdasd");
                        view.setTextSize(22);
                        return  Observable.just(view);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        frameLayout.addView(view);
                    }
                });
    }

    private static final String TAG = "FragActivity";
}
