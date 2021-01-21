//package com.atqgh.micro.acs.aspect;
//
//import com.atqgh.micro.acs.annotation.OpLog;
//import com.atqgh.micro.acsApi.entity.SysOperLog;
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.springframework.stereotype.Component;
//import java.lang.reflect.Method;
//
///**
// * 系统日志切面
// * @author qiguohui
// */
//@Slf4j
//@Aspect
//@Component
//public class OpLogAspect extends AspectSupport {
//
//
//    @Pointcut("@annotation(com.atqgh.micro.acs.annotation.OpLog)")
//    public void pointcut() {
//    }
//
//    /**
//     * 环绕通知
//     * @param joinPoint
//     */
//    @Around("pointcut()")
//    public Object saveSysLog(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        // 定义一个日志实体
//        SysOperLog sysOperLog = new SysOperLog();
//        // 开始时间
//        long startTime = System.currentTimeMillis();
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        //获取注解
//        OpLog opLog = method.getAnnotation(OpLog.class);
//        if(opLog != null){
//            String operation = opLog.operation();
//            //注解上的操作描述
//            sysOperLog.setOperation(operation);
//        }
//        Object obj = null;
//        log.info("========前置通知========");
//        try {
//            obj = joinPoint.proceed();
//        }catch (Exception e){
//            log.error(e.getMessage());
//        }
//        log.info("========后置通知========");
//        return obj;
//    }
//}
