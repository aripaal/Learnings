package com.mylearnings.designpattern;

public class FactoryPattern {
    interface Animal{
        public void makeNoise();
    }

    static class Lion implements Animal{
        public void makeNoise(){
            System.out.println("Roar");
        }
    }
    static class Tiger implements Animal{
        public void makeNoise(){
            System.out.println("Meow");
        }


    }
    static class AnimalFactory{

        public static Animal animalFactory(String animal){
            if(animal.equalsIgnoreCase("Lion"))
                return new Lion();
            else
                return new Tiger();
        }
    }

    public static void main(String ...args){

        AnimalFactory.animalFactory("Lion").makeNoise();
        AnimalFactory.animalFactory("Tiger").makeNoise();
    }


}

