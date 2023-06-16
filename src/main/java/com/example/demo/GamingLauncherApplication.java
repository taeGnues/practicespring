package com.example.demo;

import com.example.demo.game.GameRunner;
import com.example.demo.game.GamingConsole;
import com.example.demo.game.PackManGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.demo.game")
public class GamingLauncherApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(GamingLauncherApplication.class);

        context.getBean(GamingConsole.class).up();
        context.getBean(GameRunner.class).run();
    }
}
