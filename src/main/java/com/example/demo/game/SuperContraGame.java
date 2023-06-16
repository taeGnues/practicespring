package com.example.demo.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole{
    public void up(){
        System.out.println("UP");
    }

    public void down(){
        System.out.println("SIT DOWN");
    }

    public void left(){
        System.out.println("Goback");
    }

    public void right(){
        System.out.println("Accelerate");
    }
}
