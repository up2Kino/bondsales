package com.bondsales.backend.service;

import com.bondsales.backend.common.UserInfo;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
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

//    public int delete(Long id){
//        return userMapper.deleteByPrimaryKey(id);
//    }

    public boolean login(String username, String password) {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        User result = userMapper.selectByUserName(userInfo);
        if (result.getUsername().equals(username) && result.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

