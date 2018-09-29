package com.sky.jfinal.demo.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;
import com.sky.jfinal.demo.controller.HelloController;

public class DemoConfig extends JFinalConfig
{

    @Override
    public void configConstant(Constants constants)
    {
    }

    @Override
    public void configEngine(Engine arg0)
    {
    }

    @Override
    public void configHandler(Handlers arg0)
    {
    }

    @Override
    public void configInterceptor(Interceptors arg0)
    {
    }

    @Override
    public void configPlugin(Plugins arg0)
    {
    }

    @Override
    public void configRoute(Routes routes)
    {
        routes.add("/hello", HelloController.class);
    }

}
