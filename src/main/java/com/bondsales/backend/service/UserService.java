package com.bondsales.backend.service;

import com.bondsales.backend.dao.entity.User;
import com.bondsales.backend.dao.mapper.UserMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;



//    public Result login(User user) {
//        Result result = new Result();
//        result.setSuccess(false);
//        result.setDetail(null);
//        try {
//            Long userId = userMapper.login(user);
//            if(userId == null) {
//                result.setMsg("Username or password wrong");
//            } else {
//                result.setMsg("Login seccessfully!");
//                result.setSuccess(true);
//                user.setUserid(Math.toIntExact(userId));
//                result.setDetail(user);
//            }
//        } catch (Exception e) {
//            result.setMsg(e.getMessage());
//            e.printStackTrace();
//        }
//        return result;
//    }

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

