package com.example.foodie.service.impl;

import com.example.foodie.bean.Picture;
import com.example.foodie.dao.PictureMapper;
import com.example.foodie.service.PictureService;
import com.example.foodie.util.ControllerResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.Session;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureMapper pictureMapper;

    @Override
    public ControllerResult insertPicture(MultipartFile file,String userId) {
        String prefix=""; //指定文件类型
        String fileStr="";//指定文件名
        //保存上传
        OutputStream out = null;
        InputStream fileInput=null;
        try{
            if(file!=null){
                String originalName = file.getOriginalFilename();
                prefix=originalName.substring(originalName.lastIndexOf(".")+1);
                fileStr=originalName.substring(0,originalName.lastIndexOf(".")+1);
                String uuid = UUID.randomUUID()+"";
                String filepath = "D:\\apache-tomcat-9.0.8\\webapps\\imgs\\"+uuid+"." + prefix;

                File files=new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if(!files.getParentFile().exists()){
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Picture picture = new Picture();
                picture.setImgUser(userId);
                picture.setImgPath(uuid+"."+prefix);
                picture.setImgName(fileStr);
                System.out.println(""+picture.toString());
                pictureMapper.insert(picture);
                return ControllerResult.createSuccess("上传成功",picture);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        return ControllerResult.createFail("上传失败");
    }
}
