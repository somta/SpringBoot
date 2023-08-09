package net.somta.springboot.language.nodejs;

import com.eclipsesource.v8.V8;

public class javaCallJavaScriptByV8 {
   public static void main(String args[]){

      helloWorld();

   }

    /**
     * 第一个基本例子 helloWorld
    */
   private static void helloWorld(){
      V8 v8 = V8.createV8Runtime();
      //执行一段 js 代码
      int result = v8.executeIntegerScript(""
              + "var hello = 'hello, ';\n"
              + "var world = 'world!';\n"
              + "hello.concat(world).length;\n");
      System.out.println(result);
      v8.release(true);
   }

   /**
    * 做一个简单的计算
    */
   private static void calculate(){



   }

}