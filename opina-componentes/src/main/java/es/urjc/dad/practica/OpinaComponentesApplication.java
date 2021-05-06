package es.urjc.dad.practica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Adicion de cache-distribuida
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig; 

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
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(true).setMembers(Collections.singletonList("127.0.0.1"));
        return config;
    }
	
	
}
