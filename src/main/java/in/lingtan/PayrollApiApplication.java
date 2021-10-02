package in.lingtan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
public class PayrollApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PayrollApiApplication.class, args);
	}

}
