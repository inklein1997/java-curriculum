package com.trilogyed.config.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "quote-service")
public interface QuoteClient {

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String getRandomQuote();
}
