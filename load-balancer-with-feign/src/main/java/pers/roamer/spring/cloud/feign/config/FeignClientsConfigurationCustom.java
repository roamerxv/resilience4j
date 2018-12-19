/**
 * @program: resilience4j
 * @description:
 * @author: roamer-徐泽宇
 * @create: 2018-12-17 18:01
 **/

package pers.roamer.spring.cloud.feign.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Configuration
@Slf4j
public class FeignClientsConfigurationCustom implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.debug("MyRequestInterceptor apply begin.");
//        try{
//
//            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
//            if ( !sessionId.isEmpty()){
//                requestTemplate.header("Cookie","JSESSIONID=" + sessionId);
//            }
//        }catch(Exception e){
//            log.error("FeignClientsConfigurationCustom exception ",e);
//        }

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            log.debug("requestAttributes is null");
            return;
        }
        log.debug("requestAttributes is not null");
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                Enumeration<String> values = request.getHeaders(name);
                while (values.hasMoreElements()) {
                    String value = values.nextElement();
                    log.debug("\t header name is {}, value is  {}",name,value);
                    requestTemplate.header(name, value);
                }
            }
        }

    }

}
