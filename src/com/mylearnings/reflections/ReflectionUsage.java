package com.mylearnings.reflections;

import com.mylearnings.jdbc.Employee;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * Created by ronnie on 4/27/17.
 */
public class ReflectionUsage {
    public static void main(String... args){
        Class myclass = com.mylearnings.jdbc.Employee.class;
        Constructor[] constructors=myclass.getConstructors();

        for(Constructor constructor:constructors){
            System.out.println(constructor.getName());
            Class[] parameters=constructor.getParameterTypes();
            for(Class parameter: parameters)
                System.out.println(parameter.getName());

        }

        try {
            Constructor constructor = myclass.getConstructor(String.class,int.class);
            Employee employee=(Employee)constructor.newInstance("mymy",2);
            System.out.println(employee.toString());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
