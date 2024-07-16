/**
 * Created By Eng. Pius Obonyo
 * Date: 7/4/24
 * Time: 11:05 PM
 */

package com.pius.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}

