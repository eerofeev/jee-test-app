package com.gepardec.jeetestapp.utils;

import org.slf4j.Logger;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Duration
public class DurationInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ic){
        try{
            long ts = System.currentTimeMillis();
            Object result = ic.proceed();
            ts = System.currentTimeMillis() - ts;
            logger.info("Duration of call " + ic.getMethod().getDeclaringClass().getSimpleName() + "#" + ic.getMethod().getName() + " is " + ts + " ms");
            return result;
        } catch (Exception e){
            logger.error("error", e);
            return null;
        }

    }
}
