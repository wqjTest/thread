<h1 style="text-align: center">多线程练习Demo</h1>
<div style="text-align: center">

[![AUR](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg)](https://github.com/elunez/eladmin/blob/master/LICENSE)
[![star](https://gitee.com/elunez/eladmin/badge/star.svg?theme=white)](https://gitee.com/elunez/eladmin)
[![GitHub stars](https://img.shields.io/github/stars/elunez/eladmin.svg?style=social&label=Stars)](https://github.com/elunez/eladmin)
[![GitHub forks](https://img.shields.io/github/forks/elunez/eladmin.svg?style=social&label=Fork)](https://github.com/elunez/eladmin)

</div>

#### 项目简介
一个基于 Spring Boot 2.1.0 、 Spring Boot Jpa、 JWT、Spring Security、Redis、Vue的前后端分离的后台管理系统

#### 项目源码

|     |   后端源码  |   视频地址  |
|---  |--- | --- |
|  github   |  https://github.com/wqjTest/thread   |   https://www.bilibili.com/video/BV1m4411u7xK?from=search&seid=5024250916349495197  |


#### 主要特性
- 使用最新技术栈，社区资源丰富。
- 项目按功能模块化，提升开发，测试效率。
- 高效率开发，使用代码生成器可以一键生成前后端代码
- 支持数据字典，可方便的对一些状态进行管理
- 支持接口限流，避免恶意请求导致服务层压力过大
- 支持接口级别的功能权限与数据权限，可自定义操作
- 自定义权限注解与匿名接口注解，可快速对某一接口拦截与放行
- 对一些常用的前端组件封装：表格数据请求、数据字典等
- 前后端统一异常拦截处理，统一输出异常，避免繁琐的判断
####  系统功能
- 用户管理：提供用户的相关配置，新增用户后，默认密码为123456
- 角色管理：对权限与菜单进行分配，可根据部门设置角色的数据权限
- 菜单管理：已实现菜单动态路由，后端可配置化，支持多级菜单
- 部门管理：可配置系统组织架构，树形表格展示
- 岗位管理：配置各个部门的职位
- 字典管理：可维护常用一些固定的数据，如：状态，性别等
- 操作日志：记录用户操作的日志
- 异常日志：记录异常日志，方便开发人员定位错误
- SQL监控：采用druid 监控数据库访问性能，默认用户名admin，密码123456
- 定时任务：整合Quartz做定时任务，加入任务日志，任务运行情况一目了然
- 代码生成：高灵活度一键生成前后端代码，减少百分之80左右的工作任务
- 邮件工具：配合富文本，发送html格式的邮件
- 免费图床：使用sm.ms图床，用作公共图片上传使用，该图床不怎么稳定，不太建议使用
- 七牛云存储：可同步七牛云存储的数据到系统，无需登录七牛云直接操作云数据
- 支付宝支付：整合了支付宝支付并且提供了测试账号，可自行测试

#### 项目结构
项目采用按功能分模块开发方式，将通用的配置放在公共模块，```system```模块为系统核心模块也是项目入口模块，```logging``` 模块为系统的日志模块，```tools``` 为第三方工具模块，包含了图床、邮件、七牛云、支付宝，```generator``` 为系统的代码生成模块

- thread_create_demo 创建线程的四种方式
- thread_lock_demo 死锁
- thread_safe_demo 线程安全

    

#### 项目捐赠
项目的发展离不开你的支持，请作者喝杯咖啡吧☕  [Donate](https://docs.auauz.net/#/jz)
#### 反馈交流
- QQ交流群：891137268
