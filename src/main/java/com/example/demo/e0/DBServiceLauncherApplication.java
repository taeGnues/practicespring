package com.example.demo.e0;

import com.example.demo.game.GamingLauncherApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
@ComponentScan("com.example.demo.e0")
public class DBServiceLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DBServiceLauncherApplication.class);

//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean(BusinessCalculationService.class).findMax());

    }
}
