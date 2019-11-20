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
        ControllerResult controllerResult = new ControllerResult();
        HttpSession session = request.getSession();

        /*
        使用拦截器拦截
         */
//        验证是否登陆
//        if(session.getAttribute(SessionKeyValue.USER_KEY)!=null){
//            controllerResult.setResultCode(ControllerResult.RESULT_CODE_ERROR);
//            controllerResult.setMessage("登陆失败：你已登陆");
//        }

//        验证验证码
//        String sessionCode = session.getAttribute("code").toString();
//        if (!sessionCode.equals(paramCode)){
//            controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
//            controllerResult.setMessage("登陆失败：验证码输入错误");
//            return controllerResult;
//        }

//        验证用户名密码
        User user = userService.login(userName,password);
        if(user != null){

            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("登陆成功");
            controllerResult.setData(user);

//            将用户信息放入session中
            session.setAttribute(SessionKeyValue.USER_KEY,user);
            session.setAttribute(SessionKeyValue.USER_ID,user.getUserId());

            return controllerResult;
        }else{
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
            controllerResult.setMessage("登录失败：用户名或密码错误");
            return controllerResult;
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
        ControllerResult controllerResult = new ControllerResult();
//        查询是否存在该用户名
        User userResult = userMapper.selectByUserName(user.getUserName());
        if(userResult !=null){
            userService.register(user);
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
            controllerResult.setMessage("注册成功");
            return controllerResult;
        }
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
        controllerResult.setMessage("注册失败：已存在该用户");
        return controllerResult;
    }

    /**
     * 根据id查询用户信息
     * @param request
     * @return
     */
    @GetMapping(value = "/selectUser.do")
    public ControllerResult selectUser(HttpServletRequest request){
        ControllerResult controllerResult = new ControllerResult();
        HttpSession session = request.getSession();
        User user = userService.selectById((String) session.getAttribute(SessionKeyValue.USER_ID));

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("查询成功");
        controllerResult.setData(user);
        return controllerResult;
    }

    /**
     * 修改用户信息
     * 修
     * @param request
     * @param user
     * @return
     */
    @PostMapping(value = "updateUser.do")
    public ControllerResult updateUser(HttpServletRequest request,
                                       @RequestBody User user){
        ControllerResult controllerResult = new ControllerResult();
        HttpSession session = request.getSession();

        userService.updateUser(user);
//        重新加载用户数据
        User userResult = userService.selectById(user.getUserId());
        session.setAttribute(SessionKeyValue.USER_KEY,userResult);
        session.setAttribute(SessionKeyValue.USER_ID,userResult.getUserId());

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("修改成功");
        controllerResult.setData(userResult);
        return controllerResult;
    }

    /**
     * 修改密码
     * 一、查询密码是否正确，二、修改密码，三、退出登陆（清空缓存）
     * @param request
     * @param response
     * @param password
     * @return
     */
    @PostMapping
    public ControllerResult updatePassword(HttpServletRequest request,
                                           HttpServletResponse response,
                                           @RequestParam("password")String password,
                                           @RequestParam("passwordNow")String passwordNow){
        ControllerResult controllerResult = new ControllerResult();
        HttpSession session = request.getSession();

//        查询原始密码是否正确
        boolean i = userService.selectPassword((String) session.getAttribute(SessionKeyValue.USER_ID),password);
        if(!i){
            controllerResult.setResultCode(ControllerResult.RESULT_CODE_FAIL);
            controllerResult.setMessage("密码错误");
            return controllerResult;
        }

//        修改密码
        userService.updatePassword((String) session.getAttribute(SessionKeyValue.USER_ID),passwordNow);

//        清空缓存
        session.removeAttribute(SessionKeyValue.USER_ID);
        session.removeAttribute(SessionKeyValue.USER_KEY);

        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("修改密码成功");
        return controllerResult;
    }

    /**
     * 退出登陆（清空缓存）
     * @param request
     * @param response
     * @return
     */
    @GetMapping
    public ControllerResult logout(HttpServletRequest request,
                                   HttpServletResponse response){
        ControllerResult controllerResult = new ControllerResult();
        HttpSession session = request.getSession();
        session.removeAttribute(SessionKeyValue.USER_KEY);
        session.removeAttribute(SessionKeyValue.USER_ID);
        controllerResult.setResultCode(ControllerResult.RESULT_CODE_SUCCESS);
        controllerResult.setMessage("退出成功");
        return controllerResult;
    }

}
