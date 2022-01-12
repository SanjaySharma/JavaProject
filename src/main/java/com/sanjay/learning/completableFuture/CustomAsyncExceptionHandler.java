package com.sanjay.learning.completableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

public class CustomAsyncExceptionHandler  implements AsyncUncaughtExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Override
    public void handleUncaughtException(
            Throwable throwable, Method method, Object... obj) {

        log.info("Exception message - " + throwable.getMessage());
        log.info("Method name - " + method.getName());
        for (Object param : obj) {
            log.info("Parameter value - " + param);
        }
    }
}
