package com.jiangxufa.demodagger.bean;

import javax.inject.Inject;

/**
 * 创建时间：2018/5/24
 * 编写人：lenovo
 * 功能描述：
 */

public class Clothes {

    String color;

    @Inject
    public Clothes(String color) {
        this.color = color;
    }
}
