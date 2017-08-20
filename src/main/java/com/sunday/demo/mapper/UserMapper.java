package com.sunday.demo.mapper;

import com.sunday.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.dao.DataAccessException;

import java.util.List;

/**
 * Created by sunday on 2015/8/27.
 */
public interface UserMapper {
    /*
    demo :
    @Select("select * from city where id = #{id}")
    City findCityById(@Param("id") String id);
    */

    @Insert("Insert user set name = #{name}, age = #{age}, password = #{password} ")
    public Integer addUser(User user) throws DataAccessException;

    @Select("select * from user")
    public List<User> getAllUser() throws DataAccessException;

    @Select("select * from user where id = #{id}")
    public User getUserById(Integer id) throws DataAccessException;

    @Delete("delete from user where id = #{id}")
    public Integer delUserById(Integer id) throws DataAccessException;

    @Update({"update user set name = #{name}, age = #{age}, password = #{password} where id = #{id}"})
    public Integer updateUserById(User user) throws DataAccessException;

}
