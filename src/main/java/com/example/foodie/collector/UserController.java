package com.example.foodie.collector;

import com.example.foodie.bean.User;
import com.example.foodie.dao.UserMapper;
import com.example.foodie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired()
    private UserService userService;

    @Autowired(required = true)
    private UserMapper userMapper;

    @RequestMapping("/user")
    public String userTest(){
        User user = userMapper.selectByPrimaryKey(12);
        return "" + user.toString();
    }


    /**
     * 登录
     * @param request
     * @param userName
     * @param password
     * @param paramCode
     */
//    @PostMapping(value = "/login.do")
//    public void login(HttpServletRequest request,
//                        @RequestParam("userName")String userName,
//                        @RequestParam("password") String password,
//                        @RequestParam("paramCode") String paramCode){
////        User user = userService.login(userName,password);
//    }
}
