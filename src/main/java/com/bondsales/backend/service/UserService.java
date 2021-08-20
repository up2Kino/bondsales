package com.bondsales.backend.service;

import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public boolean insertUser(User user) {
        try {
            userMapper.insert(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public String ListUser(){
//        return  userMapper.selectAll();
        Gson gson = new Gson();
        return gson.toJson(userMapper.selectAll());
    }

    public int Update(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int delete(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }
}

