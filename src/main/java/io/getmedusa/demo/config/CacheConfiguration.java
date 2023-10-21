package io.getmedusa.demo.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;

@Configuration
@EnableCaching
public class CacheConfiguration {

    @Bean
    @Primary
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager("dogsInHouseByNameAndLang","dogsInHouse");
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(200)
                .expireAfterAccess(Duration.ofDays(30))
                .maximumSize(500));
        return cacheManager;
    }
}
