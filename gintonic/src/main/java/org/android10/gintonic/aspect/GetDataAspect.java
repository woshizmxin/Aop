package org.android10.gintonic.aspect;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Tony Shen on 16/3/23.
 */
@Aspect
public class GetDataAspect {

    private static final String POINTCUT_ON = "execution(* *..*.transData*(..))";

    @Pointcut(POINTCUT_ON)
    public void logForActivity() {
    }

    @Around("logForActivity()")
    public Object weaveOnJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        return asyncMethod(joinPoint);
    }

    private Object asyncMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object object : joinPoint.getArgs()) {
            Log.d("jamal.jo", "############onData: " + object.toString());
        }
        return joinPoint.proceed();
    }
}