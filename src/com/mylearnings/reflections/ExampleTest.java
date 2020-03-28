package com.mylearnings.reflections;

import org.junit.Test;

import java.lang.reflect.*;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 5/9/17.
 */
public class ExampleTest {

    @Test
    public void getMethods() throws Exception{
        Class example = Example.class;
//        Method[] methods = example.getMethods();
//        for(Method method:methods) {
//            int modifier = method.getModifiers();
//            if (Modifier.isPublic(modifier))
//                System.out.println(method.getName());
//        }

        Field[] fields = example.getDeclaredFields();

        for(Field field:fields){
            field.setAccessible(true);
            System.out.println(field.getName()+" "+field.getType());
        }

        Constructor constructor= example.getDeclaredConstructor();
        constructor.setAccessible(true);
        Example example1=(Example)constructor.newInstance();
        example1.method("mona");
        Field field = example.getDeclaredField("word");
        field.setAccessible(true);
        field.set(example1,"booboo");
        example1.method("mona");

        Method someMEthod=Example.class.getMethod("method",String.class);
        someMEthod.invoke(example1,"bambam");
        Example example3 = Example.class.getConstructor(String.class).newInstance("oma");

        Method methodsome= Example.class.getDeclaredMethod("saySomething", String.class);
        methodsome.setAccessible(true);
        methodsome.invoke(example3,"Hello");


        int[] ints = (int[]) Array.newInstance(int.class,3);
        Array.set(ints,0,33);
        Array.set(ints,1,34);
        System.out.println(ints[0]);
    }

}