package com.mylearnings.files;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/5/17.
 */
public class FileCopyTest {
    File source,dest;
    FileCopy copy;
    @Before
    public void setUp(){
        source= new File("MyTest.txt");
        dest= new File("MyTestCopied.txt");
        copy=new FileCopy();
    }
    @Test
    public void copyWithInputStream(){
        copy.copyWithInputStream(source,dest);
        doTest();
    }
    @Test
    public void copyWithReader(){
        copy.copyWithReader(source,dest);
        doTest();
    }
    @Test
    public void scanFreq(){
        Map<String,Integer> map=copy.findFreq(source);
        System.out.println(map);
        assertTrue(map.get("file")==3);

    }

    public void doTest(){

        assertTrue("Destination File does not exist",dest.exists());
        assertTrue("Size of the files do not match",source.length()==dest.length());
        assertTrue("Copied file could not be deleted",dest.delete());
    }
}