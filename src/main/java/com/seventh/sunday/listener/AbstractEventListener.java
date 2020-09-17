/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.listener;

import com.seventh.sunday.event.BaseEvent;

/**
 * @author 杨文栋
 * @version AbstractEventListener.java, v 0.1 2020-09-17 11:06 上午 杨文栋 Exp $$
 */
public abstract class AbstractEventListener implements BaseEventListener {

    /**
     * 大类
     */
    private int bigType;
    /**
     * 小类
     */
    private int smallType;

    public AbstractEventListener(int bigType) {
        this(bigType, 1);
    }

    public AbstractEventListener(int bigType, int smallType) {
        this.bigType = bigType;
        this.smallType = smallType;
    }

    public int getBigType() {
        return bigType;
    }

    public int getSmallType() {
        return smallType;
    }

    /**
     * 判断监听事件合法性
     *
     * @param event
     * @return
     */
    @Override
    public boolean validate(BaseEvent event) {
        return true;
    }

    /**
     * 具体的业务监听器需要单独实现
     *
     * @param event
     */
    @Override
    public abstract void execute(BaseEvent event);
}
