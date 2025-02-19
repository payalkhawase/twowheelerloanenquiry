package in.shriram.dreambiketwowheelerloan.model;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class TwoWheelerLoanEnquiryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwoWheelerLoanEnquiryApplication.class, args);
	}

}
