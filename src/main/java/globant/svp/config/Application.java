package globant.svp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages ={"globant.svp.rest.controller", "globant.svp.rest.error", "globant.svp.core"})
public class Application /*extends SpringBootServletInitializer*/ {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Override
	protected final SpringApplicationBuilder configure(
			final SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}*/
}
