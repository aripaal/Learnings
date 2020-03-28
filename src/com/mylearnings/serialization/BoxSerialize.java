package com.mylearnings.serialization;

import java.io.*;

/**
 * Created by ronnie on 3/31/17.
 */
public class BoxSerialize implements Serializable{
    int height,width,breadth;
    transient Ball ball;

    public BoxSerialize(int height, int width, int breadth, Ball ball) {
        this.height = height;
        this.width = width;
        this.breadth = breadth;
        this.ball = ball;
    }

    public void write(String file){
        try(
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))
        ){
            oos.writeObject(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public BoxSerialize read(String file){
        try(
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                ){
            BoxSerialize box =(BoxSerialize) ois.readObject();
            return box;
        }catch(IOException|ClassNotFoundException e){
                    e.printStackTrace();
        }
        return null;
    }

    private void writeObject(ObjectOutputStream oos){
        try {
            oos.defaultWriteObject();
            oos.writeInt(this.ball.r);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void readObject(ObjectInputStream ois){
        try{
            ois.defaultReadObject();
            this.ball=new Ball(ois.readInt());
        }catch(IOException|ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Ball getBall() {
        return ball;
    }

    public static class Ball{
        int r;

        public Ball(int r) {
            this.r = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Ball ball = (Ball) o;

            return r == ball.r;
        }

        @Override
        public int hashCode() {
            return r;
        }
    }

}
