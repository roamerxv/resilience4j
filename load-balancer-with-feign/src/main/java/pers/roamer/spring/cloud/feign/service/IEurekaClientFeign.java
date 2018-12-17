package pers.roamer.spring.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "hi-service")
public interface IEurekaClientFeign {
    @GetMapping(value="/hi")
    String syaHiFromEurekaClient(@RequestParam(value = "name") String name);
}
