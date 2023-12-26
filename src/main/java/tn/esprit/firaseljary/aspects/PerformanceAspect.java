package tn.esprit.firaseljary.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("execution(public * tn.esprit.firaseljary.services.*.*(..))")
    public Object executionTime(ProceedingJoinPoint pjp ) throws Throwable {
        StopWatch stopWatch  = new StopWatch();
        stopWatch.start();
        Object o = pjp.proceed();
        stopWatch.stop();
        String methodName = pjp.getSignature().getName();
        log.info("The runtime of the method ( {} ) =  {}  milliseconds.",methodName,stopWatch.getTotalTimeMillis());
        return o;

    }
}
