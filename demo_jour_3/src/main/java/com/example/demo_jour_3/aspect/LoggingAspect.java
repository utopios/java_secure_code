package com.example.demo_jour_3.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("@annotation(com.example.demo_jour_3.annotation.Loggable)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Début de la méthode : " + methodName);
        Object result = joinPoint.proceed(args); // exécute la méthode cible
        logger.info("Fin de la méthode : " + methodName);
        return result;
    }
}
