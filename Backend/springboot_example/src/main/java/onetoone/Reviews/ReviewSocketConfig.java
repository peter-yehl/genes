package onetoone.Reviews;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class ReviewSocketConfig {
	@Bean
	public ServerEndpointExporter ServerEndpointExporter() {
		return new ServerEndpointExporter();
	}

}
