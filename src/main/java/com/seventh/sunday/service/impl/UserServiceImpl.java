package com.seventh.sunday.service.impl;

import com.seventh.sunday.dao.UserDAO;
import com.seventh.sunday.entity.UserDO;
import com.seventh.sunday.service.UserService;
import com.seventh.sunday.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

/**
 * @author ami
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public UserVO getUserById(Long id) {
        UserDO user = userDAO.getUserById(id);
        UserVO userVO = new UserVO();
        BeanCopier beanCopier = BeanCopier.create(UserDO.class, UserVO.class, false);
        beanCopier.copy(user, userVO, null);
        return userVO;
    }
}
