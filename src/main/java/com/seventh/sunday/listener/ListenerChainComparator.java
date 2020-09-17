/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.listener;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;

/**
 * @author 杨文栋
 * @version ListenerList.java, v 0.1 2020-09-17 4:36 下午 杨文栋 Exp $$
 */
public class ListenerChainComparator<E extends AbstractEventListener> extends ArrayList<Function<E, Integer>> implements Comparator<E> {


    @Override
    public int compare(E o1, E o2) {
        for (int i = 0; i < size(); i++) {
            Integer type1 = get(i).apply(o1);
            Integer type2 = get(i).apply(o2);
            if (type1.compareTo(type2) != 0) {
                return type1 - type2;
            }
        }
        return 0;
    }
}
