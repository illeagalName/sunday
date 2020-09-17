/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.listener;

import com.seventh.sunday.event.BaseEvent;

import java.util.EventListener;

/**
 * @author 杨文栋
 * @version EventListener.java, v 0.1 2020-09-17 11:03 上午 杨文栋 Exp $$
 */
public interface BaseEventListener extends EventListener {

    /**
     * 校验事件合法性
     *
     * @param event
     * @return
     */
    boolean validate(BaseEvent event);

    /**
     * 执行事件
     *
     * @param event
     */
    void execute(BaseEvent event);
}
