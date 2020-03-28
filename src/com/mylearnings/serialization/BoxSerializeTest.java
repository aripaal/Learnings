package com.mylearnings.serialization;

import org.junit.Before;
import org.junit.Test;
import com.mylearnings.serialization.BoxSerialize.Ball;
import static org.junit.Assert.*;

/**
 * Created by ronnie on 3/31/17.
 */
public class BoxSerializeTest {

    BoxSerialize boxSerialize;
    String file = "box.ser";

    Ball testBall = new Ball(5);
    @Before
    public void setUp() throws Exception {
        boxSerialize=new BoxSerialize(1,2,4,testBall);

    }
    @Test
    public void testSerialize() throws Exception{

        boxSerialize.write(file);
        BoxSerialize box = boxSerialize.read(file);
        assertEquals(testBall,box.getBall());
        //System.out.println( Runtime.getRuntime().freeMemory()+ " "+Runtime.getRuntime().totalMemory());

    }


}