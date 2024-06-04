package co.com.acme;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(servers = @Server(url = "http://localhost:8081", description = "Local server"))
public class FabricaAcmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricaAcmeApplication.class, args);
	}


}
