/**
 * Alibaba.com.cn Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.seventh;

import com.seventh.model.UserRequestVO;
import com.seventh.model.UserResponseVO;

/**
 * @author 杨文栋
 * @version RpcUserService.java, v 0.1 2020-09-16 2:06 下午 杨文栋 Exp $$
 */
public interface RpcUserService {
    UserResponseVO getUserInfo(UserRequestVO userRequestVO);
}
