package com.example.foodie.controller;

import com.example.foodie.util.ImageUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
public class CodeController {

    /**
     * 生成图片验证码
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/code")
    public String getCode(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("image/jpeg");
        //禁止图像缓存
        response.setHeader("Pragma","no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        HttpSession session = request.getSession();
        ImageUtil imageUtil = new ImageUtil(80, 30, 4,30);
        session.setAttribute("code", imageUtil.getCode());
        imageUtil.write(response.getOutputStream());
        return null;
    }
}
