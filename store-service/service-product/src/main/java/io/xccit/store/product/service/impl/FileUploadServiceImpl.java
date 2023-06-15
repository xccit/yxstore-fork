package io.xccit.store.product.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import io.xccit.store.product.service.FileUploadService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author CH_ywx
 * @date 2023-06-15
 * @description 文件上传Service
 */
@Service
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${aliyun.endpoint}")
    private String endpoint;
    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;
    @Value("${aliyun.bucketName}")
    private String bucketName;
    /**
     * 图片上传
     * @param file 文件
     * @return 文件url
     */
    @Override
    public String upload(MultipartFile file) {

        //原始文件名
        String objectName= file.getOriginalFilename();
        //处理文件名 保证唯一性
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        objectName = uuid + objectName;
        //以当前年月日对图片进行分组-->使用joda-time包下的DateTime
        String filePath = new DateTime().toString("yyyy/MM/dd");
        // 2023/06/15/xxx.jpg(OSS会自动新建文件夹)
        objectName = filePath + "/" + objectName;
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = file.getInputStream();
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            //设置该属性可返回response,不设置或为false则返回的response为null
            putObjectRequest.setProcess("true");
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            //返回图片路径
            return result.getResponse().getUri();
        } catch (Exception oe) {
            oe.printStackTrace();
            System.err.println(oe.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        //失败则返回null
        return null;
    }
}
