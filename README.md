# 房屋租赁管理系统 介绍

房屋租赁管理系统的初衷是一个简单的房源管理系统，为了帮助房东和租客完成更好的沟通，该系统可以直接发布房源信息，租户可以登录浏览房源信息。



:alembic:声明：这是一个极其不规范的系统，不提供学习使用。

> 但用作毕设忽悠导师是足够的。



## 1、功能介绍：

### 1、管理员

1、发布房源、下架房源

2、处理报障

3、看房申请、处理申请

4、向租客发起交租通知

5、添加行程

6、管理用户

![](https://blog-1253198264.cos.ap-guangzhou.myqcloud.com/image-20210130154616253.png)

### 2、普通用户

1、房源预订

2、申请看房、房间租赁

3、报障

4、交租、退租

![](https://blog-1253198264.cos.ap-guangzhou.myqcloud.com/image-20210130154415807.png)

## 2、技术栈

系统基于SSM框架进行搭建。

**运行环境**

jdk8+tomcat8+mysql+IntelliJ IDEA

**项目技术(必填)**

spring+spring mvc+mybatis+jquery+ajax

## 3、运行

### 1、配置jar

项目非maven项目，需要先把依赖包导入，配置war路径和Tomcat即可。

依赖库会用到`javax.servlet.http.HttpSession`，加入`Tomcat`即可：

![](https://blog-1253198264.cos.ap-guangzhou.myqcloud.com/image-20210130160229425.png)

### 2、导入数据库

`house_sql.sql`文件见根目录，新建数据库导入即可。

修改`db.properties`文件，配置本地的数据库账户密码。

###  3、图片路径需要修改为项目的路径

修改`HoustlistController.java` 的`addhouse()`方法，修改图片的路径即可。
可以用你的本地路径，又或者用项目的路径都可以。



如果不想修改，可以使用 `imgs.zip` 的图片，解压放到 `imgs` 目录即可。数据库已经配置好图片的相对路径了。



---

- blog: [https://learnjava.baimuxym.cn/](https://learnjava.baimuxym.cn/)
