package com.mylearnings.designpattern;
import java.util.*;


/**
 * Created by ronnie on 3/10/17.
 */
public final class Immutable {
    private int number;
    private String name;
    private List<String> immutableNames;

    public Immutable(int number,String name,List<String> immutableNames){
        this.number=number;
        this.name=name;
        if(immutableNames==null){
            throw new IllegalArgumentException("List cannot be null");
        }
        this.immutableNames=new ArrayList<>(immutableNames);


    }

    public final int getNumber(){
        return number;
    }
    public final String getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Immutable{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", immutableNames=" + immutableNames +
                '}';
    }

    public final int getIndexOf(String value){
        for(int i=0;i<immutableNames.size();i++){
            if(immutableNames.get(i).equals(value)){
                return i;
            }

        }
        return -1;

    }

    static class Builder{
        private int number;
        private String name;
        private List<String> immutableNames;

        public Builder setNumber(int number) {
            this.number = number;
            return this;

        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setImmutableNames(List<String> immutableNames) {
            this.immutableNames = immutableNames;
            return this;
        }

        public Immutable build(){
            return new Immutable(this.number,this.name,this.immutableNames);

        }



        public static void main(String args[]){

            Builder builder = new Builder();
            List<String> names = new LinkedList<>();
            names.add("ekkha");
            names.add("oka");
            Immutable immutable = builder.setName("arijit").setNumber(34).setImmutableNames(names).build();
            System.out.println(immutable);

        }

    }




}
