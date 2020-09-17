/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.event;

/**
 * @author 杨文栋
 * @version NotifyStockModifyEvent.java, v 0.1 2020-09-17 2:17 下午 杨文栋 Exp $$
 */
public class OrderCallBackEvent extends BaseEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public OrderCallBackEvent(Object source) {
        super(source);
    }
}
