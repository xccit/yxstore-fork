# Docker笔记

​													----emial:darkhorse_1209@outlook.com

## 1.系统准备

### 1.1配置网络

### 1.2yum包更新到最新

> yum update

### 1.3安装依赖的软件包

> sudo yum install -y yum-utils device-mapper-persistent-data lvm2

### 1.4设置docker-yum源

> 特别注意复制粘贴后.repo可能会丢

```shell
sudo yum-config-manager --add-repo https://download.docker.com/linux/centos/dockerce.
repo
```

> 会出现Could not fetch/save url https://download.docker.com/linux/centos/dockerce.repo                                                                                                           to file /etc/yum.repos.d/dockerce.repo: [Errno 14] HTTPS Error 404 - Not Found

#### 推荐方式:

```shell
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo

sudo yum makecache fast
```

## 2.安装Docker

###  2.1安装Docker

```shell
yum install -y docker-ce
```

### 2.2查看docker版本(验证是否安装)

```shell
docker version
```

### 2.3查看docker是否启动

```shell
ps -ef | grep docker
```

### 2.4启动docker并加入开机启动

```shell
systemctl start docker
systemctl enable docker
```

## 3.卸载Docker

### 3.1查看Docker状态

```shell
systemctl status docker
```

<img src="E:\Markdown\Docker笔记.assets\image-20230414114858954.png" alt="image-20230414114858954" style="zoom:50%;" />

### 3.2运行状态需要停止docker

```shell
systemctl stop docker
```

### 3.3查看yum安装的docker包

```shell
yum list installed |grep docker
```

<img src="E:\Markdown\Docker笔记.assets\image-20230414115322102.png" alt="image-20230414115322102" style="zoom:50%;" />

### 3.4查看docker相关的rpm源文件

```shell
rpm -qa | grep docker
```

### 3.5删除yum安装的docker文件包

```shell
yum -y remove 文件包
```

> 文件包: yum list installed | grep docker输出的所有包
>
> 删完之后可以再看一下docker的rpm源文件

### 3.6删除docker镜像文件

> 默认在/var/lib/docker

```shell
rm -rf /var/lib/docker
```

## 4.删除服务并重新运行

### 3.1 删除之前部署的服务

```shell
docker rm st-test-ui
```

### 3.2 重新运行

```shell
docker run -itd --name st-test-ui --publish 9595:80 -v /home/nodejs/st-testnginx/
default.conf:/etc/nginx/conf.d/default.conf -v /home/nodejs/st-testnginx/:/
usr/share/nginx/html/ nginx:luxi
```

### 3.3 查看default.conf

>  在st-test-nginx目录下的home/nodejs中就能看到default.conf文件了

## 5.设置镜像加速器

