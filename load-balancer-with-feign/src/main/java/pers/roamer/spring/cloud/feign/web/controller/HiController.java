/**
 * @program: resilience4j
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-17 17:36
 **/

package pers.roamer.spring.cloud.feign.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.roamer.spring.cloud.feign.service.HiService;

@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @GetMapping("/sayHi")
    public String sayHi(@RequestParam(defaultValue = "徐泽宇", required = false)String name){
        return hiService.sayHi(name);
    }
}
