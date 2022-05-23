package edu.smu.michaelkleincloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MichaelKleinCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MichaelKleinCloudConfigServerApplication.class, args);
	}

}
