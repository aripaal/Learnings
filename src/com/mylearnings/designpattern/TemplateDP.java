package com.mylearnings.designpattern;

public class TemplateDP {
    public static abstract class Game{
        abstract void initialise();
        abstract void configure();
        abstract void run();

        public void play(){
            configure();
            initialise();
            run();
        }

    }

    public static class Cricket extends Game{

        @Override
        void initialise() {
            System.out.println("init");
        }

        @Override
        void configure() {
            System.out.println("config");
        }

        @Override
        void run() {
            System.out.println("running");
        }
    }

    public static void main(String... args){
        Cricket c = new Cricket();
        c.play();
    }
}
