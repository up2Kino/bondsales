package com.bondsales.backend.controller;

import com.bondsales.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserService userservice;

    @RequestMapping("/ListUser")
    @ResponseBody
    public String ListUser(){
        return userservice.ListUser();
    }

//    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
//    public String delete(Long id) {
//        int result = userservice.delete(id);
//        if (result < 1) {
//            return "删除失败";
//        } else {
//            return "删除成功";
//        }
//    }
//
//    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
//    public String update(User user) {
//        int result = userservice.Update(user);
//        if (result >= 1) {
//            return "修改成功";
//        } else {
//            return "修改失败";
//        }
//    }

//    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
//    public boolean insert(User user) {
//        return userservice.insertUser(user);
//    }


}
