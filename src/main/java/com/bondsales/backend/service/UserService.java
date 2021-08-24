package com.bondsales.backend.service;

import com.bondsales.backend.common.UserInfo;
import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public String ListUser(){
//        return  userMapper.selectAll();
        Gson gson = new Gson();
        return gson.toJson(userMapper.selectAll());
    }

    public boolean insertUser(User user) {
        try {
            userMapper.insert(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    public int Update(User user){
        return userMapper.updateByPrimaryKey(user);
    }

    public int delete(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public boolean login(String logname, String password) {

        UserInfo userInfo = new UserInfo();
        userInfo.setLogname(logname);
        userInfo.setPassword(password);
        User result = userMapper.selectByUserName(userInfo);
        if (result.getLogname().equals(logname) && result.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

