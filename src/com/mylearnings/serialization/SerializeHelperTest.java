package com.mylearnings.serialization;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/13/17.
 */
public class SerializeHelperTest {
    @Test
    public void serializeTest() throws Exception {
        File file=new File("space.ser");
        SpaceSer ser = new SpaceSer(1,2,3);
        SerializeHelper helper=new SerializeHelper(file,ser);

        helper.serialize();
        assertTrue(file.exists() && file.length()>0);

        SpaceSer ss = helper.deSerialize();
        assertTrue(ss.getxAxis().getValue()==1);
        assertTrue(ss.getyAxis().getValue()==2);
        assertTrue(ss.getzAxis().getValue()==3);

    }

}