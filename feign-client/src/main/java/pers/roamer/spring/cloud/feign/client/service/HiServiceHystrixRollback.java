/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-11-15 17:58
 **/

package pers.roamer.spring.cloud.feign.client.service;

import org.springframework.stereotype.Component;

@Component
public class HiServiceHystrixRollback implements IEurekaClientFeign {

    @Override
    public String sayHiFromClientEureka(String name){
        return "Hi, " + name + ", 无法调用，进入熔断的回滚处理！！";
    }
}
