package com.example.boot;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.util.List;

/**
 * 测试部署activiti
 * @author Created by L.C.Y on 2018-11-2
 */
public class ActivitiTest {

    // 配置activiti数据库
    private ProcessEngineConfiguration configuration = new StandaloneProcessEngineConfiguration()
            .setJdbcUrl("jdbc:mysql://192.168.1.137:3306/activiti?characterEncoding=utf-8&serverTimezone=GMT%2B8&useSSL=false")
            .setJdbcUsername("root")
            .setJdbcPassword("123456")
            .setJdbcDriver("com.mysql.cj.jdbc.Driver")
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    private ProcessEngine processEngine = configuration.buildProcessEngine();

    @Test
    public void createTable() { // 创建数据库表格
        ProcessEngine processEngine = configuration.buildProcessEngine();
    }

    @Test
    public void createTask() { // 向数据库导入流程引擎，存入表 act_get_bytearray
        Deployment deployment = processEngine.getRepositoryService()
                .createDeployment()
                .addClasspathResource("activiti/activiti.bpmn")
                .addClasspathResource("activiti/activiti.png")
                .deploy();

        System.out.println("activiti部署id:"+deployment.getId());

    }

    @Test
    public void startInstance() { // 启动流程实例
        processEngine.getRuntimeService()
                .startProcessInstanceById("myProcess_1:1:4"); // act_re_procdef

    }

    @Test
    public void leaveRequest() { // 学生请假申请，完成任务

        processEngine.getTaskService().complete("12505"); // act_ru_task


    }

    @Test
    public void queryTask(){   // 班主任zhao查看学生申请

        List<Task> tasks = processEngine.getTaskService()
                .createTaskQuery()
                .taskAssignee("zhao")
                .list();
        for (Task task : tasks) {
            System.out.println(task.getName());
        }
    }

    @Test
    public void headTeacherFinishTask() { // 班主任审批，完成任务

        processEngine.getTaskService()
                .complete("15002"); // act_ru_task
    }


    @Test
    public void teachingAffairFinishTask(){ // 教务处审批，完成任务

        processEngine.getTaskService()
                .complete("17502");  // act_ru_task
    }







}
