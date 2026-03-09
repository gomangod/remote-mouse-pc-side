package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class Mouseappv3Application {

	public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(Mouseappv3Application.class);

        builder.headless(false);

        ConfigurableApplicationContext context = builder.run(args);
        Server s = new Server();
        s.RUN();
	}

}
