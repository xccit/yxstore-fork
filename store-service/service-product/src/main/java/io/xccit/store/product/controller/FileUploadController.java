package io.xccit.store.product.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.xccit.store.common.result.AjaxResult;
import io.xccit.store.product.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author CH_ywx
 * @date 2023-06-15
 * @description 文件上传接口
 */

@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/product")
//@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    /**
     *
     * @param file 上传的文件
     * @return 返回的路径
     */
    @ApiOperation("文件上传")
    @PostMapping("/fileUpload")
    public AjaxResult<String> fileUpload(@ApiParam(value = "文件",required = true) MultipartFile file){
        String url = fileUploadService.upload(file);
        return AjaxResult.ok(url);
    }
}
