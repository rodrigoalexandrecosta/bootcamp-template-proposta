package br.com.zup.bootcamp.proposal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ProposalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProposalApiApplication.class, args);
    }

}
