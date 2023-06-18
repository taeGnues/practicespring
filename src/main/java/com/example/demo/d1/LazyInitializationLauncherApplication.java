package com.example.demo.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{

} // bean 생성

@Component
@Lazy
class ClassB{
    private ClassA classA;
    public ClassB(ClassA classA){
        //Logic
        System.out.println("Some Initialization logic");
        this.classA=classA;

    } // bean 초기화

    public void doSomething(){
        System.out.println("Something happens..");
    }
}

@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(com.example.demo.d1.LazyInitializationLauncherApplication.class);
        System.out.println("completed");
        context.getBean(ClassB.class).doSomething(); // 클래스 B을 사용하려고 할때 초기화가 됨.
    }
}
