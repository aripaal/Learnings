package com.mylearnings.cci;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/9/17.
 */
public class MatrixTest {
    Matrix matrix;
    @Before
    public void setUp() throws Exception {
        matrix=new Matrix(5);
    }

    @Test
    public void generate() throws Exception {
        matrix.generate();
        matrix.display();
       System.out.println("---");
        matrix.rotate();
        //matrix.rotate();
        matrix.display();
       // matrix.makerowColumnZero();
      //  matrix.display();
    }

}