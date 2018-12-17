/**
 * @program: resilience4j
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-17 17:34
 **/

package pers.roamer.spring.cloud.feign.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {
    @Autowired
    IEurekaClientFeign iEurekaClientFeign;

    public String sayHi(String name){
        return iEurekaClientFeign.syaHiFromEurekaClient(name);
    }
}
