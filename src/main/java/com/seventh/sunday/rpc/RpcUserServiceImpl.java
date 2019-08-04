package com.seventh.sunday.rpc;

import com.seventh.RpcUserService;
import com.seventh.model.UserRequestVO;
import com.seventh.model.UserResponseVO;
import com.seventh.sunday.service.UserService;
import com.seventh.sunday.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

@Service("rpcUserService")
public class RpcUserServiceImpl implements RpcUserService {


    @Autowired
    UserService userService;

    @Override
    public UserResponseVO getUserInfo(UserRequestVO userRequestVO) {
        UserVO user = userService.getUserById(userRequestVO.getUid());
        UserResponseVO userResponseVO = new UserResponseVO();
        BeanCopier beanCopier = BeanCopier.create(UserVO.class, UserResponseVO.class, false);
        beanCopier.copy(user, userResponseVO, null);
        return userResponseVO;
    }
}
