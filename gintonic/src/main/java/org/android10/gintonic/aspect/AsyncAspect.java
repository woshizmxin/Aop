package org.android10.gintonic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Tony Shen on 16/3/23.
 */
@Aspect
public class AsyncAspect {

    @Pointcut("@within(org.android10.gintonic.annotation.Asyc)||@annotation(org"
            + ".android10.gintonic.annotation.Asyc)")
    public void onAsyncMethod() {
    }


    @Around("execution(!synthetic * *(..)) && onAsyncMethod()")
    public void doAsyncMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        asyncMethod(joinPoint);
    }

    private void asyncMethod(final ProceedingJoinPoint joinPoint) throws Throwable {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    joinPoint.proceed();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }).start();
    }
}