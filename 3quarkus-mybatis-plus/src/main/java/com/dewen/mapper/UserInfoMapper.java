package com.dewen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dewen.entity.UserInfoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfoEntity> {

    // @Select("SELECT * FROM USERS WHERE id = #{id}")
    // UserInfoEntity getUser(Integer id);
    //
    // @Insert("INSERT INTO USERS (id, name) VALUES (#{id}, #{name})")
    // Integer createUser(@Param("id") Integer id, @Param("name") String name);
    //
    // @Delete("DELETE FROM USERS WHERE id = #{id}")
    // Integer removeUser(Integer id);
}

