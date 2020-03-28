package com.mynew.learnings.lambdas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ronnie on 7/31/17.
 */
public class LamEx1 {

    public static void main(String... args){
        try(FileReader fileReader = new FileReader("Persons.txt");
            BufferedReader br = new BufferedReader(fileReader);

        ){
           Stream<String> stream= br.lines();
            List<Persons> personsList=new LinkedList<>();
            stream.map(
                    t->{
                        String s[]=t.split(" ");
                        Persons p = new Persons(s[0].trim(),Integer.parseInt(s[1]));
                        return p;
                    }
            ).forEach(personsList::add);

            personsList.forEach(System.out::println);

        }
        catch(IOException e){
            e.printStackTrace();
        }


    }

}
