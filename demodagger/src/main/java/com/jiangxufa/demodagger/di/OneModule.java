package com.jiangxufa.demodagger.di;

import com.jiangxufa.demodagger.bean.Clothes;
import com.jiangxufa.demodagger.bean.PersonBean;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 创建时间：2018/5/24
 * 编写人：lenovo
 * 功能描述：
 */
@Module
public class OneModule {

    @Provides
    public Clothes provideClothes() {
        return new Clothes("紫色");
    }

    @Singleton
    @Provides
    @Named("xigua")
    public PersonBean provideXiguaPersonBean() {
        return new PersonBean("大西瓜");
    }

    @Provides
    @Named("luobo")
    public PersonBean provideLuoboPersonBean() {
        return new PersonBean("大萝卜");
    }

}
