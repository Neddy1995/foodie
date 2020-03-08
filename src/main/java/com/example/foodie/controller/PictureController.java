package com.example.foodie.controller;

import com.example.foodie.service.PictureService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class PictureController {

    @Autowired
    private PictureService pictureService;

    /**
     * 上传图片
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/upload/")
    public ControllerResult upload(MultipartFile file, HttpServletRequest request){
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        return pictureService.insertPicture(file,userId);

    }
}
