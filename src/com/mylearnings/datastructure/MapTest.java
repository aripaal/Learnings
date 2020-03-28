package com.mylearnings.datastructure;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/8/17.
 */
public class MapTest {
    Map<Integer,String> mymap;
    @Before
    public void setUp() throws Exception {

        mymap = new Map<>();
    }
    @Test
    public void testMap() throws Exception {
        mymap.put(1,"Arijit");
        mymap.put(2,"Rekha");
        mymap.put(3,"Baba");
        mymap.put(4,"Kolar");

        assertTrue(mymap.get(3).equals("Baba"));
        assertTrue(mymap.get(2).equals("Rekha"));
    }
    @Test
    public void testOverWrite(){
        assertNull(mymap.put(1,"Arijit"));
        assertNull(mymap.put(2,"Rokha"));
        assertTrue(mymap.get(2)=="Rokha");
        assertTrue(mymap.put(2,"Rekha")=="Rokha");
    }
    @Test
    public void testSizeIncrement() throws Exception {
        assertTrue(mymap.getArraySize()==5);
        mymap.put(1,"Arijit");
        mymap.put(2,"Rekha");
        mymap.put(3,"Baba");
        mymap.put(4,"Kolar");
        mymap.put(5,"Maha Lakshmi");
        assertTrue(mymap.getArraySize()==10);
        mymap.put(6,"Matarani");

    }


}