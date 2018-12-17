/**
 * @program: client
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-11-09 17:54
 **/

package pers.roamer.spring.cloud.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

@SpringBootApplication
@EnableRedisHttpSession
@EnableEurekaClient
@RestController
public class HiServiceApplication {
    @Autowired
    HttpSession httpSession;

    public static void main(String[] args) {
        SpringApplication.run( HiServiceApplication.class, args );
    }

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "roamer") String name) throws UnknownHostException {
        return "hi " + name + " ,i am from port:" + port +
                ". Session id 是:"+ httpSession.getId() +
                ", host is "+ InetAddress.getLocalHost().getHostAddress() +
                "，调用时间："+ new Date().toString();
    }
}
