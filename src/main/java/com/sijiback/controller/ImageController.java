package com.sijiback.controller;

import com.sijiback.dto.AvatarResponse;
import com.sijiback.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@CrossOrigin
@RestController
@RequestMapping("/api/image")
public class ImageController {
    @Resource
    private UserService userService;
    @Value("${path.image}")
    private String imageDir;
    @PostMapping()
    public AvatarResponse UploadImg(@RequestParam("file") MultipartFile file, @RequestParam("user_id") int id, @RequestParam("token") String token) throws IOException {
        // 名字容易重复,进行改名
        String filename = new Date().getTime() + file.getOriginalFilename();
        // 后端存储地址
        String savePath=imageDir+filename;
        // 保存文件
        file.transferTo(new File(savePath));

        // 更新用户头像
        userService.updateAvatar(id,token,filename);

        return new AvatarResponse(0,"上传成功",filename);
    }
    @DeleteMapping("/{img}")
    public boolean DeleteImg(@PathVariable String img){
        // 创建文件对象
        File file = new File(imageDir+img);

        if (file.isFile() && file.exists()) { // 路径为文件且不为空则进行删除
            if (file.delete()) {
                return true;
            }
        }
        return false;
    }
}