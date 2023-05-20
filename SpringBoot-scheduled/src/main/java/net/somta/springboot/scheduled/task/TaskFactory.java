package net.somta.springboot.scheduled.task;


import net.somta.springboot.scheduled.core.AbstractTask;

/**
 * 自定义的任务工厂
 *
 * @author husong
 * @date 2023/05/20
 */
public class TaskFactory {

    public static AbstractTask getTask(String taskType){
        AbstractTask task = null;
        if("log".equals(taskType)){
            task = new LogTask();
        }else if("db".equals(taskType)){
            task = new DbTask();
        }
        return task;
    }
}
