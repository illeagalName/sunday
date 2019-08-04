package com.seventh.sunday.config;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ami
 */
@Configuration
public class RedissonConfig {

    @Value("${redis.service.host}")
    private String redisHost;

    @Value("${redis.service.port}")
    private Integer redisPort;

    @Value("${redis.service.password}")
    private String redisPassword;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress("redis://" + redisHost + ":" + redisPort + "");
        if (StringUtils.isNotBlank(redisPassword)) {
            singleServerConfig.setPassword(redisPassword);
        }
        return Redisson.create(config);
    }

}