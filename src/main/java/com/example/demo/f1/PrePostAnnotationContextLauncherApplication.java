package com.example.demo.f1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency){ // 초기화되기전에 의존성을 준비함!
        super();
        this.someDependency = someDependency;
        System.out.println("All dependency ready!"); // 이 메소드도 호출됨.
    }
    // Spring은 자동으로 의존성을 연결하고, 의존성을 자동 연결하는대로 Spring에서는 PostConstruct를 어노테이션한 메서드를 호출함!
    @PostConstruct // 의존성 주입이 완료된 후 실행해야하는 매소드. 이때 Bean이 로드됨
    public void initialize(){
        SomeDependency.getReady();
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("clean up!");
    }
    // 인스턴스를 삭제중임을 알리는 어노테이션 앱 종료 전 Bean을 삭제되기전. 어노테이션이나 메서드는 보유하고 있던 리소스를 자동으로 지워줌.
    // 또한 빈이 삭제되기 전에 나타나는 함수.(Bean이 삭제되기전에, 어플리케이션 컨테이너가 삭제되기전에 사용할 수 있음.) (활성화된 자동 연결 삭제)


}

@Component
class SomeDependency{
    public static void getReady() { // 의존성 준비가 완료되면 의존성이 초기화됨.
        System.out.println("Some logic using here");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
