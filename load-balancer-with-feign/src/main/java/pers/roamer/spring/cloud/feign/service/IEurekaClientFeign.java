package pers.roamer.spring.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: resilience4j
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-17 17:20
 **/
@FeignClient(value = "hi-service")
public interface IEurekaClientFeign {
    /**
     * 调用 eureka client 上的 restful 方法
     * @param name
     * @return
     */
    @GetMapping(value="/hi")
    String syaHiFromEurekaClient(@RequestParam(value = "name") String name);
}