> 阿里云控制台--->搜索镜像加速器
>
> 或者点链接:[容器镜像服务 (aliyun.com)](https://cr.console.aliyun.com/cn-hangzhou/instances/mirrors)

<img src="E:\Markdown\Docker笔记.assets\image-20230414120336687.png" alt="image-20230414120336687" style="zoom:33%;" />

> 依次执行以上4句命令

#### CentOS

```shell
sudo mkdir -p /etc/docker

sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["https://gseqhafl.mirror.aliyuncs.com"]
}
EOF

sudo systemctl daemon-reload

sudo systemctl restart docker
```



## 6.Docker常用命令

### 1.查看安装的docker镜像

```shell
docker images
```

### 2.启动,停止,重启,开机自启

```shell
systemctl start docker
systemctl stop docker
systemctl restart docker
systemctl enable docker
```

### 3.删除安装的docker镜像

```shell
docker rmi 镜像名:版本号
例如: docker rmi redis:6.0
```

### 4.安装镜像

```shell
docker search 镜像名
例如:docker search redis
```

![image-20230414130643663](E:\Markdown\Docker笔记.assets\image-20230414130643663.png)

> 下载镜像

```shell
docker pull 服务名 #默认下载最高版本
docker pull 服务名:版本号 #指定下载版本
```

> 如果不知道版本,进入docker官网查询:[Docker Hub Container Image Library | App Containerization](https://hub.docker.com/)

网站左上角搜索服务名,选择自己需要下载的包,点进去,查看版本列表

<img src="E:\Markdown\Docker笔记.assets\image-20230414200231807.png" alt="image-20230414200231807" style="zoom:33%;" />

支持的所有版本都在此页面.

<img src="E:\Markdown\Docker笔记.assets\image-20230414200554571.png" alt="image-20230414200554571" style="zoom:50%;" />

### 5.启动镜像

```shell
docker run -id --name=实例名称 -p 端口:端口 镜像名:版本号 /bin/bash
例如:docker run -id --name=xccit_redis -p 6379:6379 redis:6.0 /bin/bash
```

> 参数:
>
> ​	-i :交互式操作,保持容器运行。-it创建后自动进入容器，退出终端后自动关闭容器。
>
> ​	-t:终端。
>
> ​	-d:后台运行，退出终端后不会关闭容器。
>
> ​	--name:给实例取个名字。
>
> ​	xccit_redis:实例名。
>
> ​	-p:端口。
>
> ​	-it一般用来运行交互式容器，即一次交互后退出即可。-id一般用来运行后台守护容器，例如MySQL,Tomcat。
>
> ​	/bin/bash:交互式Shell。

举个例子:

```shell
docker run -it --name=xccit_redis -p 6379:6379 redis:6.0 /bin/bash
```

运行以上命令，redis不会在后台停留，并且运行完之后会直接进入到redis操作shell中。

```shell
docker run -id --name=xccit_redis -p 6379:6379 redis:6.0 /bin/bash
```

运行以上命令，redis会在后台停留，并且运行完之后不会直接进入到redis操作shell中,如果要进入到redis操作shell中，需要使用到docker exec...

```shell
docker run -itd --name=xccit_redis -p 6379:6379 redis:6.0 /bin/bash
```

运行以上命令，redis会在后台停留，并且运行完之后会直接进入到redis操作shell中。

### 6.查看所有镜像实例的状态

```shell
docker ps -a #实例的所有信息
docker ps -aq #实例的ID
```

### 7.Linux本地连接实例

```shell
docker exec -it 实例名 /bin/bash
例如:docker exec -it xccit_redis /bin/bash
```

> 连接redis:
>
> ​	redis-cli
>
> 退出redis实例
>
> exit
>
> 参数解析:
>
> ​	exec:执行
>
> ​	-it:带命令行的方式及可以后台
>
> ​	xccit_redis:实例名称
>
> ​	/bin/bash:以命令行的方式打开

> 注意:此实例是一个独立的Linux子系统,通过
> 	cd /
>
> ​	ls
>
> 两条命令,可以看到存在的目录跟一个全新的Linux基本一致,并且在宿主机中新建目录,在此实例中是看不到该宿主机中存在的目录的,即在此宿主机中运行10个redis实例,相当于在此宿主机中安装了10个Linux子系统

### 8.停止与启动实例

> 停止实例

```shell
docker stop 实例名称 #方式一
docker stop 实例ID #方式二(适合有多个相同实例)
docker stop `实例ID1,实例ID2...` #同时停止多个实例,ID可以简写
docker stop `docker ps -aq` #停止所有实例
```

> 开启实例

```shell
docker start 实例名称 #方式一
docker start 实例ID #方式二(适合多个相同实例)
docker start `实例ID1,实例ID2...` #同时开启多个实例,ID可以简写
docker start `docker ps -aq` #开启所有实例
```

> ID简写:
>
> ​	注意:如果嫌实例ID太长,可以只敲前面两三位,但必须保证前面两三位中没有其他实例ID冲突,不然会启动/停	    	止失败

### 9.删除docker实例

```shell
docker rm 实例ID #删除一个
docker rm `docker ps -a` #删除所有
```

> 注意:删除时,实例需在停止运行状态

> 如需删除所有运行中的实例:

```shell
docker stop `docker ps -aq` #停止实例
docker rm `docker ps -aq` #删除实例
docker ps -aq #查看实例是否还存在
```

