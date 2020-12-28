package org.cy.base.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.cy.base.domain.User;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM T_USER WHERE NAME = #{name}")
    User findUserByName(@Param("name") String name);

    @Select("INSERT INTO T_USER(NAME,AGE) VALUES(#{name},#{age})")
    Integer insert(@Param("name") String name, @Param("age") Integer age);

    @Select("SELECT * FROM T_USER")
    List<User> findAll();
}
