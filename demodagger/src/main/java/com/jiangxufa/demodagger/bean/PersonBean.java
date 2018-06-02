package com.jiangxufa.demodagger.bean;

import javax.inject.Inject;

/**
 * 创建时间：2018/5/24
 * 编写人：lenovo
 * 功能描述：
 */

public class PersonBean {

    String name;
    @Inject
    Clothes clothes;

    @Inject
    public PersonBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonBean{" +
                "name='" + name + '\'' +
                ", clothes=" + clothes +
                '}';
    }
}
