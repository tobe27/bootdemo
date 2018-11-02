package com.example.boot.activiti.config;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * 创建activiti数据库
 * @author Created by L.C.Y on 2018-11-2
 */
@Configurable
public class ActivitiConfig {
    // 配置数据库
    private ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:mysql://192.168.1.137:3306/activiti?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false")
            .setJdbcUsername("root")
            .setJdbcPassword("123456")
            .setJdbcDriver("com.mysql.cj.jdbc.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
        ProcessEngine processEngine = configuration.buildProcessEngine();

}
