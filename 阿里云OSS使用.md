# 对象存储服务OSS使用

## 注册阿里云账号

## 实名认证

## 购买OSS

## 操作OSS

### 1.进入控制台

### 2.找到OSS

### 3.创建Bucket

![image-20230615160401891](%E9%98%BF%E9%87%8C%E4%BA%91OSS%E4%BD%BF%E7%94%A8.assets/image-20230615160401891.png)

### 4.进入AccessKey管理

![image-20230615160526597](%E9%98%BF%E9%87%8C%E4%BA%91OSS%E4%BD%BF%E7%94%A8.assets/image-20230615160526597.png)

![image-20230615160910113](%E9%98%BF%E9%87%8C%E4%BA%91OSS%E4%BD%BF%E7%94%A8.assets/image-20230615160910113.png)

### 5.创建AccessKey

> 使用手机号码认证或者人脸验证后即可创建

![image-20230615161039727](%E9%98%BF%E9%87%8C%E4%BA%91OSS%E4%BD%BF%E7%94%A8.assets/image-20230615161039727.png)

## 官网文档地址

[对象存储 OSS (aliyun.com)](https://help.aliyun.com/product/31815.html?spm=a2c4g.196063.0.0.510a276fe6Tafa)

https://help.aliyun.com/product/31815.html?spm=a2c4g.196063.0.0.510a276fe6Tafa

## SpringBoot整合OSS

### 1.引入依赖

```xml
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>3.10.2</version>
</dependency>
<dependency>
    <groupId>joda-time</groupId>
    <artifactId>joda-time</artifactId>
    <version>2.9.9</version>
</dependency>

```

### 2.yml配置

```yml
aliyun:
  # 地域
  endpoint: your endpoint
  # AccessKey
  accessKeyId: your keyid
  accessKeySecret: your keySecret
  # bucket名称
  bucketName: your bucketName
```

### 3.Controller和Service

```java
/**
 * @author CH_ywx
 * @date 2023-06-15
 * @description 文件上传接口
 */

@Api(tags = "文件上传接口")
@RestController
@RequestMapping("/admin/product")
@CrossOrigin
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
```

```java
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
```



### 4.最终效果

#### 上传成功

![image-20230615174506392](%E9%98%BF%E9%87%8C%E4%BA%91OSS%E4%BD%BF%E7%94%A8.assets/image-20230615174506392.png)

#### 接口响应数据

![image-20230615174642031](%E9%98%BF%E9%87%8C%E4%BA%91OSS%E4%BD%BF%E7%94%A8.assets/image-20230615174642031.png)