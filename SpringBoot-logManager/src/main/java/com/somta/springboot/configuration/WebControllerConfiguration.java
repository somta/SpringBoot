package com.somta.springboot.configuration;

import com.google.gson.Gson;
import com.somta.springboot.web.controller.LogConttoller;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Description: AOP统一处理Web请求日志
 * @Date: 2019/9/5
 * @Author: 明天的地平线
 * @Blog: https://somta.com.cn/index
 * @Version: 1.0.0
 */
@Aspect//声明一个切面
@Component
public class WebControllerConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(WebControllerConfiguration.class);

    private Gson gson = new Gson();

    /**
     * 定义一个切点 匹配com.somta.springboot.web.controller包下的所有类的所有方法
     */
    @Pointcut("execution(public * com.somta.springboot.web.controller.*.*(..))")//定义所有方法的日志记录
    //@Pointcut("@annotation(com.somta.springboot.configuration.LogStore)")//定义可插拔的的注解式的日志记录
    public void controllerLogAspect() {

    }

    /**
     * 前置通知，方法调用前被调用
     *
     * @param joinPoint
     */
    @Before("controllerLogAspect()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("前置通知执行.....");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 记录下请求内容
        logger.info("请求IP : " + request.getRemoteAddr());
        logger.info("请求URL : " + request.getRequestURL().toString());
        logger.info("请求类型 : " + request.getMethod());
        logger.info("请求类方法:"+joinPoint.getSignature());
        logger.info("请求类方法参数:"+ gson.toJson(joinPoint.getArgs()));
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //可以将请求日志记录到数据库、ES等
    }

    /**
     * 处理完请求返回内容
     *
     * @param ret
     * @throws Throwable
     */
    @AfterReturning(returning = "ret", pointcut = "controllerLogAspect()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        logger.info("方法的返回值 : " + gson.toJson(ret));
    }

    /**
     * 后置异常通知
     *
     * @param jp
     */
    @AfterThrowing("controllerLogAspect()")
    public void doThrows(JoinPoint jp) {
        logger.info("方法异常时执行.....");
    }

    /**
     * 后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
     *
     * @param jp
     */
    @After("controllerLogAspect()")
    public void doAfter(JoinPoint jp) {
        logger.info("后置通知执行.....");
    }

    /**
     * 环绕通知,环绕增强，相当于MethodInterceptor
     *
     * @param pjp
     * @return
     */
    @Around("controllerLogAspect()")
    public Object doArround(ProceedingJoinPoint pjp) {
        logger.info("环绕通知执行.....");
        try {
            Object o = pjp.proceed();
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

}