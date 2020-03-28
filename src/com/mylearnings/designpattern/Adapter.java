package com.mylearnings.designpattern;

/**
 * Created by ronnie on 4/5/17.
 */
public class Adapter {
    public class Volts{
        int volt;

        public Volts(int volt) {
            this.volt = volt;
        }

        public int getVolt() {
            return volt;
        }

        public void setVolt(int volt) {
            this.volt = volt;
        }
    }

    public class SocketIndia{
        Volts v;
        public SocketIndia() {
            v= new Volts(240);
        }

        public Volts getVolt(){
            return v;
        }


    }

    public static class SocketAdapter{
        SocketIndia s;

        Volts get120Volts(){
           Volts v= s.getVolt();
           v.setVolt(120);
           return v;

        }
        Volts get10Volts(){
            Volts v = s.getVolt();
            v.setVolt(10);
            return v;
        }

    }

}
