package com.mylearnings.files;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ronnie on 4/14/17.
 */
public class FileExample {

    File file;

    public FileExample(File file) {
        this.file = file;
    }

    public void fileRead(){

        try(
                Scanner s = new Scanner(new BufferedInputStream(new FileInputStream(file)));
        ){
            s.useDelimiter(",");
            while(s.hasNextLine()){
                System.out.println(s.nextLine());

            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }


}
