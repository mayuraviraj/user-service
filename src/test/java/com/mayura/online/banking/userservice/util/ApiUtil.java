package com.mayura.online.banking.userservice.util;

import com.mayura.online.banking.userservice.infarstructure.web.UserVO;

public class ApiUtil {

    public static UserVO getUser(){
        return UserVO.builder().build();
    }
}
