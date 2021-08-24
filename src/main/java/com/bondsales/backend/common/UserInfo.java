package com.bondsales.backend.common;

import lombok.Data;

//新建一个类存logname 和 password用于login放入session
@Data
public class UserInfo {
    private String logname;
    private String password;
}
