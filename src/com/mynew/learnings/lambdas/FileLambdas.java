package com.mynew.learnings.lambdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Comparator;

/**
 * Created by ronnie on 7/16/17.
 */
public class FileLambdas {

    static FileFilter fileFilter = f->f.getName().endsWith("java");
    static Comparator<String> comparator = (t1,t2)-> t1.compareTo(t2);
    public static void main(String... args){
        File file = new File("/Users/ronnie/IdeaProjects/Learnings/src/com/mynew/learnings/lambdas");
       File[] files= file.listFiles(fileFilter);

       for(File f:files){
           System.out.println(f.getName());
       }

    }
}
