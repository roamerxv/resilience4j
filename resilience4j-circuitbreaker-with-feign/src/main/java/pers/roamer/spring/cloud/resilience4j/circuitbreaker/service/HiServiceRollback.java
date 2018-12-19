/**
 * @program: resilience4j
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-19 09:55
 **/

package pers.roamer.spring.cloud.resilience4j.circuitbreaker.service;

import org.springframework.stereotype.Component;

@Component
public class HiServiceRollback implements  IEurekaClientFeign {

    @Override
    public String syaHiFromEurekaClient(String name){
        return "Hi, " + name + ", 无法调用，进入熔断的回滚处理！！";
    }
}
