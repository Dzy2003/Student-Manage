学生成绩管理系统
===========================

本项目基于b站：[学生成绩管理系统-Java swing项目实战_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1qi4y137Ct?spm_id_from=333.337.search-card.all.click&vd_source=89bf5082dff0a910a2055899629226d4)

通过观看该视频，一步一步将该项目界面搭建出；但在连接数据库以及对数据库操作方面并未参照视频使用传统的jdbc来操作数据库，而是使用了mybatis持久层框架来对数据库操作，以及自己的理解，来实现主界面中增加，删除，修改，查询。

##### 环境依赖

mybatis 3.5.5

mysql-connector-java   8.0.11

##### 部署步骤

1. 在本地mysql中建manager表，字段为： id，username，password；以及student表，字段为：id，name，home_town,cn_score,en_score,math_score.
2. 更改resources目录下的mybatis-config.xml配置信息为自己mysql的配置信息。
3. Main类即是该项目入口。

###### 目录结构描述

1. view目录即本项目的窗口目录，定义了本项目所有用到的窗口，其下面的ext目录下则是定义了主界面窗口Mainview的数据获取和渲染方式以及表格字段名。
2. Hander目录下定义了view窗口中按钮的事件。
3. mapper目录下是mybatis的映射实现sql语句，对数据库进行操作。
4. service目录下是基于mapper目录操作数据来实现handle事件中的增加，删除，修改，查询等功能。
5. pojo定义的是项目所需的普通Java对象，在service目录中进行封装。
6. Utill为工具目录，用于封装一些重复的方法。

