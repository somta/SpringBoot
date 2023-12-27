package net.somta.springboot.groovy.controller;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import net.somta.springboot.groovy.service.VariableManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GroovyController {

    @GetMapping("/groovy/execute")
    public String executeScript(){

        executeStringScript();
        executeStringScriptByJavaVariable();
        executeStringScriptByJavaMethod();
        return "success";
    }

    public static void main(String[] args) {
        GroovyController controller = new GroovyController();
        //controller.executeStringScript();
        //controller.executeStringScriptByJavaVariable();
        controller.executeStringScriptByJavaMethod();
    }

    /**
     * 执行 Groovy 代码字符串,你可以根据需要在 Groovy 代码字符串中编写更复杂的逻辑，包括定义类、调用方法等
     */
    private void executeStringScript(){
        GroovyShell shell = new GroovyShell();
        Object result = shell.evaluate("println 'Hello, Groovy!'");

        System.out.println("Script result: " + result);
    }

    /**
     * 通过Binding将java变量注入到Groovy上下文中
     */
    private void executeStringScriptByJavaVariable(){
        // 创建 Binding 对象
        Binding binding = new Binding();

        // 创建一个 Map 对象
        Map<String, Object> data = new HashMap<>();
        data.put("name", "John");
        data.put("age", 30);

        // 将 Map 对象设置到 Binding 对象中
        binding.setVariable("data", data);

        // 创建 GroovyShell，并传递 Binding 对象
        GroovyShell shell = new GroovyShell(binding);

        // 执行 Groovy 脚本
        Object result = shell.evaluate("println 'Name: ' + data.name + ', Age: ' + data.age");

        // 处理结果
        System.out.println("Script result: " + result);
    }

    private void executeStringScriptByJavaMethod(){
        VariableManager variableManager = new VariableManager();
        // 创建 Binding 对象
        Binding binding = new Binding();

        // 将 variableManager 对象设置到 Binding 对象中
        binding.setVariable("env", variableManager);
        // 创建 GroovyShell，并传递 Binding 对象
        GroovyShell shell = new GroovyShell(binding);

        shell.evaluate("env.setValue('name','6666')");
        // 执行 Groovy 脚本
        Object result = shell.evaluate("println 'Name: ' + env.getValue('name')");

        // 处理结果
        System.out.println("Script result: " + result);
    }
}
