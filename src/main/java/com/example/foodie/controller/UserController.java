package com.example.foodie.controller;

import com.example.foodie.bean.User;
import com.example.foodie.dao.UserMapper;
import com.example.foodie.service.UserService;
import com.example.foodie.util.ControllerResult;
import com.example.foodie.util.SessionKeyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @Autowired()
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    private static boolean like(User user1,User user2){
        if(!user1.getUserName().equals(user2.getUserName())){
            return true;
        }
        else if(!user1.getBirthday().equals(user2.getBirthday())){
            return true;
        }
        else if(!user1.getUserCity().equals(user2.getUserCity())){
            return true;
        }
        else if(!user1.getProfilePicture().equals(user2.getProfilePicture())){
            return true;
        }
        else if(!user1.getUserProfile().equals(user2.getUserProfile())){
            return true;
        }
        return false;
    }

    /**
     * 测试
     * @return
     */
    @RequestMapping("/user")
    public String userTest(){
        User user = userMapper.selectByPrimaryKey("12");
        return "" + user.toString();
    }


    /**
     * 登录
     * 一、验证是否登陆，二、验证验证码，三、验证用户名密码
     * @param request
     * @param userName
     * @param password
     * @param paramCode
     */
    @PostMapping(value = "login.do")
    public ControllerResult login(HttpServletRequest request,
                                  HttpServletResponse response,
                                  @RequestParam("userName")String userName,
                                  @RequestParam("password") String password,
                                  @RequestParam("paramCode") String paramCode){
        HttpSession session = request.getSession();

        /*
        使用拦截器拦截
         */
//        验证是否登陆
        if(session.getAttribute(SessionKeyValue.USER_KEY)!=null){
            return ControllerResult.createFail("登陆失败：你已登陆");
        }

//        验证验证码
        String sessionCode = session.getAttribute("code").toString();
        if (!sessionCode.equals(paramCode)){
            return ControllerResult.createFail("登陆失败：验证码输入错误");
        }

//        验证用户名密码
        User user = userService.login(userName,password);
        if(user != null){

//            将用户信息放入session中
            session.setAttribute(SessionKeyValue.USER_KEY,user);
            session.setAttribute(SessionKeyValue.USER_ID,user.getUserId());

            return ControllerResult.createSuccess("登陆成功",user);
        }else{
            return ControllerResult.createFail("登录失败：用户名或密码错误");
        }
    }

    /**
     * 注册
     * 一、查询是否存在该用户名，二、将数据发送到service端处理
     * @param user
     * @return
     */
    @PostMapping(value = "/register.do")
    public ControllerResult register(@RequestBody User user){
//        查询是否存在该用户名
        User userResult = userMapper.selectByUserName(user.getUserName());
        if(userResult ==null){
            userService.register(user);
            return ControllerResult.createSuccess("注册成功");
        }
        return ControllerResult.createFail("注册失败：已存在该用户");
    }

    /**
     * 根据id查询用户信息
     * @param request
     * @return
     */
    @GetMapping(value = "/selectUser.do")
    public ControllerResult selectUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = userService.selectById((String) session.getAttribute(SessionKeyValue.USER_ID));

        return ControllerResult.createSuccess("查询成功",user);
    }

    /**
     * 修改用户信息
     * 修
     * @param request
     * @param user
     * @return
     */
    @PostMapping(value = "/updateUser.do")
    public ControllerResult updateUser(HttpServletRequest request,
                                       @RequestBody User user){
        HttpSession session = request.getSession();

//      对比数据是否相同
        User oldUser = (User) session.getAttribute(SessionKeyValue.USER_KEY);
        if(!like(user,oldUser)){
            return ControllerResult.createFail("未修改数据");
        }

//        修改
        userService.updateUser(user);

//        重新加载用户数据
        User userResult = userService.selectById(user.getUserId());
        session.setAttribute(SessionKeyValue.USER_KEY,userResult);
        session.setAttribute(SessionKeyValue.USER_ID,userResult.getUserId());

        return ControllerResult.createSuccess("修改成功",userResult);
    }

    /**
     * 修改密码
     * 一、查询密码是否正确，二、修改密码，三、退出登陆（清空缓存）
     * @param request
     * @param response
     * @param password
     * @return
     */
    @PostMapping(value = "/updatePassword.do")
    public ControllerResult updatePassword(HttpServletRequest request,
                                           HttpServletResponse response,
                                           @RequestParam("password")String password,
                                           @RequestParam("passwordNow")String passwordNow){
        HttpSession session = request.getSession();

//        查询原始密码是否正确
        boolean i = userService.selectPassword((String) session.getAttribute(SessionKeyValue.USER_ID),password);
        if(!i){
            return ControllerResult.createFail("密码错误");
        }

//        修改密码
        userService.updatePassword((String) session.getAttribute(SessionKeyValue.USER_ID),passwordNow);

//        清空缓存
        session.removeAttribute(SessionKeyValue.USER_ID);
        session.removeAttribute(SessionKeyValue.USER_KEY);

        return ControllerResult.createSuccess("修改密码成功");
    }

    /**
     * 退出登陆（清空缓存）
     * @param request
     * @param response
     * @return
     */
    @GetMapping(value = "/logout.do")
    public ControllerResult logout(HttpServletRequest request,
                                   HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute(SessionKeyValue.USER_KEY);
        session.removeAttribute(SessionKeyValue.USER_ID);
        return ControllerResult.createSuccess("退出成功");
    }

}
