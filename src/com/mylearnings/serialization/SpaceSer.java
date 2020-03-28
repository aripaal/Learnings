package com.mylearnings.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by ronnie on 4/13/17.
 */
public class SpaceSer implements Serializable{

    private Coordinate xAxis=new Coordinate();
    transient private Coordinate yAxis=new Coordinate();
    private Coordinate zAxis=new Coordinate();

    public SpaceSer(int x,int y,int z){
        xAxis.setValue(x);
        yAxis.setValue(y);
        zAxis.setValue(z);
    }

    public Coordinate getxAxis() {
        return xAxis;
    }

    public Coordinate getyAxis() {
        return yAxis;
    }

    public Coordinate getzAxis() {
        return zAxis;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException{
        oos.defaultWriteObject();
    }

    private void readObject(ObjectInputStream ois) throws IOException,ClassNotFoundException{
        ois.defaultReadObject();
        this.yAxis=new Coordinate();
        yAxis.setValue(2);

    }


    public static class Coordinate implements Serializable{
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}
