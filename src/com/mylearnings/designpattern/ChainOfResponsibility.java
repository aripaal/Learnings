package com.mylearnings.designpattern;

import sun.rmi.runtime.Log;

/**
 * Created by ronnie on 8/10/17.
 */
public class ChainOfResponsibility {

    public static abstract class Logger{
        public static final int INFO=0;
        public static final int WARN=1;

        protected int level;
        protected Logger nextLogger;

        abstract void write(String message);
        public void setNextLogger(Logger nextLogger){
            this.nextLogger=nextLogger;
        }
        public void logMessage(int level,String message){
            if(this.level==level)
                write(message);
            else if(nextLogger!=null)
                this.nextLogger.logMessage(level,message);
        }

    }
    public final static class FileLogger extends Logger{
        public FileLogger(int level) {
            this.level=level;
        }

        @Override
        void write(String message) {
            System.out.println("FileLogger:"+message);
        }
    }
    public final static class ConsoleLogger extends Logger{
        public ConsoleLogger(int level) {
            this.level=level;
        }

        @Override
        void write(String message) {
            System.out.println("ConsoleLogger:"+message);
        }
    }


    public static void main(String... args){

        Logger logger=new FileLogger(Logger.INFO);
        ConsoleLogger consoleLogger= new ConsoleLogger(Logger.WARN);
        logger.setNextLogger(consoleLogger);

        logger.logMessage(Logger.INFO,"File");
        logger.logMessage(Logger.WARN,"Console");

    }


}


