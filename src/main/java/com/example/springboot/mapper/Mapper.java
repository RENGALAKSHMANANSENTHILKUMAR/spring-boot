package com.example.springboot.mapper;
import com.example.springboot.model.User;

import org.apache.ibatis.annotations.*;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Select("select * from userdetails")
    public List<User> getAllUsers();


    @Select(("select * from userdetails where id =#{id} "))
    public User getUserById(int id);


    @Insert("INSERT INTO userdetails (username, department,salary) VALUES (#{username}, #{department}, #{salary})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addUser(User user);

    @Update("UPDATE userdetails SET  username = #{username}, department = #{department}, salary = #{salary} WHERE id = #{id}")
    void updateUser(User user);

    @Delete("delete from userdetails where id=#{id}")
     void deleteUser(int id);
}
