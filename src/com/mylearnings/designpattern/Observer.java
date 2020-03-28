package com.mylearnings.designpattern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ronnie on 4/4/17.
 */
public class Observer {

    public static class Subject{
        int state=0;
        List<Observable> observables=new ArrayList<>();
        public void attach(Observable o){
            observables.add(o);
        }

        public void changeState(int value){
            state=value;
            notifyAllObservers();
        }

        private void notifyAllObservers(){
            for (Observable o: observables)
                o.update(state);
        }

    }

    interface Observable{
        void update(int state);
    }

    public static class AObservable implements Observable{

        Subject s;

        public AObservable(Subject s) {
            this.s = s;
            s.attach(this);
        }

        @Override
        public void update(int state) {
            System.out.println("Aobserver:State has changed to ->"+state);
        }
    }
    public static class BObservable implements Observable{

        Subject s;

        public BObservable(Subject s) {
            this.s = s;
            s.attach(this);
        }

        @Override
        public void update(int state) {
            System.out.println("Bobserver:State has changed to ->"+state);
        }
    }
    public static void main(String... args){
        Subject s = new Subject();
        AObservable a = new AObservable(s);
        BObservable b = new BObservable(s);
        s.changeState(34);
        s.changeState(23);
    }

}
