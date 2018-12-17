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
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;

@Configuration
@EnableFeignClients
@Slf4j
public class FeignClientsConfigurationCustom implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.debug("MyRequestInterceptor apply begin.");
        try {
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            if (null != sessionId) {
                requestTemplate.header("Cookie", "SESSION=" + sessionId);
            }
        } catch (Exception e) {
            log.error("MyRequestInterceptor exception: ", e);
        }
    }

}
