package com.example.demo.e1;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class NormalClass{

}
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE) // 프로토타입 클래스
@Component
class PrototypeClass{

}


@Configuration
@ComponentScan
public class BeanScopesLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BeanScopesLauncherApplication.class);
        System.out.println(context.getBean(NormalClass.class));
        System.out.println(context.getBean(NormalClass.class));
        // 2번 호출시 NormalClass@3943a2be로 모두 동일한 해시코드가 나타남!!! => 항상 같은 인스턴스

        System.out.println(context.getBean(PrototypeClass.class)); // 호출할때마다 새로운 bean을 가져옴.
        System.out.println(context.getBean(PrototypeClass.class));
        System.out.println(context.getBean(PrototypeClass.class));
//        com.example.demo.e1.PrototypeClass@343570b7
//        com.example.demo.e1.PrototypeClass@157853da
//        com.example.demo.e1.PrototypeClass@71c3b41 호출할때마다 새로운 Bean 인스턴스가 나옴.


    }
}
