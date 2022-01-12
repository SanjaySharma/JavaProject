package com.sanjay.learning.completableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
public class AsyncController {

    private static Logger log = LoggerFactory.getLogger(AsyncController.class);
    
    @Autowired 
    AsyncService asyncService;
    


    @GetMapping(value="/testAsync")
    public String testAsync() throws InterruptedException, ExecutionException {
        log.info("testAsynch Start");
        CompletableFuture<String> limitFeature = asyncService.getLimit();
        CompletableFuture<String> currencyExchangeFeature = asyncService.getCurrencyExchange();
        CompletableFuture<String> currencyConversionFeature = asyncService.getCurrencyConversion();

        CompletableFuture.allOf(limitFeature, currencyExchangeFeature, currencyConversionFeature).join();

        log.info("limitFeature--> " + limitFeature.get());
        log.info("currencyExchangeFeature--> " + currencyExchangeFeature.get());
        log.info("currencyConversionFeature--> " + currencyConversionFeature.get());

        return " limit: "+limitFeature.get() +" currencyExchange: "+currencyExchangeFeature.get() +" currencyConversion: "+currencyConversionFeature.get();
    }
}
