package com.example.demo.game;

import org.springframework.stereotype.Component;

public class PackManGame implements GamingConsole {

    @Override
    public void up() {
        System.out.println("UP");
    }

    @Override
    public void down() {
        System.out.println("Down");
    }

    @Override
    public void left() {
        System.out.println("Left");
    }

    @Override
    public void right() {
        System.out.println("Right");
    }
}
