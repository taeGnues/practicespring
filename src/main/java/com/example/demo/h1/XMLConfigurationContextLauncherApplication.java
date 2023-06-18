package com.example.demo.h1;

import com.example.demo.game.GameRunner;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class XMLConfigurationContextLauncherApplication {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("contextConfiguration.xml"); // XML로 정의.
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("game"));

        context.getBean(GameRunner.class).run();
        // Java 설정에서 사용되는 걸 XML에서 이용 가능. 하지만 지금은 거의 안쓰임. => Annotation으로 해결함!
    }
}
