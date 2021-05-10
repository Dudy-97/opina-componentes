package es.urjc.dad.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Adicion de cache-distribuida
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig; 
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;

@EnableCaching
@SpringBootApplication
@EnableHazelcastHttpSession

public class OpinaComponentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpinaComponentesApplication.class, args);
	}

	@Bean
    public Config config() {

        Config config = new Config();

        JoinConfig joinConfig = config.getNetworkConfig().getJoin();

        //Multicast permite encontrar a otros usuarios con multicast de Hazelcast
        joinConfig.getMulticastConfig().setEnabled(true);

        return config;
    }
	
	@Bean
	public CacheManager cacheManager(){
		   return new ConcurrentMapCacheManager("cacheOC");
	}
	
	
}
