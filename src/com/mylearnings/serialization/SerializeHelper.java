package com.mylearnings.serialization;

import java.io.*;

/**
 * Created by ronnie on 4/13/17.
 */
public class SerializeHelper {
    File f;
    SpaceSer ser;
    public SerializeHelper(File f,SpaceSer ser) {
        this.f = f;
        this.ser=ser;
    }

    public void serialize(){
        try(
                ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
        ){
            oos.writeObject(ser);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public SpaceSer deSerialize(){
        SpaceSer newSer=null;
        try(
                ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
        ){
           newSer=(SpaceSer) ois.readObject();
        }catch(ClassNotFoundException|IOException e){
            e.printStackTrace();
        }
        return newSer;
    }

}
