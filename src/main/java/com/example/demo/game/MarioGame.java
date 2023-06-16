package com.example.demo.game;

public class MarioGame implements GamingConsole {
    public void up(){
        System.out.println("JUMP");
    }

    public void down(){
        System.out.println("DOWN");
    }

    public void left(){
        System.out.println("Goback");
    }

    public void right(){
        System.out.println("Accelerate");
    }

}
