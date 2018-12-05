/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-11-13 16:40
 **/

package pers.roamer.spring.cloud.feign.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.roamer.spring.cloud.feign.client.service.HiService;

@RestController
public class HiController {
    @Autowired
    HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "forezp" , required = false) String name){
        return hiService.sayHi(name);
    }
}
