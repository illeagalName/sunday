/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 杨文栋
 * @version UserResponseVO.java, v 0.1 2020-09-16 2:07 下午 杨文栋 Exp $$
 */
@Data
public class UserResponseVO implements Serializable {
    private Long id;
    private String name;
}
