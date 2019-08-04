package com.seventh.sunday.dao;

import com.seventh.sunday.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ami
 */
@Mapper
public interface UserDAO {
    /**
     * 1
     * @param id
     * @return
     */
    UserDO getUserById(@Param("id") Long id);
}
