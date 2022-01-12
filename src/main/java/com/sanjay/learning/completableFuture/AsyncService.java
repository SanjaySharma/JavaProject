package com.sanjay.learning.completableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {


    private static Logger log = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    RestTemplate restTemplate;



    @Async()
    CompletableFuture<String> getLimit() throws InterruptedException{

        log.info("getLimit starts");

        String limit = restTemplate.getForObject("http://localhost:8080/limits1", String.class);

        log.info("limit, {}", limit);
        Thread.sleep(1000L);    //Intentional delay
        log.info("getLimit completed");
        return CompletableFuture.completedFuture(limit);
    }

    @Async()
    CompletableFuture<String> getCurrencyExchange() throws InterruptedException{

        log.info("getCurrencyExchange starts");

        String limit = restTemplate.getForObject("http://localhost:8000/currency-exchange", String.class);

        log.info("getCurrencyExchange, {}", limit);
        Thread.sleep(1000L);    //Intentional delay
        log.info("getCurrencyExchange completed");
        return CompletableFuture.completedFuture(limit);
    }

    @Async()
    CompletableFuture<String> getCurrencyConversion() throws InterruptedException{

        log.info("getCurrencyConversion starts");

        String limit = restTemplate.getForObject("http://localhost:8100/currency-conversion", String.class);

        log.info("getCurrencyConversion, {}", limit);
        Thread.sleep(1000L);    //Intentional delay
        log.info("getCurrencyConversion completed");
        return CompletableFuture.completedFuture(limit);
    }
}
