/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.sunday.listener;

import com.alibaba.fastjson.JSON;
import com.seventh.sunday.event.BaseEvent;
import com.seventh.sunday.event.OrderCallBackEvent;

/**
 * 改变库存状态
 *
 * @author 杨文栋
 * @version NotifyStockModifyListener.java, v 0.1 2020-09-17 1:24 下午 杨文栋 Exp $$
 */
public class NotifyStockModifyListener extends AbstractEventListener {
    public NotifyStockModifyListener(int bigType) {
        super(bigType);
    }

    public NotifyStockModifyListener(int bigType, int smallType) {
        super(bigType, smallType);
    }

    @Override
    public void execute(BaseEvent event) {
        if (!validate(event)) {
            return;
        }
        System.out.println("开始执行监听器" + this.getClass().getCanonicalName() + getBigType() + "..." + getSmallType());

        Object data = event.getSource();
        System.out.println(JSON.toJSONString(data));
    }
}
