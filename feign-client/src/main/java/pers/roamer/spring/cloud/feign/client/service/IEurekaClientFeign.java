package pers.roamer.spring.cloud.feign.client.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pers.roamer.spring.cloud.feign.client.config.FeignConfig;

/**
 * @author roamer
 */
@FeignClient(value = "service-hi" , configuration = FeignConfig.class , fallback = HiServiceHystrixRollback.class)
public interface IEurekaClientFeign {

    @GetMapping("/hi")
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);

}
