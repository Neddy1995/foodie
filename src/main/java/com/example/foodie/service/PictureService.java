package com.example.foodie.service;

import com.example.foodie.bean.Picture;
import com.example.foodie.util.ControllerResult;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    ControllerResult insertPicture(MultipartFile file, String userId);

    Picture selectPicture(String imgId);
}
