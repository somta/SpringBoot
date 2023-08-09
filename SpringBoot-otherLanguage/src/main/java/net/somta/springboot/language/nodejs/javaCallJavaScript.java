package net.somta.springboot.language.nodejs;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
 
public class javaCallJavaScript {
   public static void main(String args[]){

      helloWorld();

   }

   /**
    * 第一个基本例子 helloWorld
    */
   private static void helloWorld(){
      ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
      ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

      String name = "hello world";
      try {
         nashorn.eval("print('" + name + "')");
      }catch(ScriptException e){
         System.out.println("执行脚本错误: "+ e.getMessage());
      }
   }

   /**
    * 做一个简单的计算
    */
   private static void calculate(){
      ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
      ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
      try {
         Integer result = (Integer) nashorn.eval("10 + 2");
         System.out.println(result.toString());
      }catch(ScriptException e){
         System.out.println("执行脚本错误: "+ e.getMessage());
      }


   }

}