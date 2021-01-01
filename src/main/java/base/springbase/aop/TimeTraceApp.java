package base.springbase.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component //부가적인 로직의 경우 가독성을 위해 SpringConfig 에 직접 등록하는 경우도 많다.
public class TimeTraceApp {

    @Around("execution(* base.springbase..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toLongString());
        try{
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+joinPoint.toLongString()+" " + timeMs + "ms");
        }
    }
}
