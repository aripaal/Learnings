package com.mylearnings.designpattern;

public class AbstractFactoryPattern {
    interface Animal{
        public void makeNoise();
    }

    static class Lion implements Animal {
        String name;

        public Lion(String name) {
            this.name = name;
        }

        public void makeNoise(){
            System.out.println(name+" says Roar");
        }
    }
    static class Tiger implements Animal {
        String name;

        public Tiger(String name) {
            this.name = name;
        }

        public void makeNoise(){
            System.out.println(name+" says Meow");
        }
    }

    interface AnimalFactory{
        public Animal getAnimal();
    }

    static class TigerFactory implements AnimalFactory{

        @Override
        public Animal getAnimal() {
            return new Tiger("Leo");
        }
    }
    static class LionFactory implements AnimalFactory{

        @Override
        public Animal getAnimal() {
            return new Lion("Stitch");
        }
    }

    static class Factory{
        public static Animal getAnimal(AnimalFactory animalFactory){
            return animalFactory.getAnimal();
        }

    }

    public static void main(String ...args){

        Factory.getAnimal(new TigerFactory()).makeNoise();
    }

}
