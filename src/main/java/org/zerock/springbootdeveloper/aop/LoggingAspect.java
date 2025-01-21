package org.zerock.springbootdeveloper.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* org.zerock.springbootdeveloper.service.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        System.out.println("[LOG] 메서드 실행 시작: " + joinPoint.getSignature().getName());

        Object result;
        try {
            result = joinPoint.proceed(); // 실제 비즈니스 로직 실행
            System.out.println("[LOG] 메서드 실행 성공: " + joinPoint.getSignature().getName());
        } catch (Exception ex) {
            System.out.println("[LOG] 메서드 실행 중 예외 발생: " + ex.getMessage());
            throw ex;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("[LOG] 메서드 실행 시간: " + (endTime - startTime) + "ms");

        return result;
    }
}
