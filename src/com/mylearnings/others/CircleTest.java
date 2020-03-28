package com.mylearnings.others;

import com.mylearnings.datastructure.LinkedList;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by ronnie on 4/12/17.
 */
public class CircleTest {

    @Test
    public void testEquality(){
        Circle c1 = new Circle(2);
        Circle c2 = new Circle(3);
        Circle c3 = new Circle(2);

        assertTrue(c1.equals(c3));
        assertFalse(c1.equals(c2));

        assertTrue(c1.objEquals(c1));

    }

    @Test
    public void testCircular(){
        LinkedList<Circle> circular = new LinkedList<>();
        circular.addNode(new Circle(1));
        circular.addNode(new Circle(2));
        circular.addNode(new Circle(3));
        circular.addNode(new Circle(4));
        circular.addNode(new Circle(5));
        circular.addNode(new Circle(6));
        circular.addNode(new Circle(7));
        circular.addNode(new Circle(8));
        circular.addNode(new Circle(9));

        LinkedList.Node<Circle> ptr = circular.getFirst().getNext().getNext().getNext();//4
        System.out.println("ptr "+ptr.getValue());
        LinkedList.Node<Circle> last = circular.getLast();//9
        System.out.println("last "+last.getValue());
        last.setNext(ptr);
        System.out.println("last->next"+last.getNext().getValue());
        LinkedList.Node<Circle> cursor = circular.getFirst();
        int i=0;
        HashMap<Circle,Integer> circleIntegerHashMap= new HashMap<>();
        Integer indexPos;
        while((cursor.getNext())!=null){
            if((indexPos=circleIntegerHashMap.put(cursor.getValue(),i))==null){;
                ++i;cursor=cursor.getNext();

                continue;
            }
            System.out.println("Circular linkedList started at index:"+indexPos);
                break;
        }

    }


}