package com.jiangxufa.demodagger.di;

import com.jiangxufa.demodagger.MainActivity;
import com.jiangxufa.demodagger.bean.Student;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 创建时间：2018/5/24
 * 编写人：lenovo
 * 功能描述：
 */
@Singleton
@Component(modules = {OneModule.class})
public interface DemoComponent {

    void inject(MainActivity activity);

    Student student();
}
