package com.sky.jfinal.demo.controller;

import com.alibaba.boot.dubbo.demo.consumer.DemoService;
import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.jfinal.core.Controller;

public class HelloController extends Controller
{

    private DemoService demoService;

    public void index()
    {
        renderText("Hello JFinal World.");
    }

    public void dubbo()
    {
        if (demoService == null)
        {
            initByDefaultRegistry();
        }
        renderJson(demoService.sayHello("Sky"));
    }

    private synchronized void initByDefaultRegistry()
    {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("oss");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        // registry.setAddress("localhost:12345");
        registry.setProtocol("dubbo");
        registry.setId("dubbo");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setProtocol("dubbo");
        reference.setInjvm(false);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setUrl("localhost:12345");
        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");

        // 和本地bean一样使用xxxService
        demoService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
    }

    private synchronized void initByZookeeper()
    {
        // 当前应用配置
        ApplicationConfig application = new ApplicationConfig();
        application.setName("oss");

        // 连接注册中心配置
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("localhost:2181");
        registry.setProtocol("zookeeper");
        registry.setId("my-registry");

        // 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

        // 引用远程服务
        ReferenceConfig<DemoService> reference = new ReferenceConfig<DemoService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
        reference.setApplication(application);
        reference.setProtocol("dubbo");
        reference.setInjvm(false);
        reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
        reference.setInterface(DemoService.class);
        reference.setVersion("1.0.0");

        // 和本地bean一样使用xxxService
        demoService = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
    }

}
