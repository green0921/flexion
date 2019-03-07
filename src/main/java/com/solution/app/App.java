package com.solution.app;

import com.flexionmobile.codingchallenge.integration.Purchase;
import com.solution.service.WebIntegration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Scanner;


@EnableJpaRepositories(basePackages = "com.solution.repository")
@ComponentScan(basePackages= "com.solution")
@EntityScan("com.solution.domain")
@EnableWebMvc
@SpringBootApplication
public class App {

    public static void main(String[] args) {
       // SpringApplication.run(App.class, args);
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) {
            callFlexionUrl(scanner.next());
        }
    }

    private static void callFlexionUrl(String itemId){
        WebIntegration webIntegration = new WebIntegration();
        Purchase purchase = webIntegration.buy(itemId);
        webIntegration.consume(purchase);
        System.out.println(webIntegration.getPurchases());
    }
}
