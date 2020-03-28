package com.mylearnings.files;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ronnie on 4/5/17.
 */
public class FileCopy {
    public void copyWithInputStream(File source, File dest){
        try(
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
        ){
            byte buffer[] = new byte[1024];
            int len=0;
            while((len=bis.read(buffer))>0){
                bos.write(buffer,0,len);
            }

        }catch(IOException e){}
    }
    public void copyWithReader(File source, File dest) {
        try(
                BufferedReader br = new BufferedReader(new FileReader(source));
                BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
        ){
            String line=null;
            while((line=br.readLine())!=null){
                bw.write(line);
            }

        }catch(IOException e){}

    }

    public Map<String,Integer> findFreq(File source) {
        Map<String,Integer> mapFreq = new HashMap<>();
        try(
                Scanner scanner=new Scanner(new BufferedReader(new FileReader(source)));
        ){
            while(scanner.hasNext()){
                String value=scanner.next();
                Integer count=mapFreq.get(value);
                if(count==null)
                    mapFreq.put(value,1);
                else{
                    mapFreq.put(value,++count);
                }
            }

        }catch(IOException e){

        }
        return mapFreq;
    }


}
