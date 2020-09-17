/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.listener;

import com.seventh.sunday.event.BaseEvent;

import java.util.List;
import java.util.function.Function;

/**
 * @author 杨文栋
 * @version ListenerManager.java, v 0.1 2020-09-17 2:24 下午 杨文栋 Exp $$
 */
public class ListenerManager {
    private List<AbstractEventListener> listeners;

    private static Function<AbstractEventListener, Integer> getBigTypeFunction = AbstractEventListener::getBigType;
    private static Function<AbstractEventListener, Integer> getSmallTypeFunction = AbstractEventListener::getSmallType;

    private static ListenerChainComparator listenerChainComparator;

    static {
        listenerChainComparator = new ListenerChainComparator();
        listenerChainComparator.add(getBigTypeFunction);
        listenerChainComparator.add(getSmallTypeFunction);

    }

    public ListenerManager(List<AbstractEventListener> listeners) {
        listeners.sort(listenerChainComparator);
        this.listeners = listeners;
    }

    /**
     * 通知监听器执行事件
     *
     * @param e
     */
    public void handleEvent(BaseEvent e) {
        listeners.forEach(listener -> {
            listener.execute(e);
        });
    }

}
