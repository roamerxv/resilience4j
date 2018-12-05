/**
 * @program: demo
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-11-27 16:18
 **/

package pers.roamer.spring.cloud.feign.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {
    @Autowired
    IEurekaClientFeign iEurekaClientFeign;

    public String sayHi(String name){
        return iEurekaClientFeign.sayHiFromClientEureka(name);
    }
}
