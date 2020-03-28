package com.mylearnings.files;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/14/17.
 */
public class FileExampleTest {
    File f;
    FileExample fileExample;


    @Before
    public void setUp(){
        f=new File("filexample.txt");
        fileExample=new FileExample(f);

    }
    @Test
    public void fileReadTest(){
        fileExample.fileRead();


    }

}