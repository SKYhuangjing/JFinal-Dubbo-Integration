# JFinal Dubbo Integration
jfinal_web_demo 是 Dynamic Web Project 的架子, 参考于 [JFinal 文档](http://www.jfinal.com/doc/1-1)
> 如果想使用 maven 结构, 可参考 [Maven 开发](http://www.jfinal.com/doc/1-2)


此例子提供了消费者的集成, 提供者可使用 [dubbo-spring-boot-samples-provider](https://github.com/SKYhuangjing/incubator-dubbo-spring-boot-project/tree/master/dubbo-spring-boot-samples/dubbo-spring-boot-sample-provider), 因提供者使用的是 Dubbo 本身的注册中心, 所以例子中默认使用的是和提供者一样的, 
>在实际应用过程中, 请使用 zookeeper 注册中心, 本例子已经集成了 zookeeper 的依赖, 且提供了集成代码, 只是暂时未开发 zookeeper 版提供者, 尽请期待


## 本地测试

### 前提条件
  请自行下载 Tomcat 至本地, 并配置 Tomcat 至 Eclipse Server, 供后续使用 (本集成项目不能使用 JFinal 的 main run 启动, 必须使用 Tomcat Server)

### 下载此项目至本地
``` bash
git clone https://github.com/SKYhuangjing/JFinal-Dubbo-Integration.git
```

### 导入Eclipse
![导入Eclipse Project](/doc/img/import1.jpg)

![选择下载的项目](/doc/img/import2.jpg)

![检查 Web Deployment](/doc/img/import3.jpg)

![添加 Build Path](/doc/img/import4.jpg)

![添加 Tomcat Server Runtime](/doc/img/import5.jpg)

### 启动
右键项目, run on server 启动项目

访问 http://localhost:8080/jfinal_web_demo/hello 查看项目是否启动正常

如果提供者已经在本地运行, 则访问 http://localhost:8080/jfinal_web_demo/hello/dubbo 查看服务调用是否正常




