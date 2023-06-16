# ElasticSearch使用

## 下载安装

> 注意:使用ES之前,确保系统配置好了JDK环境变量,另外分词器与kibana版本要与es版本保持一致,下面的文档为了方便,elasticsearch简称为es

[Elasticsearch 7.8.0 | Elastic](https://www.elastic.co/cn/downloads/past-releases/elasticsearch-7-8-0)

> 当前下载版本为7.8.0,可以选择其他版本

下载完成后解压到没有中文和空格的路径即可

![image-20230616154352562](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616154352562.png)

## 安装分词器

下载es的ik分词器

[(35条消息) 【免费】elasticsearch7.8.0版本的IK分词器_esik分词器资源-CSDN文库](https://download.csdn.net/download/qq_33556185/13985351)

下载完成后解压至ES安装路径的plugins文件夹内,然后将刚解压的文件夹改名ik

![image-20230616160436082](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616160436082.png)

## 测试

![image-20230616161829927](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616161829927.png)

> 双击es安装路径/bin/下的elasticsearch.bat

![image-20230616161949837](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616161949837.png)

> 浏览器访问localhost:9200

![image-20230616162047544](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616162047544.png)

## 安装Kibana

### 下载

[Kibana 7.8.0 | Elastic](https://www.elastic.co/cn/downloads/past-releases/kibana-7-8-0)

### 解压

解压到没有中文和空格的路径

### 修改配置

> kibana安装路径下的conf文件夹下

![image-20230616164020952](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616164020952.png)

> 修改kibana.yml

#### 配置1

```yaml
server.port: 5601
```

> 访问的端口配置,大概第2行,取消注释

#### 配置2

```yaml
elasticsearch.hosts: ["http://localhost:9200"]
```

> 配置es的访问路径,默认注释,取消即可

#### 配置3

```yaml
i18n.locale: "zh-CN"
```

> 语言配置,默认注释,默认值为en,改为zh-CN,大概第115行

### 启动

![image-20230616164719656](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616164719656.png)

双击bin目录下的**kibana.bat**

> 初次启动,等待时间可能较长,耐心等待即可

![image-20230616164859796](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616164859796.png)

### 测试

> localhost:5601 , 注意:测试前启动es

![image-20230616165029530](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616165029530.png)

![image-20230616165130671](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616165130671.png)

![image-20230616165159354](ElasticSearch%E4%BD%BF%E7%94%A8.assets/image-20230616165159354.png)

>  安装完成