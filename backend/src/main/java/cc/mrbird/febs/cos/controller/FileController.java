package cc.mrbird.febs.cos.controller;

import cc.mrbird.febs.common.utils.FileUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/file")
@AllArgsConstructor
public class FileController {

    /**
     * 文件上传
     *
     * @param file 上传的文件
     * @return 文件名称
     */
    @ResponseBody
    @RequestMapping("/fileUpload")
    public String upload(@RequestParam("avatar") MultipartFile file) {
        // 1定义要上传文件 的存放路径
        String localPath = "G:/线上毕设环境/db";
        // 2获得文件名字
        String fileName = file.getOriginalFilename();
        // 2上传失败提示
        String warning = "";
        String newFileName = FileUtil.upload(file, localPath, fileName);
        if (newFileName != null) {
            //上传成功
            warning = newFileName;
        } else {
            warning = "上传失败";
        }
        System.out.println(warning);
        return warning;
    }

    /**
     * 上传项目文件
     *
     * @param file 项目文件
     * @return 压缩包名称
     */
    @ResponseBody
    @RequestMapping("/fileUploadByZip")
    public String uploadByZip(@RequestParam("zip") MultipartFile file) {
        // 1定义要上传文件 的存放路径
        String localPath = "G:/线上毕设环境/file";
        // 2获得文件名字
        String fileName = file.getOriginalFilename();
        // 2上传失败提示
        String warning = "";
        String newFileName = FileUtil.uploadByZip(file, localPath, fileName);
        if (newFileName != null) {
            //上传成功
            warning = newFileName;

        } else {
            warning = "上传失败";
        }
        return warning;
    }

    /**
     * 上传项目附件文件
     *
     * @param file 附件文件
     * @return 附件名称
     */
    @ResponseBody
    @RequestMapping("/fileUploadByAnnex")
    public String uploadByAnnex(@RequestParam("annex") MultipartFile file) {
        // 1定义要上传文件 的存放路径
        String localPath = "G:/线上毕设环境/annex";
        // 2获得文件名字
        String fileName = file.getOriginalFilename();
        // 2上传失败提示
        String warning = "";
        String newFileName = FileUtil.uploadByAnnex(file, localPath, fileName);
        if (newFileName != null) {
            //上传成功
            warning = newFileName;

        } else {
            warning = "上传失败";
        }
        return warning;
    }

}
