/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.event;

import java.util.EventObject;

/**
 * @author 杨文栋
 * @version AbstractEvent.java, v 0.1 2020-09-17 10:55 上午 杨文栋 Exp $$
 */
public class BaseEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public BaseEvent(Object source) {
        super(source);
    }
}
